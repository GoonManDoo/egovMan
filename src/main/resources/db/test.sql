CREATE TABLE `test` (
	`testId` INT(10) NOT NULL AUTO_INCREMENT, 		                            --게시글 번호
	`testTitle` VARCHAR(300) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',    --게시글 제목
	`testContent` VARCHAR(300) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',  --게시글 내용
	`testName` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',      --게시글 작성자
	`testDate` DATE NULL DEFAULT NULL,											--게시글 작성일자
	`fileName` VARCHAR(512) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',     --파일 이름
	PRIMARY KEY (`testId`) USING BTREE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
AUTO_INCREMENT=220
;