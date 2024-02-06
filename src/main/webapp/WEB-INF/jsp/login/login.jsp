<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>

<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<html>
<head>
    <title>로그인</title>
    <link href="/css/common.css" rel="stylesheet" />
    <link href="/css/login.css" rel="stylesheet" />
</head>

<body>
    <div style="text-align: center;">
        <div class="login-wrap-box">
            <div class="login-container-top">
            </div>
            <div class="login-container">
                <div class="container__item">
                    <div><input type="text" class="container__input-box" id="loginId" placeholder="아이디"></div>
                    <div><input type="password" class="container__input-box" id="password" placeholder="비밀번호"></div>
                </div>
                <div class="container__item">
                </div>
                <div class="container__item">
                    <div class="container__two-button-area">
                        <div></div>
                        <button class="container__two-button" onclick="loginSubmit()">로그인</button>
                        <button class="container__two-button" onclick="memberJoinPage()">회원가입</button>
                    </div>
                </div>
                <div class="container__item">
                    <div> <span class="login__lost-text" style="padding: 8px;">아이디 찾기</span><span
                            class="cmm__text-vertical-line">|</span>
                        <span class="login__lost-text">비밀번호 찾기</span>
                    </div>
                </div>
                <div class="container__item"></div>
                <div class="container__item">
                    <div class="login__oauth-box">
                        <span class="login__radius-button" style="background-color: #00C73C;"
                            onclick="oauth('naver')"><img src="/images/naver.png"></span>
                        <span class="login__radius-button" style="background-color: #FDDC3F;"
                            onclick="oauth('kakao')"><img src="/images/kakao.png"></span>
                        <span class="login__radius-button" style="background-color: #f8f8f6;"
                            onclick="oauth('google')"><img src="/images/google.png"></span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
    	function memberJoinPage() {
    		  let url = "/login/member";
    		  let goPost = document.createElement('form');
    		  
    		  goPost.setAttribute('method', 'post');
    		  goPost.setAttribute('action', url);
    		  document.body.appendChild(goPost);
    		  goPost.submit();
    	}
    
        function oauth(type) {
            switch (type) {
               case 'naver':
            	   <%
            	    String nClientId = "xTs4gEJo0c6XxCkkSNJq";
            	    String nRedirectURI = URLEncoder.encode("http://localhost:8181/login/oauth/nRedirect", "UTF-8");
            	    SecureRandom random1 = new SecureRandom();
            	    String state1 = new BigInteger(130, random1).toString();
            	    String apiURL1 = "https://nid.naver.com/oauth2.0/authorize?response_type=code"
            	         + "&client_id=" + nClientId
            	         + "&redirect_uri=" + nRedirectURI
            	         + "&state=" + state1;
            	    session.setAttribute("state", state1);
            	    %>
                   location.href = "<%=apiURL1%>"
                   break;
               case 'kakao':
            	   <%
	           	    String kClientId = "ea962e765ec68d5d72cf854f317ed011";
	           	    String kRedirectURI = URLEncoder.encode("http://localhost:8181/login/oauth/kRedirect", "UTF-8");
	           	    SecureRandom random2 = new SecureRandom();
	           	 	String state2 = new BigInteger(130, random2).toString();
	           	    String apiURL2 = "https://kauth.kakao.com/oauth/authorize?response_type=code"
	           	         + "&client_id=" + kClientId
	           	         + "&redirect_uri=" + kRedirectURI
	           	         + "&scope=profile_nickname,profile_image,account_email,gender,age_range,birthday"
	           	         + "&state=" + state2;
	           	    session.setAttribute("state", state2);
	           	    %>
                   location.href = "<%=apiURL2%>"
                   break;
               case 'google':
                   alert("미구현");
                   location.href = "#";
                   break;
            }
        }
        
        function loginSubmit() {
            let result = loginCheck().then((res) => {
            	console.log(res);
                if (res.userLoginYn == "N") {
                    alert(res.nickname+"님 환영합니다.");                   
                    
                    let url = "/home";
                    
                    let goPost = document.createElement('form');
          		 	let data = document.createElement('input');
          		 	let data2 = document.createElement('input');
          		 	let data3 = document.createElement('input');
        		 	data.setAttribute('type', 'hidden');
        		  	data.setAttribute('name', 'sLoginId');
                  	data.setAttribute('value', res.loginId);               	
        		 	data2.setAttribute('type', 'hidden');
        		  	data2.setAttribute('name', 'sPassword');
                  	data2.setAttribute('value', res.password);
        		 	data3.setAttribute('type', 'hidden');
        		  	data3.setAttribute('name', 'check');
                  	data3.setAttribute('value', "Y");
                  	goPost.appendChild(data);
                  	goPost.appendChild(data2);
                  	goPost.appendChild(data3);
                    goPost.setAttribute('method', 'post');
                    goPost.setAttribute('action', url);
                    document.body.appendChild(goPost);
                    goPost.submit();
                }
                else if (res.userLoginYn == "D"){
                	alert("접속중인 아이디 입니다.");
                	/* 중복 로그인 관련 로직 고민 필요. */
                	return false;
                }
                else {
                    alert("존재하지 않는 아이디거나 비밀번호가 다릅니다.");
                    return false;
                }
            });
        }

        function loginCheck() {
            let result = {
                sLoginId: document.getElementById('loginId').value,
                sPassword: document.getElementById('password').value,
                check : "N"
            }
            
            let url = "/login/local";

            return new Promise((resolve, reject) => {
                let xhr = new XMLHttpRequest();
                xhr.open("POST", url);
                xhr.setRequestHeader("Content-Type", "application/json");
                xhr.send(JSON.stringify(result));

                xhr.onload = () => {
                    if (xhr.status === 200) {
                        const res = xhr.response;
                        resolve(JSON.parse(res));
                    } else {
                        console.error(xhr.status, xhr.statusText);
                        console.log("error");
                        resolve('fail');
                    }
                };
            });
        }
        
        
    </script>
</body>

</html>