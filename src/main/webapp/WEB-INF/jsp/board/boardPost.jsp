<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <title id="boardName"></title>
    <link href="/css/common.css" rel="stylesheet" />
    <link href="/css/board-common.css" rel="stylesheet" />
    <link href="/css/boardPost.css" rel="stylesheet" />
    <script src="/js/common.js"></script>
    <script src="/js/boardPost.js"></script>
    <script src="/js/boardCommon.js"></script>
    <script src="/js/module/ckeditor/ckeditor.js"></script>
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
        <div class="boardDetail-container cmm_scorll-none">
            <div>글쓰기
                <span id="pstTypeCdChkBlock" style="display: none;">
                    <select name="pstTypeCd" id="pstTypeCd">
                        <option value="C" selected>일반</option>
                        <option value="A">공지</option>
                        <!-- 관련 내용 따로 구현 되면 목록 리스트 활성화 -->
                        <!-- <c:forEach items="${titlePrefixList}" var="item">
                            <option value="${item}">${item}</option>
                        </c:forEach> -->
                    </select>
                </span>
            </div>
            <div class="cmm__ghr"></div>
            <div class="boardPost-container-contents">
                <div class="boardPost-container-contents-twoColumns">
                    <select name="pstCtgCd" id="pstCtgCd">
                        <option value="none">카테고리 선택</option>
                        <c:forEach items="${ctgList}" var="item">
                            <option value="${item.key}">${item.value}</option>
                        </c:forEach>
                    </select>
                    <select name="pstTitlePrefix" id="pstTitlePrefix">
                        <option value="none">말머리 선택</option>
                        <c:forEach items="${titlePrefixList}" var="item">
                            <option value="${item.key}">${item.value}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="boardPost-container-contents-rows">
                    <input type="text" name="pstTitle" id="pstTitle" placeholder="제목을 입력하세요." />
                </div>
                <div class="boardPost-container-contents-rows">
                    <textarea name="editor1" id="editor1" cols="60" rows="10"></textarea>
                </div>
                <div class="boardPost-container-contents-rows">
                    <span></span>
                </div>
                <div class="boardPost-container-contents-rows-status">
                    <div class="boardPost-container-contents-rows__comment">댓글유무</div>
                    <div>
                        <input type="radio" name="pstCommentYn" value="E" /><label for="everything"
                            class="boardPost-container-contents-rows__comment">모두 허용</label>
                        <input type="radio" name="pstCommentYn" value="M" checked /><label for="member"
                            class="boardPost-container-contents-rows__comment">회원만</label>
                        <input type="radio" name="pstCommentYn" value="N" /><label for="nothing"
                            class="boardPost-container-contents-rows__comment">허용 안함</label>
                    </div>
                </div>
                <div class="cmm__ghr"></div>
                <div class="boardPost-container-contents-rows-status">
                    <div class="boardPost-container-contents-rows__comment">조회조건</div>
                    <div>
                        <input type="radio" name="pstLookupChk" value="E" /><label for="everything"
                            class="boardPost-container-contents-rows__comment">모두 허용</label>
                        <input type="radio" name="pstLookupChk" value="M" checked /><label for="member"
                            class="boardPost-container-contents-rows__comment">회원만</label>
                    </div>
                </div>
                <div class="cmm__ghr pstCommentChk"></div>
                <div class="boardPost-container-contents-rows-status pstCommentChk">
                    <div class="boardPost-container-contents-rows__comment">댓글조건</div>
                    <div>
                        <input type="radio" name="pstCommentChk" value="E" /><label for="everything"
                            class="boardPost-container-contents-rows__comment">모두 허용(미구현)</label>
                        <input type="radio" name="pstCommentChk" value="M" checked /><label for="member"
                            class="boardPost-container-contents-rows__comment">특정 회원(미구현)</label>
                    </div>
                </div>

                <div class="boardPost-container-contents-rows">
                    <button id="postWrite" onclick="postCreate()">작성 완료</button>
                </div>
            </div>
        </div>
    </div>
    <input type="hidden" id="pstKindCd" value="${boardType}"/>
    <input type="hidden" id="regId" value="${regId}"/>
    <input type="hidden" id="nickname" value="${nickname}"/>
    <script>
    	CKEDITOR.replace('editor1', { height: 500 }); //에디터 관련 (높이값)
    </script>
</body>

</html>