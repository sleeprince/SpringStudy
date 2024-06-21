USE studytimestable;

CREATE TABLE `temp1` (
	`no` 		INT 			NOT NULL AUTO_INCREMENT PRIMARY key,
	`title` 	VARCHAR(100) 	NOT NULL,
	`content` 	VARCHAR(200) 	NULL,
	`accept` 	BOOLEAN 		NOT NULL DEFAULT '0',
	`regDate` 	DATETIME 		NOT NULL DEFAULT NOW() 
);
