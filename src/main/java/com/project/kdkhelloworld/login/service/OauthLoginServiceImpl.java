package com.project.kdkhelloworld.login.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.project.kdkhelloworld.login.mapper.LoginMapper;

@Service
public class OauthLoginServiceImpl implements OauthLoginService {

	private static final Logger logger = LoggerFactory.getLogger(OauthLoginServiceImpl.class);

	@Resource(name = "LoginMapper")
	private LoginMapper mapper;

	/**
	 * 기존 Oauth 로그인 회원 판별 및 중복로그인 체크
	 */
	@Override
	public String existenceUser(String userId) {
		String result = "existence";

		Optional<String> userYn = Optional.ofNullable(mapper.selectOauthLoginCheck(userId));

		// 신규 회원
		if (!userYn.isPresent()) {
			return "non-existent";
		}

		// 중복 로그인
		if ("Y".equals(userYn.get().toString())) {
			// 기존 로그인 연결 해제
		}

		return result;
	}

	/**
	 * Oauth 회원 데이터 저장
	 */
	@Override
	public void oauthUserinfoSave(Map<String, Object> map) {
		// try catch랑 트랜잭션 처리 필요.
		mapper.insertUserinfo(map);
		mapper.insertUserinfoDetail(map);
	}

	/**
	 * 네이버 Oauth 로그인
	 */
	@Override
	public String naverOauth(String code, String state) {

		try {
			/* Naver Token 받아오기 (callback 부분) *************************************/
			String clientId = "xTs4gEJo0c6XxCkkSNJq";// 애플리케이션 클라이언트 아이디값";
			String clientSecret = "vn2EYlEBKM";// 애플리케이션 클라이언트 시크릿값";
			String redirectURI = URLEncoder.encode("http://localhost:8181/login/oauth/nRedirect", "UTF-8");
			String apiURL;

			apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
			apiURL += "client_id=" + clientId;
			apiURL += "&client_secret=" + clientSecret;
			apiURL += "&redirect_uri=" + redirectURI;
			apiURL += "&code=" + code;
			apiURL += "&state=" + state;
			String access_token = "";
			String refresh_token = "";

			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			int responseCode = con.getResponseCode();

			BufferedReader br;
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String inputLine;
			StringBuffer res = new StringBuffer();

			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();

			// 토큰 받아오기 성공
			if (responseCode == 200) {
				logger.debug("===================Naver Token Success===================");
				JSONObject result = new JSONObject(res.toString());
//				System.out.println(result.getString("access_token"));
//				System.out.println(result.getString("refresh_token"));
//				System.out.println(result.getString("token_type"));
//				System.out.println(result.getInt("expires_in"));

				/* 받은 토큰으로 유저 정보 받아오기 **************************************************/
				String naverApi = "https://openapi.naver.com/v1/nid/me";

				URL apiUrl = new URL(naverApi);
				HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

				connection.setRequestMethod("POST");
				connection.setRequestProperty("Authorization",
						result.getString("token_type") + " " + result.getString("access_token"));

				int response = connection.getResponseCode();

				BufferedReader reader;
				if (responseCode == HttpURLConnection.HTTP_OK) {
					reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				} else {
					reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				}

				String line;
				StringBuilder sb = new StringBuilder();
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}

				connection.disconnect();
				// 응답 데이터
				JSONObject tmpObject = new JSONObject(sb.toString());
				JSONObject resultUserInfo = tmpObject.getJSONObject("response");

				// 토큰값 받은거 어떻게 매번 인증할 것인지 로직 필요.

				// 받은 회원 데이터 기존에 있는 회원인지 판별 및 로그인
				String userYn = existenceUser(resultUserInfo.getString("id"));

				// 기존에 없는 회원이면 회원정보 insert / 로그인 처리
				if (userYn.equals("non-existent")) {

					// PCB에 맞게 데이터 세팅
					Map<String, Object> userInfoMap = new HashMap<>();
					String tmp = resultUserInfo.getString("gender");
					StringBuilder tmpSb = new StringBuilder();
					tmpSb.append(resultUserInfo.getString("birthyear"));
					tmpSb.append(resultUserInfo.getString("birthday").replace("-", ""));

					userInfoMap.put("sUserId", resultUserInfo.getString("id"));
					userInfoMap.put("sLoginId", resultUserInfo.getString("email"));
					userInfoMap.put("sPassword", "");
					userInfoMap.put("sNickname", resultUserInfo.getString("nickname"));
					userInfoMap.put("sUsername", resultUserInfo.getString("name"));
					userInfoMap.put("sPhoneNum", resultUserInfo.getString("mobile"));
					if ("M".equals(tmp)) {
						userInfoMap.put("sGender", "male");
					} else if ("F".equals(tmp)) {
						userInfoMap.put("sGender", "female");
					}
					userInfoMap.put("sUserBirth", tmpSb.toString());
					userInfoMap.put("sSecondaryId", resultUserInfo.getString("id"));
					userInfoMap.put("sSecondaryId", resultUserInfo.getString("id"));
					userInfoMap.put("sloginType", "N");

					oauthUserinfoSave(userInfoMap);

					logger.debug("=================== Newbee Naver Oauth ===================");
					return resultUserInfo.getString("id");
				} else {
					return resultUserInfo.getString("id");
				}
			}
			// 토큰 받아오기 실패
			else {
				logger.error("=================== Naver에서 토큰 받아오는 것에 실패하였습니다. ===================");
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	/**
	 * 카카오 Oauth 로그인
	 */
	@Override
	public String kakaoOauth(String code, String state) {
		try {
			/* kakao Token 받아오기 *************************************/
			String clientId = "ea962e765ec68d5d72cf854f317ed011";// 애플리케이션 클라이언트 아이디값";
			String clientSecret = "7bpdJU8TMNqJAiBqBpSqYhlDNEJfmEtu";// 애플리케이션 클라이언트 시크릿값";
			String redirectURI = URLEncoder.encode("http://localhost:8181/login/oauth/kRedirect", "UTF-8");
			String apiURL;

			apiURL = "https://kauth.kakao.com/oauth/token?grant_type=authorization_code&";
			apiURL += "client_id=" + clientId;
			apiURL += "&client_secret=" + clientSecret;
			apiURL += "&redirect_uri=" + redirectURI;
			apiURL += "&code=" + code;
			apiURL += "&state=" + state;
			String access_token = "";
			String refresh_token = "";

			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			int responseCode = con.getResponseCode();

			BufferedReader br;
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String inputLine;
			StringBuffer res = new StringBuffer();

			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();

			// 토큰 받아오기 성공
			if (responseCode == 200) {
				logger.debug("===================kakao Token Success===================");
				JSONObject result = new JSONObject(res.toString());
//							System.out.println(result.getString("access_token"));
//							System.out.println(result.getString("refresh_token"));
//							System.out.println(result.getString("token_type"));
//							System.out.println(result.getInt("expires_in"));

				/* 받은 토큰으로 유저 정보 받아오기 **************************************************/
				String kakaoApi = "https://kapi.kakao.com/v2/user/me";

				URL apiUrl = new URL(kakaoApi);
				HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

				connection.setRequestMethod("POST");
				connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
				connection.setRequestProperty("Authorization",
						result.getString("token_type") + " " + result.getString("access_token"));

				int response = connection.getResponseCode();

				BufferedReader reader;
				if (responseCode == HttpURLConnection.HTTP_OK) {
					reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				} else {
					reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				}

				String line;
				StringBuilder sb = new StringBuilder();
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}

				connection.disconnect();
				
				// 응답 데이터
				JSONObject tmpObject = new JSONObject(sb.toString());
				System.out.println("=================== tmpObject ==================="+tmpObject);
				String sUserId =  tmpObject.getBigInteger("id").toString();

				// 토큰값 받은거 어떻게 매번 인증할 것인지 로직 필요.

				// 받은 회원 데이터 기존에 있는 회원인지 판별 및 로그인
				String userYn = existenceUser(sUserId);

				// 기존에 없는 회원이면 회원정보 insert / 로그인 처리
				if (userYn.equals("non-existent")) {

					// PCB에 맞게 데이터 세팅
					Map<String, Object> userInfoMap = new HashMap<>();
					
					JSONObject tmp = tmpObject.getJSONObject("kakao_account");
					
					System.out.println("=================== tmp ==================="+tmp);
					JSONObject resultUserInfo = tmp.getJSONObject("profile");
					System.out.println("=================== resultUserInfo ==================="+resultUserInfo);
					
					// 지원 되는 데이터가 많이 없음..
					userInfoMap.put("sUserId", sUserId);
					userInfoMap.put("sLoginId", tmp.getString("email"));
					userInfoMap.put("sPassword", "");
					userInfoMap.put("sNickname", resultUserInfo.getString("nickname"));
					userInfoMap.put("sUsername", resultUserInfo.getString("nickname")); //닉네임으로 넣음
					//userInfoMap.put("sPhoneNum", resultUserInfo.getString("mobile"));
					//userInfoMap.put("sGender", resultUserInfo.getString("gender"));
					userInfoMap.put("sSecondaryId", tmp.getString("email"));
					userInfoMap.put("sloginType", "K");

					oauthUserinfoSave(userInfoMap);

					logger.debug("=================== Newbee Kakao Oauth ===================");
					return sUserId;
				} else {
					return sUserId;
				}
			}
			// 토큰 받아오기 실패
			else {
				logger.error("=================== kakao에서 토큰 받아오는 것에 실패하였습니다. ===================");
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
}
