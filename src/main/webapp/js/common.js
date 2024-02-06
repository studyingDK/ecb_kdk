function homePageButton() {
    let url = "/"
    let goPost = document.createElement('form');
  
    // let data = document.createElement('input');
  
    // data.setAttribute('type', 'hidden');
    // data.setAttribute('name', 'userid');
    // data.setAttribute('value', "테스트");
    //goPost.appendChild(data);
    goPost.setAttribute('method', 'post');
    goPost.setAttribute('action', url);
    document.body.appendChild(goPost);
    goPost.submit();
}

//.cmm_content-nb 화면 사이즈에 따른 크기 조절
function updateNbSize() {
  let contentElement = document.getElementById('cmm_content-nb');

  if (window.innerWidth >= 1280) {
    contentElement.style.gridTemplateColumns = '77% 23%';
  } 
  else if(window.innerWidth < 1280 && window.innerWidth >= 700) {
    // 700px ~ 1280px
    contentElement.style.gridTemplateColumns = '40% 60%';
  }
  else {
	  contentElement.style.gridTemplateColumns = '20% 80%';  
  }
}
