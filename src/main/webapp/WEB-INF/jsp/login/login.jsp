<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>

<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<html>
<head>
    <title>로그인</title>
    <link href="/css/common.css" rel="stylesheet" />
</head>
<style>
    .place_chk {
        border: 1.2px dashed black;
    }


    * body {
        font-family: gowunBatang;
        font-size: 1.5rem;
    }

    .loginBox {
        display: inline-block;
        position: relative;
        text-align: center;
        width: 32rem;
        height: 28rem;
        border: 1px solid #9ea2a8;
        border-radius: 10px;
        line-height: 0;
        padding: 0.5rem;
    }

    /* loginBox 3등분 */
    .loginContain {
        position: static;
        width: 100%;
        height: 9rem;
    }

    input::placeholder {
        font-size: 1.5rem;
        font-family: gowunBatang;
        color: #b1b5bd;
    }

    .inputBox {
        width: 20rem;
        height: 3.5rem;
        font-family: gowunBatang;
        font-size: 1.5rem;
        border: 1px solid #d8dadd;
    }

    #header {
        margin: 10px 8%;
    }

    /********************************* top ***************************************/
    .loginContain-top {}

    /*top end ===================================================================*/

    .loginContain-center {}


    /********************************* center ************************************/
    /*center end ================================================================*/


    #loginId {
        border-radius: 7px 7px 0 0;
    }

    #loginId:focus {
        width: 20rem;
        height: 3.5rem;
        border: 1px solid #0687f1;
        outline: #0687f1;
        border-radius: 7px 7px 0 0;
        caret-color: #0687f1;

    }

    #password {
        border-radius: 0 0 7px 7px;
    }

    #password:focus {
        width: 20rem;
        height: 3.5rem;
        border: 1px solid #0687f1;
        outline: #0687f1;
        border-radius: 0 0 7px 7px;
        caret-color: #0687f1;
    }

    /********************************* bottom ************************************/
    .loginContain-bottom {
        position: relative;
        width: 100%;
        height: 100%;
    }

    .radius-button {
        display: inline-block;
        overflow: hidden;
        /* 내용이 태그 바깥으로 벗어나지 않도록 설정 */
        position: relative;
        /* 포지션을 설정하여 이미지를 정확한 위치에 배치 */
        border: none;
        width: 4rem;
        height: 4rem;
        border-radius: 10px;
        cursor: pointer;
        margin: 0 1.6rem;

    }

    .oauth-box {
        position: absolute;
        width: 100%;
        text-align: center;
        bottom: 0rem;
    }

    img {
        width: 100%;
        /* 이미지의 너비를 부모 요소인 .container의 너비와 같게 설정 */
        height: auto;
        /* 높이를 자동으로 조절하여 비율을 유지 */
    }

    /*bottom end ================================================================*/
</style>

<body>
    <div style="text-align: center;">



        <span class="loginBox">
            <div class="loginContain place_chk">
                <div class="loginContain-top">

                </div>
            </div>

            <div class="loginContain place_chk">
                <div class="loginContain-center">
                    <div><input type="text" class="inputBox" id="loginId" placeholder="아이디"></div>
                    <div><input type="password" class="inputBox" id="password" placeholder="비밀번호"></div>
                </div>
            </div>
            <span id="memberJoin" onclick="memberJoin()">회원가입</span>

            <div class="loginContain place_chk">
                <div class="loginContain-bottom">
                    <div class="place_chk">
                        <button class="inputBox" style="background-color: #0687f1; color: white;">로그인</button>
                    </div>


                    <div class="oauth-box place_chk">
                        <span class="radius-button" style="background-color: #00C73C;" onclick="oauth('naver')"><img
                                src="/images/naver.png"></span>
                        <span class="radius-button" style="background-color: #FDDC3F;" onclick="oauth('kakao')"><img
                                src="/images/kakao.png"></span>
                        <span class="radius-button" style="background-color: #f8f8f6;" onclick="oauth('google')"><img
                                src="/images/google.png"></span>
                    </div>
                </div>
            </div>

        </span>


        <script>
            function oauth(type) {
                switch (type) {
                    case 'naver':
<%--                         location.href = "<%=apiURL%>"; --%>
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
                alert("미구현");
            }
        </script>
    </div>
</body>

</html>