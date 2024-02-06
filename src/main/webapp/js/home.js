let $loginTop;





/******************** nowTime 관련 변수 *********************/
let now;
let year;
let month; 
let day;
let hours;
let minutes;
let seconds;
let formattedDate;
/*nowTime 변수 end =========================================*/


window.onload = function () {
  $loginTop = document.getElementById("home-container__login-box-top");
  nowTime();
  
  //1초 마다 시간 업뎃
  setInterval(nowTime, 1000);
}


//메인홈 로그인 버튼 위에 현재 시간 함수
function nowTime() {
  now = new Date();
  year = now.getFullYear();
  month = String(now.getMonth() + 1).padStart(2, '0'); // 월은 0부터 시작하므로 1을 더하고 형식을 맞춥니다.
  day = String(now.getDate()).padStart(2, '0');
  hours = String(now.getHours()).padStart(2, '0');
  minutes = String(now.getMinutes()).padStart(2, '0');
  seconds = String(now.getSeconds()).padStart(2, '0');
  let formattedDate = `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
  $loginTop.innerText = formattedDate;
}

//로그인 페이지 이동
function login() {
  let url = "/login";
  let goPost = document.createElement('form');

  // let data = document.createElement('input');

  // data.setAttribute('type', 'hidden');
  // data.setAttribute('name', 'userid');
  // data.setAttribute('value', "테스트");

  // goPost.appendChild(data);
  goPost.setAttribute('method', 'post');
  goPost.setAttribute('action', url);
  document.body.appendChild(goPost);
  goPost.submit();
}

//게시판 페이지 이동
function boardMainPage() {
  let url = "/board/main";
  let goPost = document.createElement('form');

  let data = document.createElement('input');

  data.setAttribute('type', 'hidden');
  data.setAttribute('name', 'userid');
  data.setAttribute('value', "테스트");

  goPost.appendChild(data);
  goPost.setAttribute('method', 'post');
  goPost.setAttribute('action', url);
  document.body.appendChild(goPost);
  goPost.submit();
}