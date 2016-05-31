# Springboot001

----
## Personal Project
시작하며..(진행중)

> 사용해보지 않은 Springboot, ORM(JPA), Freemarker등의 기술을 경험 해보면서 더 나아가 개인 블로그 제작을 목표로 동작위주의 프로젝트가 아닌 기능과 효율적인 코드를 고려하여 개인 프로젝트를 시작한다. 첫번째 Spring Boot 프로젝트 기능으로는 크게 회원과 게시판을 다뤄보려한다.
진행중에 유동적으로 변할 수 있지만 현재 목표로 하는 기능과 기술 스택은 다음과 같다.

----
## 회원 CRUD 기능
1. ID, Password, Email의 정보를 가짐
2. Email 양식 검증
3. 로그인
4. 타 사이트 이동 후에도 로그인 유지
5. 비 로그인자는 로그인화면에 접근 불가
6. 가입, 수정, 탈퇴
7. ID 기억
8. 자동 로그인
9. Oauth 로그인 (google, facebook등)
10. tag, script공격에 대한 보안처리

----
## 게시판 CRUD 기능
1. 1개의 게시판
2. 목록은 글, 등록일, 등록자 출력
3. 99개까지 가능한 답글
4. 답글 포함 20개 단위로 페이징
5. 동일 Level의 글의 정렬은 최신 날짜 우선
6. 글에 대한 권한처리 (본인 글만 수정/삭제)
7. 글자 수 제한은 200자
8. 이미지 업로드(jpg, png, gif)
9. 배포 없이(코드 수정없이) 페이징 단위 조절 기능
10. 답글에 답글
11. 1만개 이상의 답글이 있어도 느려지지 않는 페이징
12. 1만명이 동시에 하나의 글을 요청해도 느려지지 않는 로딩속도
13. js, css, image 브라우저 cache 문제 처리
14. tag, script공격에 대한 보안처리

----
## 기술 스택
```
-- front
    1. Bower
    2. Freemarker
    3. jQuery
    4. Bootstrap
```
```
-- back
    1. Java8
    2. Mysql
    3. ORM(JPA)
    4. Gradle
    5. Logger(SLF4J)
    6. Node
```
```
-- Tool
    1. STS
    2. Trello
    3. Git & Github(SourceTree)
```