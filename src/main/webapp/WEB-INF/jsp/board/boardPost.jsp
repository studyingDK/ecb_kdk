<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <title id="boardName"></title>
    <link href="/css/common.css" rel="stylesheet" />
    <link href="/css/boardPost.css" rel="stylesheet" />
    <link href="/css/board-common.css" rel="stylesheet" />
    <script src="/js/common.js"></script>
    <script src="/js/module/ckeditor/ckeditor.js"></script>
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
            <div>글쓰기</div>
            <div class="cmm__ghr"></div>
            <div class="boardPost-container-contents">
                <div class="boardPost-container-contents-twoColumns">
                    <select name="pstTypeCd" id="pstTypeCd">
                        <option value="none">카테고리 선택</option>
                    </select>
                    <select name="pstTitlePrefix" id="pstTitlePrefix">
                        <option value="none">말머리 선택</option>
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
                <div class="cmm__ghr pstCommnetChk"></div>
                <div class="boardPost-container-contents-rows-status pstCommnetChk">
                    <div class="boardPost-container-contents-rows__comment">댓글조건</div>
                    <div>
                        <input type="radio" name="pstCommnetChk" value="E" /><label for="everything"
                            class="boardPost-container-contents-rows__comment">모두 허용(미구현)</label>
                        <input type="radio" name="pstCommnetChk" value="M" checked /><label for="member"
                            class="boardPost-container-contents-rows__comment">특정 회원(미구현)</label>
                    </div>
                </div>

                <div class="boardPost-container-contents-rows">
                    <button id="postWrite" onclick="postCreate()">작성 완료</button>
                </div>
            </div>
        </div>
    </div>
    <c:set var="boardType" value="${boardType}" />
    <input type="hidden" id="boardType" value="${boardType}">

    <script>
        CKEDITOR.replace('editor1', { height: 500 }); //에디터 관련 (높이값)
        let boardName; // 게시판 이름
        let pstTypeCd = "카테고리리스트"; //게시판 카테고리
        let pstTitlePrefix = "말머리리스트"; //말머리

        let $pstCtgCd; //게시글 종류(게시판)
        let $pstTypeCd; //게시글 유형(카테고리)
        let $pstTitlePrefix; //게시글 말머리
        let $pstTitle; //게시글 제목 
        let $pstContent; //게시글내용
        let $pstCommentYn; //댓글게시유무 (E:모두허용,M:회원만, N:허용안함)
        let $pstLookupChk; //조회조건 (E:모두허용,M:회원만)
        let $pstCommnetChk; //댓글조건 (나중에 명확하게 분류 - 레벨, 조건없음 등)


        window.onload = function () {
            document.getElementById("boardName").innerText = "게시판 이름";
            setCategoryList();
            setTitleStatus();
            //console.log(document.getElementById("pstCtgCd").value);

            $pstCommentYn = document.querySelectorAll('input[name = "pstCommentYn"]');
            console.log(document.getElementById("boardType").value);


            CommnetChk(); // 처음 로드할 때 실행
            $pstCommentYn.forEach(radio => radio.addEventListener('change', CommnetChk));
        }


        //게시판 카테고리 세팅
        function setCategoryList() {
            $pstTypeCd = document.querySelector("select[name='pstTypeCd']");
            //controller에서 값 세팅해주는 로직 짜야됨(순서는 거기서 세팅)
            $pstTypeCd.insertAdjacentHTML('beforeend', '<option value=' + pstTypeCd + '>세팅 테스트</option>');
        }

        //게시판 말머리 세팅
        function setTitleStatus() {
            $pstTitlePrefix = document.querySelector("select[name='pstTitlePrefix']");
            //controller에서 값 세팅해주는 로직 짜야됨(순서는 거기서 세팅)
            $pstTitlePrefix.insertAdjacentHTML('beforeend', '<option value=' + pstTitlePrefix + '>세팅 테스트</option>');

        }

        //댓글게시유무 회원일 때 댓글조건 활성화
        function CommnetChk() {
            let check = document.querySelector('input[name="pstCommentYn"]:checked').value;
            let elements = document.getElementsByClassName("pstCommnetChk");
            let elementsArray = Array.from(elements);

            if (check == 'M') {
                elementsArray.forEach(element => { element.style.display = "" });
            }

            else {
                elementsArray.forEach(element => { element.style.display = "none" });
            }
        }


        //게시글 생성
        function postCreate() {
            let result = postValidation();

            //Validation 성공 시 실행
            if (result == true) {
                postWriteSubmit().then((res) => {
                    console.log("글작성 성공! "+res);
                    console.log("글작성 성공! 원래 페이지로 돌아가자");
                });
            }
        }

        //Validation
        function postValidation() {
            $pstCtgCd = document.getElementById('boardType').value; //게시글 종류(게시판)
            $pstTypeCd = document.getElementById('pstTypeCd').value; //게시글 유형(카테고리)
            $pstTitlePrefix = document.getElementById('pstTitlePrefix').value; //게시글 말머리
            $pstTitle = document.getElementById('pstTitle').value; //게시글 제목 
            $pstContent = CKEDITOR.instances.editor1.getData(); //게시글내용
            $pstCommentYn = document.querySelector('input[name="pstCommentYn"]:checked').value; //댓글게시유무 (E:모두허용,M:회원만, N:허용안함)
            $pstLookupChk = document.querySelector('input[name="pstLookupChk"]:checked').value; //조회조건 (E:모두허용,M:회원만)

            //댓글조건 (나중에 명확하게 분류 - 레벨, 조건없음 등)
            if ($pstCommentYn == 'M') {
                $pstCommnetChk = document.querySelector('input[name="pstCommnetChk"]:checked').value;
            }
            else {
                $pstCommnetChk = null;
            }

            if ($pstTypeCd == "none") {
                alert("카테고리를 선택해주세요.");
                return false;
            }

            if ($pstTitlePrefix == "none") {
                alert("말머리를 선택해주세요.");
                return false;
            }

            if (!$pstTitle) {
                alert("제목을 입력해주세요.");
                return false;
            }

            if (!$pstContent) {
                alert("글내용을 입력해주세요.");
                return false;
            }

            return true;
        }

        //게시글 보내는 Promise
        function postWriteSubmit() {
            let data = {
                pstCtgCd: $pstCtgCd, //게시글 종류(게시판)
                pstTypeCd: $pstTypeCd, //게시글 유형(카테고리)
                pstTitlePrefix: $pstTitlePrefix, //게시글 말머리
                pstTitle: $pstTitle, //게시글 제목 
                pstContent: $pstContent, //게시글내용
                pstCommentYn: $pstCommentYn, //댓글게시유무 (E:모두허용,M:회원만, N:허용안함)
                pstLookupChk: $pstLookupChk, //조회조건 (E:모두허용,M:회원만)
                pstCommnetChk: $pstCommnetChk //댓글조건 (나중에 명확하게 분류 - 레벨, 조건없음 등)
            };
			
            let url = "/board/postCreate";

            return new Promise((resolve, reject) => {
                const xhr = new XMLHttpRequest();
                xhr.open("POST", url);
                xhr.setRequestHeader("content-type", "application/json");
                xhr.send(JSON.stringify(data));

                xhr.onload = () => {
                    if (xhr.status == 200) {
                    	const res = xhr.response;
                        resolve(res);
                    } else {
                        console.error(xhr.status, xhr.statusText);
                        reject(new Error(xhr.status));
                    }
                };
            });
        }
    </script>
</body>

</html>