let boardName; // 게시판 이름


// $: 포인터 역할
let $pstCtgCd; //게시판 종류
let $pstKindCd; //게시글 카테고리
let $pstTypeCd; //게시글 유형
let $pstTypeCdChkBlock; //유형 활성화 관련
let $pstTitlePrefixCd; //게시글 말머리 코드
let $pstTitlePrefixNm; //게시글 말머리 이름
let $pstTitle; //게시글 제목 
let $pstContent; //게시글내용
let $pstCommentYn; //댓글게시유무 (E:모두허용,M:회원만, N:허용안함)
let $pstLookupChk; //조회조건 (E:모두허용,M:회원만)
let $pstCommentChk; //댓글조건 (나중에 명확하게 분류 - 레벨, 조건없음 등)
let $regId; //작성자 id
let $nickname; //작성자 이름



window.onload = function () {
    document.getElementById("boardName").innerText = "게시판 이름"; //게시판 이름 세팅

    $pstCommentYn = document.querySelectorAll('input[name = "pstCommentYn"]');


    CommnetChk(); // 처음 로드할 때 실행
    $pstCommentYn.forEach(radio => radio.addEventListener('change', CommnetChk));
    
	updateNbSize();
	
    // 창 크기 변경 시 이벤트 리스너 등록
    window.addEventListener('resize', function () {
    	updateNbSize();
    });
}

//유저가 관리자 일 때 경우 게시글 유형 활성화
function adminPosts(userRights) {
    $pstTypeCdChkBlock = document.getElementById('pstTypeCdChkBlock');
    let tmp = 'S';
    //관리자 데이터(로그인 기능 구현)받아오는거 구현되면 추가 (지금은 임의로 시스템관리자로 세팅) 

    if (tmp == 'S') {
        $pstTypeCdChkBlock.style.display = "";
    }
}

//댓글게시유무 회원일 때 댓글조건 활성화
function CommnetChk() {
    let check = document.querySelector('input[name="pstCommentYn"]:checked').value;
    let elements = document.getElementsByClassName("pstCommentChk");
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
            if ('fail' == res) {
                location.href = "/error";
            }
            else {
                alert("글 작성이 완료되었습니다.");

                setTimeout(function () {
                    window.close();
                }, 500);
            }
        });
    }
}

//Validation
function postValidation() {
	$pstCtgCd = document.getElementById('pstCtgCd').value; //게시글 카테고리 코드
	$pstCtgNm = document.getElementById('pstCtgCd').options[document.getElementById('pstCtgCd').selectedIndex].text; //게시글 카테고리 이름
	$pstTypeCd = document.getElementById('pstTypeCd').value; //게시글 유형 코드
	$pstTypeNm =  document.getElementById('pstTypeCd').options[document.getElementById('pstTypeCd').selectedIndex].text; //게시글 유형 이름
    $pstTitlePrefixCd = document.getElementById('pstTitlePrefix').value; //게시글 말머리 코드
    $pstTitlePrefixNm = document.getElementById('pstTitlePrefix').options[document.getElementById('pstTitlePrefix').selectedIndex].text; //게시글 말머리 이름
    $pstTitle = document.getElementById('pstTitle').value; //게시글 제목 
    $pstContent = CKEDITOR.instances.editor1.getData(); //게시글내용
    $pstCommentYn = document.querySelector('input[name="pstCommentYn"]:checked').value; //댓글게시유무 (E:모두허용,M:회원만, N:허용안함)
    $pstLookupChk = document.querySelector('input[name="pstLookupChk"]:checked').value; //조회조건 (E:모두허용,M:회원만)
	$pstKindCd = document.getElementById("pstKindCd").value; //게시판 종류 코드
	$pstKindNm = document.getElementById("boardName").text; //게시판 종류 이름
    $regId = document.getElementById("regId").value;//작성자 id
    $nickname = document.getElementById("nickname").value;//작성자 이름



    //댓글조건 (나중에 명확하게 분류 - 레벨, 조건없음 등)
    if ($pstCommentYn == 'M') {
        $pstCommentChk = document.querySelector('input[name="pstCommentChk"]:checked').value;
    }
    else {
        $pstCommentChk = null;
    }

    if ($pstCtgCd == "none") {
        alert("카테고리를 선택해주세요.");
        return false;
    }

    if ($pstTitlePrefixCd == "none") {
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

    //관리자 권한 아닌데 일반글 쓰는 경우 체크

    return true;
}

//게시글 보내는 Promise
function postWriteSubmit() {
    let data = {
    	pstKindCd: $pstKindCd, //게시판 종류 코드
    	pstKindNm: $pstKindNm, //게시판 종류 이름 
        pstCtgCd: $pstCtgCd, //게시글 카테고리
        pstCtgNm: $pstCtgNm,
        pstTypeCd : $pstTypeCd, //게시글 유형 (기본값 일반:C)
        pstTypeNm : $pstTypeNm,
        pstTitlePrefixCd: $pstTitlePrefixCd, //게시글 말머리 코드
        pstTitlePrefixNm: $pstTitlePrefixNm, //게시글 말머리 이름
        pstTitle: $pstTitle, //게시글 제목 
        pstContent: $pstContent, //게시글내용
        pstCommentYn: $pstCommentYn, //댓글게시유무 (E:모두허용,M:회원만, N:허용안함)
        pstLookupChk: $pstLookupChk, //조회조건 (E:모두허용,M:회원만)
        pstCommentChk: $pstCommentChk, //댓글조건 (나중에 명확하게 분류 - 레벨, 조건없음 등)
        regId: $regId, //작성자 id
        nickname: $nickname //작성자 이름
    };

    let url = "/board/postCreate";

    return new Promise((resolve, reject) => {
        const xhr = new XMLHttpRequest();
        xhr.open("POST", url);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(JSON.stringify(data));

        xhr.onload = () => {
            if (xhr.status === 200) {
                const res = xhr.response;
                resolve(res);
            } else {
                console.error(xhr.status, xhr.statusText);
                location.href = "/error";
            }
        };
    });
}