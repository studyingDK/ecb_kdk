let $loginId;
let $password;
let $nickname;
let $username;
let $userBirth;
let $phoneNum;
let $country;
let $gender;
let $selected;
let $zipCode;
let $address;
let $addressDetail;
let $secondaryId;

let checkLoginId;
let checkNickname;

window.onload = function () {
    $loginId = document.getElementById('loginId');
    $password = document.getElementById('password');
    $nickname = document.getElementById('nickname');
    $username = document.getElementById('username');
    $userBirth = document.getElementById('userBirth');
    $phoneNum = document.getElementById('phoneNum');
    $country = document.querySelector('input[name="country"]:checked');
    $gender = document.getElementById('gender');
    $zipCode = document.getElementById('zipCode');
    $address = document.getElementById('address');
    $addressDetail = document.getElementById('addressDetail');
    $secondaryId = document.getElementById('secondaryId');

    checkLoginId = false;
    checkNickname = false;
}

/* validation function ******************************************************************/
//중복조회 (아이디, 닉네임 사용)
function duplicateCheck(ty, data) {
    let result = {
        type: ty,
        inputText: data
    }

    let url = "/login/duplicateCheck";

    return new Promise((resolve, reject) => {
        const xhr = new XMLHttpRequest();
        xhr.open("POST", url);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(JSON.stringify(result));

        xhr.onload = () => {
            if (xhr.status === 200) {
                const res = xhr.response;
                resolve(res);
            } else {
                console.error(xhr.status, xhr.statusText);
                console.log("error");
            }
        };
    });
}

//아이디
function loginIdValidation() {
    let dupChkLoginId = $loginId.value;
    let type = 'loginId';

    if (!dupChkLoginId) {
        alert("아이디를 입력해주세요.");
        return false;
    }

    // 영문 소문자, 숫자, 밑줄(_)
    let loginIdRegex = /^[a-z0-9_]+$/;

    // 3자 이상, 20자 이하여야 합니다.
    let validLength = dupChkLoginId.length >= 3 && dupChkLoginId.length <= 20;

    if (!validLength) {
        alert("아이디는 3자 이상 20자 이하여야 합니다");
        return false;
    }
    else if (!loginIdRegex.test(dupChkLoginId)) {
        alert("아이디는 영문 소문자, 숫자, 밑줄(_)만 가능 합니다.");
        return false;
    }
    else {
        duplicateCheck(type, dupChkLoginId).then((res) => {
            if (res == "possible") {
                alert("해당 아이디는 사용 가능합니다.");
                checkLoginId = dupChkLoginId
                return;
            }
            else {
                alert("존재하는 아이디 입니다.");
                return false;
            }
        });
    }
}

//비밀번호
function passwordValidation(password) {
    if (!password) {
        alert("비밀번호를 입력해주세요.");
        return false;
    }

    // 최소 8자 이상
    let validLength = password.length >= 8;

    // 영문 대문자, 영문 소문자, 숫자, 특수문자를 모두 포함
    let containsUppercase = /[A-Z]/.test(password);
    let containsLowercase = /[a-z]/.test(password);
    let containsNumber = /\d/.test(password);
    let containsSpecialChar = /[!@#$%^&*()_+{}\[\]:;<>,.?~\\/-]/.test(password);

    let allCharacterTypes = containsUppercase && containsLowercase && containsNumber && containsSpecialChar;

    if (!(validLength && allCharacterTypes)) {
        alert("비밀번호는 최소 8자 이상, 영문 대소문자, 숫자, 특수문자를 포함 해야 합니다.");
        return false;
    }
    return true;
}

//닉네임
function nicknameValidation() {
    let dupChkNickname = $nickname.value;
    let type = 'nickname';

    if (!dupChkNickname) {
        alert("닉네임을 입력해주세요.");
        return false;
    }

    // 최소 2자 이상 8자 이하
    let validLength = dupChkNickname.length >= 2 && dupChkNickname.length <= 8;

    // 특수문자를 포함하지 않아야 합니다. (밑줄은 허용)
    let invalidChars = /[^a-zA-Z0-9가-힣_]/.test(dupChkNickname);

    if (!(validLength && !invalidChars)) {
        alert("닉네임은 최소 2자 이상 8자 이하, 밑줄(_)을 제외한 특수 문자는 사용할 수 없습니다.");
        return false;
    }
    else {
        duplicateCheck(type, dupChkNickname).then((res) => {
            if (res == "possible") {
                alert("해당 닉네임은 사용 가능합니다.");
                checkNickname = dupChkNickname
                return;
            }
            else {
                alert("존재하는 닉네임 입니다.");
                return false;
            }
        });
    }
}

//생년월일
function birthValidation(birthdate) {
    if (!birthdate) {
        alert("생년월일을 입력해주세요.");
        return false;
    }

    // 8자리 숫자로 구성
    let validFormat = /^\d{8}$/.test(birthdate);

    if (!validFormat) {
        alert("8자리 숫자로 입력해주세요.");
        return false;
    }

    // 앞 4자리(년도)는 1907 ~ 올해년도-5 범위
    let currentYear = new Date().getFullYear();
    let birthYear = parseInt(birthdate.substring(0, 4), 10);
    let validYearRange = birthYear >= 1907 && birthYear <= (currentYear - 5);

    // 뒤 4자리는 0101 ~ 1231 범위
    let validDayOfMonth = /^((0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01]))$/.test(birthdate.substring(4));

    if (!validYearRange) {
        alert("생년 범위는 1907년 ~"+(currentYear - 5)+"년 입니다.");
        return false;
    }
    else if (!validDayOfMonth) {
        alert("1월 1일 부터 12월 31일 사이로 입력해주세요.");
        return false;
    }
    
    return true;
}

