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