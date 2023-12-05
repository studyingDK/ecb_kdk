<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <title id="boardName"></title>
    <link href="/css/common.css" rel="stylesheet" />
    <link href="/css/boardDetail.css" rel="stylesheet" />
    <link href="/css/board-common.css" rel="stylesheet" />
    <script src="/js/common.js"></script>
    <script src="/js/boardCommon.js"></script>
</head>

<body>
    <div class="wrap">
        <div class="cmm_content-nb">
            <span class="cmm__home-button cmm__home-button-detail" style="text-align: left;"
                onclick="homePageButton()">ECB</span>
            <div class="cmm_content-nb-container">
                <span class="cmm_content-nb-container-content" id=""> 게시판 홈 </span>
                <span class="cmm__text-vertical-line">|</span>
                <span class="cmm_content-nb-container-content" id=""><button class="cmm__login-button-detail"> 로그인
                    </button></span>
            </div>
        </div>
        <div class="boardDetail-container cmm_scorll-none">
            <div id="boardDetail-container-headPhoto">
                <img src="/images/20230731_082629.jpg">
            </div>
            <div class="boardDetail-container-contents">
                <div>456</div>
                <div class="boardDetail-container-contents-posts">
                    <button id="postWrite" onclick="postWrite('${boardType}')">글쓰기</button>
                </div>
            </div>
        </div>
    </div>
    <c:set var="boardType" value="${boardType}" />
    <input type="hidden" id="boardType" value="${boardType}">


    <script>
        let boardName; // 게시판 이름


        window.onload = function () {
            document.getElementById("boardName").innerText = "게시판 이름"
            console.log(document.getElementById("boardType").value);
        } 
    </script>
</body>

</html>