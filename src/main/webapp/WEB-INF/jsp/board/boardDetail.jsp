<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <title id="boardName">
        <c:out value="${pstKindNm}" />
    </title>
    <link href="/css/common.css" rel="stylesheet" />
    <link href="/css/boardDetail.css" rel="stylesheet" />
    <link href="/css/board-common.css" rel="stylesheet" />
    <script src="/js/common.js"></script>
    <script src="/js/boardCommon.js"></script>
</head>

<body>
    <div class="wrap">
        <div id="cmm_content-nb">
            <span class="cmm__home-button cmm__home-button-detail" style="text-align: left;"
                onclick="homePageButton()">ECB</span>
            <span class="cmm_content-nb-container">
                <span class="cmm_content-nb-container-content" id=""> 게시판 홈 </span>
                <span class="cmm__text-vertical-line">|</span>
                <span class="cmm_content-nb-container-content" id=""><button class="cmm__login-button-detail"> 로그인
                    </button></span>
            </span>
        </div>
        <div class="boardDetail-container cmm_scorll-none">
            <div id="boardDetail-container-headPhoto" onClick="boardDetailHome('${boardType}')">
            	<c:choose>
				    <c:when test="${image.trues}">
						<img src="/images/buffer.png">
				    </c:when>
				    <c:otherwise>
				        <div class="boardDetail-container-headPhoto__default"></div>
				    </c:otherwise>
				</c:choose>
            </div>
            <div class="boardDetail-container-menubar">
                <div>버튼1</div>
                <span class="cmm__text-vertical-line">|</span>
                <div>버튼2</div>
                <span class="cmm__text-vertical-line">|</span>
                <div>버튼3</div>
            </div>
            <div class="boardDetail-container-contents">
                <div class="boardDetail-container-contents-nav">
                    <div>456</div>
                    <button id="postWrite" onclick="postWrite('${boardType}')">글쓰기</button>
                    <div>뭐넣어야함..?</div>
                </div>
                <div class="boardDetail-container-contents-posts">
                    <%-- <jsp:include page="templete/"+${1234} }"></jsp:include> --%>
                    <jsp:include page="templete/boardList.jsp"></jsp:include>
                </div>
            </div>
        </div>
    </div>
    <script>

        window.onload = function () {
        	/* boardList 관련 */
            $locations = document.getElementById('locations').value;
            $listType = document.getElementById('listType').value;
            $pstType = document.getElementById('pstType').value;
            $pstCtg = document.getElementById('pstCtg').value;
            $listSetLocation = document.getElementById('board-container-list');

            boardListSet($locations, $listType, $pstCtg);
            /* boardList 관련 end */
            
        	updateNbSize();
        	
            // 창 크기 변경 시 이벤트 리스너 등록
            window.addEventListener('resize', function () {
            	updateNbSize();
            });
        }
    </script>
</body>

</html>