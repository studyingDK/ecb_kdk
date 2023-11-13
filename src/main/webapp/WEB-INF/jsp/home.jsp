<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <title>안녕하세요! ECB 메인 페이지 입니다</title>
  <link href="/css/common.css" rel="stylesheet" />
</head>
<style>
  /********************************* header ************************************/
  /* 헤더 전체 */
  #home_header {
    background: url("/images/header-image.jpg") no-repeat center;
    /*margin: 10px 8%;*/
    height: 180px;
  }

  .home_header_content {
    display: block;
    text-align: center;
  }

  /*header end ================================================================*/




  /******************************** container **********************************/
  #home_container {
    margin: 10px 8%;
  }

  #home_container_loginGrid {
    display: grid;
    grid-template-columns: auto 18rem;
    text-align: center;
  }

  #loginBox {
    height: 8rem;
    border: 1px solid #D5D8DC;
    border-radius: 10px;
    margin: 0.5em;
    display: grid;
    justify-content: center;
  }

  #loginTop {
    color: rgb(88, 155, 233);
  }

  #login {
    cursor: pointer;
  }

  #loginBot {
    width: 14rem;
    height: 4rem;
    border: 1px solid rgb(88, 155, 233);
    background-color: rgb(88, 155, 233);
    margin: 0.7rem 0.8rem;
    border-radius: 14px;
    color: white;
    line-height: 3.8rem;
  }

  #grid50x2List {
    display: grid;
    grid-template-columns: 50% 50%;
  }

  .content-Item-border {
    border: 1px solid #D5D8DC;
    border-radius: 10px;
    margin: 0.5em;

  }

  /*container end =============================================================*/




  /********************************** footer ***********************************/
  #footer {
    background-color: #F5F6F7;
  }

  #footer_grid {
    margin: 0 8%;
    display: grid;
    grid-template-columns: 15% 85%;
  }

  #footer_right {
    padding-left: 5px;
    padding-top: 1rem;
    display: grid;
    grid-template-columns: 200px auto;
  }

  .textLine_margin {
    font-size: 20px;
    margin-bottom: 1em;
  }

  .footer_right-title {
    font-size: 25px;
  }

  .footer_right-content {
    font-size: 25px;
  }

  /*footer end ================================================================*/
  hr {
    /* #F19516 */
    background-color: #CECECE;
    border: none;
    position: relative;
    height: 0.5px;
  }

  .oauth-box {
    display: inline-block;
    overflow: hidden;
    /* 내용이 태그 바깥으로 벗어나지 않도록 설정 */
    position: relative;
    /* 포지션을 설정하여 이미지를 정확한 위치에 배치 */
    border: 1px solid #F19516;
    width: 4rem;
    height: 4rem;
    border-radius: 10px;
    cursor: pointer;
    margin: 0 1.6rem;
    text-align: center;
  }

  img {
    width: 100%;
    /* 이미지의 너비를 부모 요소인 .container의 너비와 같게 설정 */
    height: auto;
    /* 높이를 자동으로 조절하여 비율을 유지 */
  }

  #boardPage {
    cursor: pointer;
  }
</style>

<body>
  <div class="wrap">
    <div id="home_header">
      <div class="home_header_content">
        <div style="color: rgb(252, 252, 252);">
          <h1>제목 문구</h1>
        </div>
        <div>뭐넣음</div>
        <div>^^..</div>

      </div>
    </div>
    <hr class="header_align_line">


    <div id="home_container" class="place_chk">
      <div id="home_container_loginGrid" class="place_chk">
        <div class="content-Item-border">
          <button id="boardPage" onclick="boardPageMove()">게시판버튼 임시</button>
        </div>
        <div id="loginBox">
          <div id="loginTop"></div>
          <div id="loginBot">
            <div id="login" onclick="login()">Login</div>
          </div>
        </div>
      </div>
      <div id="grid50x2List">
        <div class="content-Item-border">리스트1</div>
        <div class="content-Item-border">리스트2</div>
      </div>
    </div>

    <hr class="header_align_line">

    <div id="footer">
      <div id="footer_grid">
        <div class="flex_vertical_center">
          <img src="/images/pngegg.png" width="150px;" height="150px;"
            style="background-color: EBEBEB; display: inline-block;">
        </div>
        <div id="footer_right">
          <div class="footer_right-title">Developers</div>
          <div class="footer_right-content">김도겸</div>
          <div class="footer_right-title">Contact</div>
          <div class="footer_right-content">kdkhelloworld@gmail.com<span class="text_verticalLine">|</span>
            CaffeineHolic_dk</div>
          <div class="footer_right-title">링크 걸기</div>
          <div class="footer_right-content">
          </div>
        </div>
      </div>
    </div>
  </div>
  <script>
    let $loginTop;
    let now;

    let year;
    let month; // 월은 0부터 시작하므로 1을 더하고 형식을 맞춥니다.
    let day;
    let hours;
    let minutes;
    let seconds;

    let formattedDate;

    window.onload = function () {
      console.log(formattedDate);
      $loginTop = document.getElementById("loginTop");
      nowTime();

      setInterval(nowTime, 1000);
    }

    function nowTime() {
      now = new Date();
      year = now.getFullYear();
      month = String(now.getMonth() + 1).padStart(2, '0'); // 월은 0부터 시작하므로 1을 더하고 형식을 맞춥니다.
      day = String(now.getDate()).padStart(2, '0');
      hours = String(now.getHours()).padStart(2, '0');
      minutes = String(now.getMinutes()).padStart(2, '0');
      seconds = String(now.getSeconds()).padStart(2, '0');
      let formattedDate = `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
      $loginTop.innerText = formattedDate;
    }

    function login() {
      location.href = "/login";
    }

    function boardPageMove() {
        let url = "/board/main";
        let goPost = document.createElement('form');

        let data = document.createElement('input');

        data.setAttribute('type', 'hidden');
        data.setAttribute('name', 'userid');
        data.setAttribute('value', "테스트");

        goPost.appendChild(data);
        goPost.setAttribute('method', 'post');
        goPost.setAttribute('action', url);
        document.body.appendChild(goPost);
        goPost.submit();
      }
  </script>
  <!-- <script src="sampleAPI.js"></script> -->
</body>

</html>