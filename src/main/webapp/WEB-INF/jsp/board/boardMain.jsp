<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>게시판</title>
    <link href="/css/common.css" rel="stylesheet" />
    <link href="/css/boardMain.css" rel="stylesheet" />
    <script src="/js/common.js"></script>
</head>

<body>
    <div class="wrap">
        <div class="boradMain-header">
            <div class="boradMain-header-left" class="cmm_flex-vertical-center">
                <button id="mainPage_button" class="cmm__home-button" onclick="homePageButton()">ECB</button>
            </div>
            <div class="boradMain-header-right">asd</div>
        </div>
        <div class="boardMain-container">
            <div id="boardMain-container-nav">
                <div>게시판홈</div>
                <div>인기글</div>
                <div>게시판 목록</div>
            </div>
            <div id="boardMain-container-content">
                <div>게시판 목록</div>
                <div id="boardList"></div>
                <button class="boardPostPage" onclick="boardPostPage('postpk')">임시 게시판 버튼 이동</button>
            </div>
        </div>
    </div>
    <c:set var="boardType" value="${boardType}" />
    <input type="hidden" id="boardType" value="${boardType}">
    <script>
        window.onload = function () {
            console.log("boardType=" + document.getElementById("boardType").value);
        }

        function boardPostPage(boradPostType) {
            let url = "/board/" + boradPostType;
            let goPost = document.createElement('form');

            let data = document.createElement('input');

            data.setAttribute('type', 'hidden');
            data.setAttribute('name', 'pstCtdCd');
            data.setAttribute('value', boradPostType);
            goPost.appendChild(data);

            goPost.setAttribute('method', 'post');
            goPost.setAttribute('action', url);
            document.body.appendChild(goPost);
            goPost.submit();
        }
    </script>
</body>

</html>