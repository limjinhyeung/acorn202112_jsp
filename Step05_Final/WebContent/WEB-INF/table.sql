-- 사용자(회원) 정보를 저장할 테이블
CREATE TABLE users(
	id VARCHAR2(100) PRIMARY KEY,
	pwd VARCHAR2(100) NOT NULL,
	email VARCHAR2(100),
	profile VARCHAR2(100), --프로필 이미지 경로를 지정할 칼럼
	regdate DATE
);

-- 게시글을 저장할 테이블
CREATE TABLE board_cafe(
	num NUMBER primary key,
	writer varchar2(100) not null,
	title varchar2(100)	not null,
	content clob,
	viewCount	Number,
	regdate date
	);
--게시글의 번호를 얻어낼 시퀀스
CREATE SEQUENCE board_cafe_seq;

-- 업로드된 파일의 정보를 저장할 테이블
CREATE TABLE board_file(
   num NUMBER PRIMARY KEY,
   writer VARCHAR2(100) NOT NULL,
   title VARCHAR2(100) NOT NULL,
   orgFileName VARCHAR2(100) NOT NULL, -- 원본 파일명
   saveFileName VARCHAR2(100) NOT NULL, -- 서버에 실제로 저장된 파일명
   fileSize NUMBER NOT NULL, -- 파일의 크기 
   regdate DATE
);

CREATE SEQUENCE board_file_seq;