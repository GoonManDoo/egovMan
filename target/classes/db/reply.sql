CREATE TABLE `reply` (
	`rno` INT(10) NOT NULL AUTO_INCREMENT,							--댓글 번호
	`testId` INT(10) NOT NULL,										--게시글 번호
	`writer` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',     --댓글 작성자
	`content` TEXT NOT NULL COLLATE 'utf8mb4_0900_ai_ci',           --댓글 내용
	`regDate` DATE NOT NULL,										--댓글 작성일자
	PRIMARY KEY (`rno`, `testId`) USING BTREE,						--댓글 번호, 게시글 번호 기본키
	INDEX `FK_reply_test` (`testId`) USING BTREE,					--test 테이블에 testId 외래키
	CONSTRAINT `FK_reply_test` FOREIGN KEY (`testId`) REFERENCES `test` (`testId`) ON UPDATE RESTRICT ON DELETE RESTRICT
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
