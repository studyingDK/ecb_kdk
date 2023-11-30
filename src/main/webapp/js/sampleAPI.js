

/* Javascript 샘플 코드 */

/* API 요청 URL
지역코드 : 각 지역별 코드 행정표준코드관리시스템(www.code.go.kr)의 법정동코드(https://www.code.go.kr/stdcode/regCodeL.do) 10자리 중 앞 5자리 / ex. LAWD_CD=11110
계약월 : 실거래 자료의 계약년월(6자리) / ex. DEAL_YMD=201512
인증키 : 공공데이터포털에서 발급받은 인증키 / serviceKey

내가 발급받은 key
n3yLjs73qQynFeitKpZgzeORiUcYwzerIF3x4JT5PijQao4EfhtB52hoP%2F38mxEkhXEl0KTgInf95RWLwu2T2w%3D%3D

*/

//http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTrade?serviceKey=n3yLjs73qQynFeitKpZgzeORiUcYwzerIF3x4JT5PijQao4EfhtB52hoP%2F38mxEkhXEl0KTgInf95RWLwu2T2w%3D%3D&LAWD_CD=11110&DEAL_YMD=201512
var url = 'http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTrade'; /*URL*/
var queryParams = '?' + encodeURIComponent('serviceKey') + '='+'n3yLjs73qQynFeitKpZgzeORiUcYwzerIF3x4JT5PijQao4EfhtB52hoP%2F38mxEkhXEl0KTgInf95RWLwu2T2w%3D%3D'; /*Service Key*/
queryParams += '&' + encodeURIComponent('LAWD_CD') + '=' + encodeURIComponent('11110'); /**/
queryParams += '&' + encodeURIComponent('DEAL_YMD') + '=' + encodeURIComponent('201512'); /**/

// var xhr = new XMLHttpRequest();
// xhr.open('GET', url + queryParams);
// xhr.setRequestHeader("Access-Control-Allow-Origin","http://127.0.0.1:5500");

// xhr.send();

// xhr.onload = () =>{
//     if(xhr.status === 200) {
//         console.log(xhr.response);
//     }
//     else {
//         console.log(xhr.status, xhr.statusText);
//     }
// }

//fetch(url + queryParams).then((resp=>{console.log(resp)}))


function getDataPromise() {
    return new Promise((resolve, reject) => {
      const xhr = new XMLHttpRequest(); //XMLHttpRequest 객체 생성
      xhr.open("GET", url + queryParams); //HTTP Method, URL 정의
      xhr.setRequestHeader("Access-Control-Request-Origin", "*");
      xhr.setRequestHeader("Access-Control-Allow-Origin", "*");
      xhr.send(); // 요청 전송

      xhr.onload = () => {
        if (xhr.status === 200) {
          // 정상적으로 응답이 되면 status가 200
          const res = JSON.parse(xhr.response); // 응답 데이터를 JSON.parse 함수로 JSON 객체로 변경
          resolve(res);
        } else {
          // 에러 발생
          console.error(xhr.status, xhr.statusText); //응답 상태와 응답 메시지를 출력
          reject(new Error(xhr.status));
        }
      };
    });
  }

  getDataPromise().then((res) => {
    console.log(res); // 서버 응답이 완료된 후 코드가 실행 됨
    console.log("다음 코드를 실행합니다.");
  });