//전화번호
function phoneNumberValidation(phoneNumber) {
    if (!phoneNumber) {
        alert("전화번호를 입력해주세요.");
        return false;
    }

    // 허용된 지역번호 배열
    const validAreaCodes = ['010', '011', '016', '017', '018', '019', '02', '031', '032', '033', '041', '042', '043', '044', '051', '052', '053', '054', '055', '061', '062', '063', '064'];

    // 휴대전화 번호 정규표현식 (허용된 지역번호로 시작하고, xxx-xxxx 또는 xxxx-xxxx)
    const phoneRegex = new RegExp(`^(${validAreaCodes.join('|')})[-]?\\d{3,4}[-]?\\d{4}$`);

    // 번호가 정규표현식과 일치하는지 확인
    const isValid = phoneRegex.test(phoneNumber);

    if (!isValid) {
        alert("올바른 전화번호를 입력해주세요.");
        return false;
    }

    return true;
}

//복구 이메일
function emailValidation(email) {
    if (!email) {
        alert("복구 이메일을 입력해주세요.");
        return false;
    }

    // 이메일 형식을 검증하는 정규표현식
    let emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;

    if (!emailRegex.test(email)) {
        alert("올바른 복구 이메일을 입력해주세요.");
        return false;
    }

    return true;
}
/* validation function end **************************************************************/

// 주소 검색 팝업창 함수
function popupAddress() {

    new daum.Postcode({
        // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
        oncomplete: function (data) {
            console.log("인식!");
            let tmpAddress;

            //사용자가 선택한 주소 타입 (R:도로명, J:지번)
            if (data.userSelectedType == 'J') {
                tmpAddress = data.jibunAddress;
            }
            else {
                tmpAddress = data.roadAddress;
            }

            $zipCode.value = data.zonecode; //우편주소
            $address.value = tmpAddress; // 사용자한테 보여줄 주소
            $addressDetail.value = ""; //상세주소
            $addressDetail.removeAttribute('disabled');

        }
    }).open();
}

// 등록 완료 버튼 함수
function submitButton() {
    let response = submitInformatin().then((response)=>{
        if (response == 'success') {
            alert("회원가입이 완료되었습니다.");
            let url = "/";
            let goPost = document.createElement('form');
            goPost.setAttribute('method', 'get');
            goPost.setAttribute('action', url);
            document.body.appendChild(goPost);
            goPost.submit();
        }
        
        else if (response == 'fail') {
            alert("회원가입에 실패하였습니다. 다시 시도 부탁드립니다.");
        }
    });
    return;
}

// 입력한 정보 전송 함수
function submitInformatin() {
    let loginId = $loginId.value;
    let password = $password.value;
    let nickname = $nickname.value;
    let username = $username.value;
    let userBirth = $userBirth.value;
    let phoneNum = $phoneNum.value;
    let country = $country.value;
    $selected = $gender.selectedIndex;
    let gender = $gender.options[$selected].value;
    let zipCode = $zipCode.value;
    let address = $address.value;
    let addressDetail = $addressDetail.value;
    let secondaryId = $secondaryId.value;
    
    
    /* validation 시작 ****************************************************************/

    //아이디
    if (checkLoginId == false) {
        alert("아이디 중복 확인을 해주세요.");
        return false;
    }

    if (loginId != checkLoginId) {
        alert("중복 확인 체크한 아이디와 현재 입력된 아이디가 다릅니다.");
        return false;
    }

    //비밀번호
    if (!passwordValidation(password)) {
        return false;
    }
    
    //닉네임
    if (checkNickname == false) {
        alert("닉네임 중복 확인을 해주세요.");
        return false;
    }

    if (nickname != checkNickname) {
        alert("중복 확인 체크한 닉네임과 현재 입력된 닉네임이 다릅니다.");
        return false;
    }

    //이름
    if (!username) {
        alert("이름을 입력해주세요.");
        return false;
    }

    //생년월일
    if (!birthValidation(userBirth)) {
        return false;
    }

    //성별
    if (gender == 'none') {
        alert("성별을 선택해주세요.");
        return false;
    }

    //전화번호
    if (!phoneNumberValidation(phoneNum)) {
        return false;
    }

    //주소
    if (!zipCode) {
        alert("주소를 입력해주세요.");
        return false;
    }

    if (!addressDetail) {
        alert("상세 주소를 입력해주세요.");
        return false;
    }

    //복구 이메일
    if (!emailValidation(secondaryId)) {
        return false;
    }

    console.log("validation 끝");

    /* validation 끝 ******************************************************************/

    let result = {
        sLoginId: loginId,
        sPassword: password,
        sNickname: nickname,
        sUsername: username,
        sUserBirth: userBirth,
        sPhoneNum: phoneNum,
        sCountry: country,
        sGender: gender,
        sZipCode: zipCode,
        sAddress: address,
        sAddressDetail: addressDetail,
        sSecondaryId: secondaryId
    }

    let url = "/login/memberSave";

    return new Promise((resolve, reject) => {
        const xhr = new XMLHttpRequest();
        xhr.open("POST", url);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(JSON.stringify(result));

        xhr.onload = () => {
            if (xhr.status === 200) {
                const res = xhr.response;
                resolve(res);
            } else {
                console.error(xhr.status, xhr.statusText);
                console.log("error");
                resolve('fail');
            }
        };
    });
}