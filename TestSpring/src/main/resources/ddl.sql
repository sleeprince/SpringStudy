USE edu;

CREATE TABLE `temp1` (
	`no` 			INT 					NOT NULL AUTO_INCREMENT PRIMARY key,
	`title` 	VARCHAR(100) 	NOT NULL,
	`content` VARCHAR(200) 	NULL,
	`accept` 	BOOLEAN 			NOT NULL DEFAULT '0',
	`regDate` DATETIME 			NOT NULL DEFAULT NOW()
);

insert into temp1 (title, content, accept) value ('연습용1', '내용1', 0);
insert into temp1 (title, content, accept) value ('연습용2', '내용2', 1);
insert into temp1 (title, content, accept) value ('연습용3', '내용3', 0);
insert into temp1 (title, content, accept) value ('연습용4', '내용4', 0);
insert into temp1 (title, content, accept) value ('연습용5', '내용5', 1);

COMMIT;
