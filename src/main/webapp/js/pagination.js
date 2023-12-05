let $totalItem; //총 개수
let $pageItemCount; //한 페이지에 보여줄 개수
let $searchKeyword; //검색 키워드
let $pageSortType; //정렬 타입(ASC, DESC)
let $pageSortKeyword; //정렬기준 키워드
let $curPage; //(총 페이지 에서)현재 페이지
let startNum; //쿼리에서 리스트 불러올 시작 번호
let endNum; //쿼리에서 리스트 불러올 끝 번호
let pagenationNum; //리스트 버튼
let totalPage = 0;
let $leftPageBtn;
let $leftOneBtn;
let $rightPageBtn;
let $rightOneBtn;

window.onload = function () {
  $totalItem = document.getElementById("totalItem");
  $pageItemCount = document.getElementById("pageItemCount");
  $searchKeyword = document.getElementById("searchKeyword");
  $pageSortType = document.getElementById("pageSortType");
  $pageSortKeyword = document.getElementById("pageSortKeyword");
  $curPage = document.getElementById("curPage");
  $leftPageBtn = document.getElementById("leftPageBtn");
  $leftOneBtn = document.getElementById("leftOneBtn");
  $rightPageBtn = document.getElementById("rightPageBtn");
  $rightOneBtn = document.getElementById("rightOneBtn");

  selectPaginationList(0);
  pageButton(totalPage, $curPage.value);
};

//페이지 보여주는 함수
function selectPaginationList(page) {
  let param; //검색 조건 parameter
  let pURL; //요청 할 URL

  //초기 init
  if (page == 0) {
    $pageItemCount.value = 20;
    $curPage.value = 1;
    $pageSortType.value = "desc";
    $pageSortKeyword.value = "rentNo";
  }

  param =
    "&pageItemCount=" +
    $pageItemCount.value +
    "&curPage=" +
    $curPage.value +
    "&searchKeyword=" +
    $searchKeyword.value +
    "&pageSortType=" +
    $pageSortType.value +
    "&pageSortKeyword=" +
    $pageSortKeyword.value;
  pURL = "/optimalProfitList" + "?" + param;

  //데이터 요청 및 페이지 처리
  $.ajax({
    url: pURL,
    type: "POST",
    dataType: "JSON",
    async: false,
    traditional: true,
    success: function (data) {
      let html = "";

      if (data.length == 0) {
        totalPage = 0;
        html += "        <div>";
        html += "        검색 결과가 없습니다!";
        html += "        </div>";
        return;
      }

      //총 페이지, 현재 페이지
      totalPage = Number(data[$pageItemCount.value][0]); //(int)Math.ceil((double)totalItem/pageItemCount)
      $curPage.value = Number(data[$pageItemCount.value][1]);

      //리스트 아이템 개수 만큼 반복
      for (let i = 0; i < $pageItemCount.value; i++) {
        html += '        <div class="gridBody">';
        html += '          <div class="gridcell">' + data[i][0] + "</div>";
        html += '          <div class="gridcell">' + data[i][1] + "</div>";
        html += '          <div class="gridcell">' + data[i][2] + "</div>";
        html += '          <div class="gridcell">' + data[i][3] + "</div>";
        html += '          <div class="gridcell">' + data[i][4] + "</div>";
        html += '          <div class="gridcell">' + data[i][5] + "</div>";
        html += '          <div class="gridcell">' + data[i][6] + "</div>";
        html += '          <div class="gridcell">' + data[i][7] + "</div>";
        html += '          <div class="gridcell">' + data[i][8] + "</div>";
        html += '          <div class="gridcell">' + data[i][9] + "</div>";
        html += '          <div class="gridcell">' + data[i][10] + "</div>";
        html += "        </div>";
      }

      document.getElementById("boardBody").insertAdjacentHTML("beforeend", html);
      console.log(totalPage);
    },
    error: function () {
      alert("다시 시도해주세요!");
    },
  });
}

//검색 조건 선택 시 placeholder 변경 함수
function selectPlaceholder() {
  $searchKeyword = document.getElementById("searchKeyword").value;

  let result = document.getElementById("inputSearch");
  if ($searchKeyword == "regUser") {
    result.setAttribute("placeholder", "ex) KIMDOKYEOM");
  } else if ($searchKeyword == "regDate") {
    result.setAttribute("placeholder", "ex) 2023-05-02");
  } else if ($searchKeyword == "ipAddr") {
    result.setAttribute("placeholder", "ex) 10.0.210.93");
  } else {
    result.setAttribute("placeholder", "검색 조건 선택하기");
  }
}

//페이지 버튼 만들어주는 함수
function pageButton(totalPage, curPage) {
  if (totalPage == 0) {
    return;
  }

  let curRange = Math.floor(curPage / 10);

  if (curPage == 1) {
    $leftPageBtn.style.display = "none";
    $leftOneBtn.style.display = "none";
    $rightPageBtn.style.display = "";
    $rightOneBtn.style.display = "";
  } else if (curPage == totalPage) {
    $leftPageBtn.style.display = "";
    $leftOneBtn.style.display = "";
    $rightPageBtn.style.display = "none";
    $rightOneBtn.style.display = "none";
  } else {
    $leftPageBtn.style.display = "none";
    $leftOneBtn.style.display = "none";
    $rightPageBtn.style.display = "none";
    $rightOneBtn.style.display = "none";
  }

  console.log("현재 십의자리 : " + curRange);
  console.log("현재 일의자리 : " + (curPage % totalPage));
}

function pageMove(page) {}

function testValue() {
  console.log(document.getElementById("totalPage").value);
  console.log(document.getElementById("curPage").value);
}
