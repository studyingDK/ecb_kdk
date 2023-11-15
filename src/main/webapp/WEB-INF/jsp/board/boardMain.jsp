<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>게시판</title>
    <link href="/css/common.css" rel="stylesheet" />
</head>
<style>
    /******************************** boardMain-header **********************************/

    #boradMain_header {
        display: grid;
        grid-template-columns: 175px auto;
        width: 100vw;
        height: 120px;
        border-bottom: 1px solid #CECECE;
    }

    #boradMain_header_left {
        text-align: center;
        height: 120px;
    }

    #boradMain_header_right {
        display: block;
        background: url('/images/speech_bubble1.png') no-repeat 6rem,
            url('/images/speech_bubble2.png') no-repeat 20rem,
            url('/images/speech_bubble2.png') no-repeat 34rem,
            url('/images/speech_bubble3.png') no-repeat 48rem,
            url('/images/speech_bubble3.png') no-repeat 62rem;
        height: 120px;
    }

    /*boardMain-header end =============================================================*/
    /******************************* boardMain-container ********************************/
    .boardMain_Container {
        display: flex;
        flex-direction: row;
        overflow: auto;
        flex: 1;
        margin-bottom: 1px;
    }

    #boardMain_container_nav {
        flex: 0 0 175px;
        border-right: 1px solid #CECECE;
    }

    #boardMain_container_nav>* {
        padding: 0.4rem 0.8rem;
        font-size: 1rem;
    }

    #boardMain_container_content {
        flex: 1 1 auto;
        overflow: auto;
    }

    #boardMain_container_content>* {
        height: 100%;
        overflow: auto;
    }

    /*boardMain-container end ==========================================================*/
</style>

<body>
    <div class="wrap">
        <div id="boradMain_header">
            <div id="boradMain_header_left" class="flex_vertical_center">
                <button id="mainPage_button" class="home_move_button" onclick="mainPage_button()">ECB</button>
            </div>
            <div id="boradMain_header_right">asd</div>
        </div>
        <div class="boardMain_Container">
            <div id="boardMain_container_nav">
                <div>게시판홈</div>
                <div>인기글</div>
                <div>게시판 목록</div>
            </div>
            <div id="boardMain_container_content">
                <div>내용1</div>
                <div>내용2</div>
                <div>내용3</div>
                <div></div>
            </div>
        </div>
    </div>
</body>
<script>
    function mainPage_button() {
        location.href = "/";
    }
</script>

</html>