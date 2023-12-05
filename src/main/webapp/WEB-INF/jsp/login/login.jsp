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
        <span class="login-input-box">
            <div class="login-container place_chk">
                <div class="login-container-top">
                </div>
            </div>
            <div class="login-container place_chk">
                <div class="login-container-center">
                    <div><input type="text" class="container__input-box" id="loginId" placeholder="아이디"></div>
                    <div><input type="password" class="container__input-box" id="password" placeholder="비밀번호"></div>
                </div>
            </div>
            <span id="memberJoin" onclick="memberJoin()">회원가입</span>

            <div class="login-container place_chk">
                <div class="login-container-bottom">
                    <div class="place_chk">
                        <button class="container__input-box"
                            style="background-color: #0687f1; color: white;">로그인</button>
                    </div>

                    <div class="login__oauth-box place_chk">
                        <span class="login__radius-button" style="background-color: #00C73C;"
                            onclick="oauth('naver')"><img src="/images/naver.png"></span>
                        <span class="login__radius-button" style="background-color: #FDDC3F;"
                            onclick="oauth('kakao')"><img src="/images/kakao.png"></span>
                        <span class="login__radius-button" style="background-color: #f8f8f6;"
                            onclick="oauth('google')"><img src="/images/google.png"></span>
                    </div>
                </div>
            </div>
        </span>
    </div>
    <script>
        function oauth(type) {
            switch (type) {
                case 'naver':
                    location.href = "#";
                    break;
                case 'kakao':
                    alert("미구현");
                    location.href = "#";
                    break;
                case 'google':
                    alert("미구현");
                    location.href = "#";
                    break;
            }
        }

        function memberJoin() {
            location.href = "#";
        }
    </script>
</body>

</html>