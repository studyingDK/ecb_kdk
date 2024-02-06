<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>

<html>
<head>
    <title>ECB 회원가입</title>
    <link href="/css/common.css" rel="stylesheet" />
    <link href="/css/login__memberJoin.css" rel="stylesheet" />
    <script src="/js/login__memberJoin.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
    <div style="text-align: center;">
        <div class="memberJoin-wrap-box">
            <div class="memberJoin-container-top">
            </div>
            <div class="memberJoin-container">
                <div class="container__item">
                </div>
                <div class="container__two-button-area-top">
                    <input type="text" class="container__input-box-top" id="loginId" placeholder="아이디">
                    <div><input type="submit" class="memberJoin-button" onclick="loginIdValidation()" value="중복 확인">
                    </div>
                </div>
                <div><input type="password" class="container__input-box" id="password" placeholder="비밀번호"></div>
                <div class="container__two-button-area-middle">
                    <input type="text" class="container__input-box-middle" id="nickname" placeholder="닉네임">
                    <div><input type="submit" class="memberJoin-button" onclick="nicknameValidation()" value="중복 확인">
                    </div>
                </div>
                <div><input type="text" class="container__input-box" id="username" placeholder="이름"></div>
                <div><input type="text" class="container__input-box" id="userBirth" placeholder="생년월일 8자리">
                </div>
                <div class="container__input-box">
                    <div class="container__two-button-area">
                        <div class="selectRadio">
                            <div>
                                <input type="radio" id="national" name="country" value="N" checked="checked">
                                <label for="national">내국인</label>
                            </div>
                            <div>
                                <input type="radio" id="foreigner" name="country" value="F">
                                <label for="foreigner">외국인</label>
                            </div>
                        </div>
                        <div>
                            <select id="gender">
                                <option value="none">성별</option>
                                <option value="male">남자</option>
                                <option value="female">여자</option>
                                <option value="etc">그 외</option>
                                <option value="noAnswer">응답X</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div><input type="text" class="container__input-box" id="phoneNum" placeholder="전화번호">
                </div>
                <div class="container__input-box">
                    <div class="container__two-button-area">
                        <div><input type="text" class="container__input-box" id="zipCode" value="" disabled></div>
                        <div><button class="memberJoin-button" onclick="popupAddress()">주소 검색</button></div>
                    </div>
                    <div><input type="text" class="container__input-box" id="address" value="" disabled>
                    </div>
                    <div><input type="text" class="container__input-box" id="addressDetail" value="" disabled>
                    </div>
                </div>
                <div><input type="text" class="container__input-box" id="secondaryId" placeholder="복구 이메일">
                    <div><input type="submit" class="memberJoin-button" id="joinSubmit" onclick="submitButton()"
                            value="완료">
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>