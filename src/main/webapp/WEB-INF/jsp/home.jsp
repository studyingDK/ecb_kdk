<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <title>안녕하세요! ECB 메인 페이지 입니다</title>
  <link href="/css/common.css" rel="stylesheet" />
  <link href="/css/home.css" rel="stylesheet" />
  <!-- fontawesome -->
  <!-- <link href="/css/font-awesome.min.css" rel="stylesheet"> -->
  <script src="/js/common.js"></script>
  <script src="/js/home.js"></script>
  <!-- fontawesome -->
  <script src="https://kit.fontawesome.com/3337789680.js" crossorigin="anonymous"></script>
  <!-- <script src="sampleAPI.js"></script> -->
</head>

<body>
  <div class="wrap">
    <div id="home-header">
      <div id="home-header-content">
        <div>
          Expansion Community Board
        </div>
      </div>
    </div>

    <hr class="header__align-line">

    <div id="home-container">
      <div id="home-container__loging-grid">
        <div class="content__item-border">
          <div style="text-align: center;">🔥현재 인기글</div>
        </div>
        <div id="home-container__login-box">
          <div id="home-container__login-box-top"></div>
          <div id="home-container__login-box-bottom">
            <div id="login" onclick="login()">Login</div>
          </div>
        </div>
      </div>
      <div id="content__item-grid-two">
        <div class="content__item-border">
          <div style="text-align: center;">🏆유저 랭킹</div>
        </div>
        <div class="content__item-border">
          <button id="boardPage" onclick="boardMainPage()">게시판버튼 임시</button>
        </div>
      </div>
    </div>

    <hr class="header__align-line">

    <div id="footer">
      <div id="footer-container">
        <!-- <div id="footer_left">
          <img src="/images/pngegg.png">
        </div> -->
        <div id="footer-container-right">
          <div class="footer-container-right__title">Developers</div>
          <div class="footer-container-right__detail">김도겸</div>
          <div class="footer-container-right__title">Contact</div>
          <div class="footer-container-right__detail">kdkhelloworld@gmail.com<span
              class="cmm__text-vertical-line">|</span></div>
          <div class="footer-container-right__title"></div>
          <div class="footer-container-right__detail">
            <span class="home__social-icon">
              <a href="https://github.com/studyingDK" target="_blank"><i class="fa-brands fa-github"></i></a>
              <a href="https://studyingdk.tistory.com/" target="_blank"><i class="fa-regular fa-clipboard"></i></a>
            </span>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>

</html>