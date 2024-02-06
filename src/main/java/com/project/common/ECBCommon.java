package com.project.common;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ECBCommon {
	
	private static final Logger logger = LoggerFactory.getLogger(ECBCommon.class);
	
	public static String hashPassword(String password) {
        try {
            // SHA-256 알고리즘을 사용하는 MessageDigest 객체 생성
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // 비밀번호를 바이트 배열로 변환
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            // 해싱된 비밀번호를 16진수 문자열로 변환
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
        	logger.error("암호화가 제대로 이루어지지 않았습니다!" + e);
            e.printStackTrace();
            return null;
        }
    }
}
