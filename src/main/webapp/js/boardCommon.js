function postWrite(typeCd) {
    let url = "/board/postwrite";
    
    let goPost = document.createElement('form');
    let data = document.createElement('input');
  
    data.setAttribute('type', 'hidden');
    data.setAttribute('name', 'pstKindCd');
    data.setAttribute('value', typeCd);
    goPost.appendChild(data);
    goPost.setAttribute('method', 'post');
    goPost.setAttribute('target', '_blank'); // 새 탭으로
    goPost.setAttribute('action', url);
    document.body.appendChild(goPost);
    goPost.submit();
}

function boardDetailHome(type) {
    let kindCd = type;

    let url = "/board/" + kindCd;
    
    let goPost = document.createElement('form');
    let data = document.createElement('input');
  
    data.setAttribute('type', 'hidden');
    data.setAttribute('name', 'pstKindCd');
    data.setAttribute('value', kindCd);
    goPost.appendChild(data);
    goPost.setAttribute('method', 'post');
    goPost.setAttribute('action', url);
    document.body.appendChild(goPost);
    goPost.submit();
}

// 글목록 클릭 시 상세보기로 이동
function postclick(e) {
    let tar = e.target;
    let el1 = tar.getAttribute('data-role1');
    let el2 = tar.getAttribute('data-role2');
    let el3 = tar.getAttribute('data-role3');
    let url = "/board/postSelect";
    console.log(tar);

    if (el1 == null || el2 == null || el3 == null) {
        alert("오류가 발생하였습니다. 새로고침 부탁드립니다.");
    }

    let data = {
        role1: tar.getAttribute('data-role1'),
        role2: tar.getAttribute('data-role2'),
        role3: tar.getAttribute('data-role3')
    }

    return new Promise((resolve, reject) => {
        const xhr = new XMLHttpRequest();
        xhr.open("POST", url);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(JSON.stringify(data));

        xhr.onload = () => {
            if (xhr.status === 200) {
                const res = xhr.response;
                console.log(res);
                resolve(res);
            } else {
                console.error(xhr.status, xhr.statusText);
                location.href = "/error";
            }
        };
    });
}

