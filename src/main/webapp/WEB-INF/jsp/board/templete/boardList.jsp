<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
</head>
<style>
    /* 글 리스트 block */
    #board-container-list {
        display: flex;
        flex-direction: column;
        font-size: 15px;
    }
    
    /* 글 맨 위 */
    .board-container-list-top {
        display: grid;
        grid-template-columns: 70px 100px 500px 120px 70px 70px;
        grid-column-gap: 10px;
        width: 100%;
    }
    
    /* 글 맨 위 관련 */
    .board-container-list-top * {
        font-size: 23px;
    }

    /* 글 (row) */
    .board-container-list-rows {
        display: grid;
        grid-template-columns: 70px 100px 500px 120px 70px 70px;
        grid-column-gap: 10px;
        width: 100%;
        margin-top: 7px;
    }

    /* 글 (row) 하위 태그 */
    .board-container-list-rows * {
        font-size: 19px;
    }

    /* 글번호 */
    .postNo {
        text-align: center;
        font-weight:bold;
    }

    /* 작성자 */
    .nickname {
    	text-align: center;
    }

    /* 글제목 */
    .postTitle {
        cursor: pointer;
        text-indent: 6px;
    }

    /* 작성날짜 */
    .postRegDtm {
        text-align: center;
    }

    /* 조회수 */
    .postViews {
        text-align: center;
    }

    /* 좋아요 개수 */
    .postLikeCnt {
        text-align: center;
    }

    /* 댓글 */
    .pstReply {}
</style>

<body>
    <div id="board-container-list">
    </div>
    <c:forEach items="${listSet}" var="item">
        <input type="hidden" id="${item.key}" value="${item.value}" />
    </c:forEach>
    <script>
        let $locations;
        let $listType;
        let $pstCtg;
        let $pstType;
        let $listSetLocation;

/*         window.onload = function () {
            $locations = document.getElementById('locations').value;
            $listType = document.getElementById('listType').value;
            $pstType = document.getElementById('pstType').value;
            $pstCtg = document.getElementById('pstCtg').value;
            $listSetLocation = document.getElementById('board-container-list');

            boardListSet($locations, $listType, $pstCtg);
        } */

        //글 리스트 세팅 함수 (불러올 위치, 불러올 리스트 타입, 카테고리:없으면 'none')
        function boardListSet(pLocations, pListType, pCtg) {
            let setHtml = "";
            let data = {
                locations: pLocations,
                listType: pListType,
                pstCtdCd: pCtg
            };

            //게시판 메인페이지에 인기글 (타입에 boardMain)
            if (locations == 'boardMain' && listType == 'popular' && ctg == 'none') {
                data.pstKindCd = 'none';
            }
            //특정 게시판 인기글 (타입에 게시판pk)
            else if (locations == 'boardDetail' && listType == 'popular' && ctg == 'none') {
                data.pstKindCd = $pstType;
            }

            boardListSumbit(data).then((res) => {
                setHtml += '                <div style="font-size:30px; text-align: center; color: rgb(49, 49, 49);text-shadow: 1px 4px 20px rgb(0, 0, 0);">주간 인기글</div>';
                setHtml += '                <div class="board-container-list-top">';
                setHtml += '                    <div class="postNo">순위</div>';
                setHtml += '                    <div class="nickname">작성자</div>';
                setHtml += '                    <div class="postTitle" style="cursor: default; text-align: center;">제목</div>';
                setHtml += '                    <div class="postRegDtm">작성날짜</div>';
                setHtml += '                    <div class="postViews">조회수</div>';
                setHtml += '                    <div class="postLikeCnt">좋아요</div>';
                setHtml += '                </div>';

                res.forEach(data => {
                    setHtml += '                <div class="board-container-list-rows">';
                    setHtml += '                    <div class="postNo">' + data.rowNum + '</div>';
                    setHtml += '                    <div class="nickname">' + data.nickname + '</div>';
                    setHtml += '                    <div class="postTitle" data-role1="' + data.pstId + '" data-role2="' + data.pstKindCd + '" data-role3="' + data.pstCtgCd + '" onclick="postclick(event)">' + data.pstTitle + '<span class="pstReply"></span></div>';
                    setHtml += '                    <div class="postRegDtm">' + data.regDtmToString.substring(0, 10) + '</div>';
                    setHtml += '                    <div class="postViews">' + data.pstViews + '</div>';
                    setHtml += '                    <div class="postLikeCnt">' + data.pstLikeCnt + '</div>';
                    setHtml += '                </div>';
                });
                $listSetLocation.insertAdjacentHTML("beforebegin", setHtml);
            });
        }

        //리스트 세팅 요청 보내는 메소드
        function boardListSumbit(pData) {
            let url = "/board/setPostList";

            return new Promise((resolve, reject) => {
                let xhr = new XMLHttpRequest();
                xhr.open("POST", url);
                xhr.setRequestHeader("Content-Type", "application/json");
                xhr.send(JSON.stringify(pData));

                xhr.onload = () => {
                    if (xhr.status === 200) {
                        let res = JSON.parse(xhr.response);
                        console.log(res);
                        resolve(res);
                    } else {
                        console.error(xhr.status, xhr.statusText);
                        location.href = "/error";
                    }
                };
            });
        }
    </script>

</body>

</html>