-- 게시판
ALTER TABLE `BOARD`
	DROP FOREIGN KEY `FK_MEMBER_TO_BOARD`; -- 회원기본정보 -> 게시판

-- 게시글
ALTER TABLE `COMMENT`
	DROP FOREIGN KEY `FK_MEMBER_TO_COMMENT`; -- 회원기본정보 -> 게시글

-- 게시글
ALTER TABLE `COMMENT`
	DROP FOREIGN KEY `FK_BOARD_TO_COMMENT`; -- 게시판 -> 게시글

-- 이미지첨부파일
ALTER TABLE `ATTACHFILE`
	DROP FOREIGN KEY `FK_BOARD_TO_ATTACHFILE`; -- 게시판 -> 이미지첨부파일

-- 게시판
ALTER TABLE `BOARD`
	DROP PRIMARY KEY; -- 게시판 기본키

-- 게시글
ALTER TABLE `COMMENT`
	DROP PRIMARY KEY; -- 게시글 기본키

-- 이미지첨부파일
ALTER TABLE `ATTACHFILE`
	DROP PRIMARY KEY; -- 이미지첨부파일 기본키

-- 회원기본정보
ALTER TABLE `MEMBER`
	DROP PRIMARY KEY; -- 회원기본정보 기본키

-- 회원기본정보 유니크 인덱스
DROP INDEX `UIX_MEMBER` ON `MEMBER`;

-- 게시판
DROP TABLE IF EXISTS `BOARD` RESTRICT;

-- 게시글
DROP TABLE IF EXISTS `COMMENT` RESTRICT;

-- 이미지첨부파일
DROP TABLE IF EXISTS `ATTACHFILE` RESTRICT;

-- 회원기본정보
DROP TABLE IF EXISTS `MEMBER` RESTRICT;

-- 게시판
CREATE TABLE `BOARD` (
	`BNO`       INTEGER      NOT NULL COMMENT '게시글일련번호', -- 게시글일련번호
	`MNO`       INTEGER      NOT NULL COMMENT '작성자', -- 작성자
	`BTITLE`    VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	`BCONTENT`  TEXT         NOT NULL COMMENT '내용', -- 내용
	`BREG_DATE` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일', -- 등록일
	`BMOD_DATE` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일' -- 수정일
)
COMMENT '게시판';

-- 게시판
ALTER TABLE `BOARD`
	ADD CONSTRAINT `PK_BOARD` -- 게시판 기본키
		PRIMARY KEY (
			`BNO` -- 게시글일련번호
		);

-- 게시글
CREATE TABLE `COMMENT` (
	`CNO`       INTEGER   NOT NULL COMMENT '댓글일련번호', -- 댓글일련번호
	`BNO`       INTEGER   NOT NULL COMMENT '게시글일련번호', -- 게시글일련번호
	`MNO`       INTEGER   NOT NULL COMMENT '작성자', -- 작성자
	`CCONTENT`  TEXT      NOT NULL COMMENT '내용', -- 내용
	`CREG_DATE` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일', -- 등록일
	`CMOD_DATE` TIMESTAMP NOT NULL COMMENT '수정일' -- 수정일
)
COMMENT '게시글';

-- 게시글
ALTER TABLE `COMMENT`
	ADD CONSTRAINT `PK_COMMENT` -- 게시글 기본키
		PRIMARY KEY (
			`CNO` -- 댓글일련번호
		);

-- 이미지첨부파일
CREATE TABLE `ATTACHFILE` (
	`FNO`        INTEGER      NOT NULL COMMENT '첨부파일일련번호', -- 첨부파일일련번호
	`BNO`        INTEGER      NOT NULL COMMENT '게시글일련번호', -- 게시글일련번호
	`FORI_NAME`  VARCHAR(255) NOT NULL COMMENT '원본파일이름', -- 원본파일이름
	`FREAL_NAME` VARCHAR(255) NOT NULL COMMENT '저장된파일이름', -- 저장된파일이름
	`FSAVED_DIR` VARCHAR(255) NOT NULL COMMENT '저장된파일경로', -- 저장된파일경로
	`FTHUMB_DIR` VARCHAR(255) NOT NULL COMMENT '썸네일파일경로' -- 썸네일파일경로
)
COMMENT '이미지첨부파일';

-- 이미지첨부파일
ALTER TABLE `ATTACHFILE`
	ADD CONSTRAINT `PK_ATTACHFILE` -- 이미지첨부파일 기본키
		PRIMARY KEY (
			`FNO` -- 첨부파일일련번호
		);

-- 회원기본정보
CREATE TABLE `MEMBER` (
	`MNO`       INTEGER      NOT NULL COMMENT '회원일련번호', -- 회원일련번호
	`MID`       VARCHAR(100) NOT NULL COMMENT '아이디', -- 아이디
	`MEMAIL`    VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
	`MPWD`      VARCHAR(20)  NOT NULL COMMENT '암호', -- 암호
	`MNAME`     VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
	`MREG_DATE` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '가입일', -- 가입일
	`MMOD_DATE` TIMESTAMP    NOT NULL DEFAULT NOW() COMMENT '수정일' -- 수정일
)
COMMENT '회원기본정보';

-- 회원기본정보
ALTER TABLE `MEMBER`
	ADD CONSTRAINT `PK_MEMBER` -- 회원기본정보 기본키
		PRIMARY KEY (
			`MNO` -- 회원일련번호
		);

-- 회원기본정보 유니크 인덱스
CREATE UNIQUE INDEX `UIX_MEMBER`
	ON `MEMBER` ( -- 회원기본정보
		`MID` ASC -- 아이디
	);

-- 게시판
ALTER TABLE `BOARD`
	ADD CONSTRAINT `FK_MEMBER_TO_BOARD` -- 회원기본정보 -> 게시판
		FOREIGN KEY (
			`MNO` -- 작성자
		)
		REFERENCES `MEMBER` ( -- 회원기본정보
			`MNO` -- 회원일련번호
		);

-- 게시글
ALTER TABLE `COMMENT`
	ADD CONSTRAINT `FK_MEMBER_TO_COMMENT` -- 회원기본정보 -> 게시글
		FOREIGN KEY (
			`MNO` -- 작성자
		)
		REFERENCES `MEMBER` ( -- 회원기본정보
			`MNO` -- 회원일련번호
		);

-- 게시글
ALTER TABLE `COMMENT`
	ADD CONSTRAINT `FK_BOARD_TO_COMMENT` -- 게시판 -> 게시글
		FOREIGN KEY (
			`BNO` -- 게시글일련번호
		)
		REFERENCES `BOARD` ( -- 게시판
			`BNO` -- 게시글일련번호
		);

-- 이미지첨부파일
ALTER TABLE `ATTACHFILE`
	ADD CONSTRAINT `FK_BOARD_TO_ATTACHFILE` -- 게시판 -> 이미지첨부파일
		FOREIGN KEY (
			`BNO` -- 게시글일련번호
		)
		REFERENCES `BOARD` ( -- 게시판
			`BNO` -- 게시글일련번호
		);