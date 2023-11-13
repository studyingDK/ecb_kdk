# ● 커뮤니티 게시판에서 포털까지 확장하는 프로젝트

### Expansion Community Board

### ◎ 목표
기본적인 커뮤니티 사이트인 메인 페이지, 게시판, 로그인 기능을 구현하고 

점진적으로 기능을 추가하여 최종적으로 포털 사이트 만들기

---
### ◎ 개발환경
Spring Legacy + Apache Maven + Mybatis

DB: MariaDB

OS: Windows 10 Pro

etc.

Apache Tomcat 9.0.62

JVM 11.0.14

---


### ◎ 구현하고자 하는 기능들 (추가 시 +)
ㆍ익명제가 아닌 회원 가입이 기본 전제 조건(읽기 및 쓰기)

ㆍ출석, 글개수, 추천 등 커뮤니티 활동을 레벨 및 업적 시스템으로 구체화

ㆍ추천수, 조회수 등으로 top 5 글 보이도록 따로 메인에 구성


---


### ◎ 구현하면서 공부 및 생각할 점 (추가 시 +)
ㆍ설계부터 배포까지

ㆍ예외처리 구현

ㆍAPI 사용 숙달

ㆍ사이트 보안

---

### ◎ 일지
~~230927 - 기본적인 구현(요구사항) 목록 작성 및 시스템 환경구성~~

~~231010 - DB 테이블 설계 및 ddl 작성~~

~~231018 - 대형 포털 참고하여 메인페이지 어떤식으로 구성할 지 파악~~

231027 - 메인페이지(View) 구성 시작

231109 - 메인페이지, 게시판 페이지 컨트롤러 및 비지니스 로직 구성 시작

231113 - html, css 요소에 대해 규칙을 정하고 이름, id, 클래스명 수정