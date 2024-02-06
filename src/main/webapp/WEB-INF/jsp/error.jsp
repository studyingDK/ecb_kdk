<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>PAGE NOT FOUND</title>
</head>
<style>
    * {
        margin: 0;
    }

    body {
        background: url("/images/errorImage.jpg") no-repeat center;
        background-size: cover;
        width: 100vw;
        height: 100vh;
        color: rgb(250, 240, 240);
        font-family: gowunBatang;
        display: flex;
        align-items: center;
        justify-content: center;
    }


    @font-face {
        font-family: gowunBatang;
        src: url("/fonts/GowunBatang-Bold.ttf");
    }

    .title {
        text-align: center;
        font-size: 5rem;
    }

    .content {
        text-align: center;
        font-size: 2rem;
    }

    button {
        text-align: center;
        border: none;
        border-radius: 10px;
        background-color: none;
        font-family: gowunBatang;
        width: 10rem;
        height: 5rem;
        font-size: 2rem;
        cursor: pointer;
        transition: all 0 ease-out;
    }

    button:hover {
        background-color: black;
        color: white;
    }
</style>


<body>
    <div class="total">
        <div class="title">PAGE NOT FOUND</div>
        <div class="content">죄송합니다. 페이지를 찾을 수 없습니다.</div>
        <div class="content"> 존재하지 않는 주소를 입력하셨거나 </div>
        <div class="content"> 요청하신 페이지의 주소가 변경, 삭제되어 찾을 수 없습니다.</div>
        <div style="text-align: center; margin-top: 1rem;">
            <button style="margin: 1rem;" onclick="backButton()">뒤로가기</button>
            <button style="margin: 1rem;" onclick="mainButton()">메인화면</button>
        </div>
    </div>
    <script>
        function mainButton() {
            location.href = "/";
        }

        function backButton() {
        	window.history.back();
        }
    </script>
</body>

</html>