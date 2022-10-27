CREATE TABLE `useracc` (
	`ID` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',				--ID
	`PASSWORD` VARCHAR(300) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',		--비번
	`ENABLED` CHAR(1) NOT NULL DEFAULT '0' COLLATE 'utf8mb4_0900_ai_ci',--계정 활성화 상태 0활성화, 1비활성화
	PRIMARY KEY (`ID`) USING BTREE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB