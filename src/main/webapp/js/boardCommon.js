let $postWrite; //글쓰기 버튼

window.onload = function(){
    $postWrite = document.getElementById("postWrite");
}


function postWrite(type) {
    let url = "/board/"+ type + "/postwrite";
    console.log("postWrite url 확인용 : "+url);
    let goPost = document.createElement('form');
  
    let data = document.createElement('input');
  
    data.setAttribute('type', 'hidden');
    data.setAttribute('name', 'pstCtdCd');
    data.setAttribute('value', type);
    goPost.appendChild(data);
    goPost.setAttribute('method', 'post');
    goPost.setAttribute('target', '_blank'); // 새 탭으로
    goPost.setAttribute('action', url);
    document.body.appendChild(goPost);
    goPost.submit();
}