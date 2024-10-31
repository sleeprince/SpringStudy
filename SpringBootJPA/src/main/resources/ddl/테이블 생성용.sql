USE jpa;

CREATE TABLE `user2` (
	`user_id` 	INT(11) 			NOT NULL AUTO_INCREMENT,
	`user_nm` 	VARCHAR(100) 	NULL 		DEFAULT NULL,
	`user_pwd` 	VARCHAR(255) 	NULL 		DEFAULT NULL,
	`del_yn`		BOOLEAN			NOT NULL DEFAULT 0,
	`reg_date` 	DATETIME 		NULL 		DEFAULT CURRENT_TIMESTAMP(),
	PRIMARY KEY (`user_id`) USING BTREE,
	UNIQUE INDEX `iUser2UserNm` (`user_nm`) USING BTREE
);

CREATE TABLE `role2` (
	`role_no` 	INT(11) 		NOT NULL AUTO_INCREMENT,
	`role_nm` 	VARCHAR(20) NULL 		DEFAULT NULL,
	PRIMARY KEY (`role_no`) USING BTREE
);

CREATE TABLE `board2` (
	`board_no` 			INT(11) 			NOT NULL AUTO_INCREMENT,
	`board_title` 		VARCHAR(100) 	NOT NULL,
	`board_content` 	TINYTEXT 		NULL 		DEFAULT NULL,
	`del_yn`				BOOLEAN			NOT NULL DEFAULT 0,
	`reg_date` 			DATETIME 		NULL 		DEFAULT CURRENT_TIMESTAMP(),
	PRIMARY KEY (`board_no`) USING BTREE
);

SHOW TABLES;

INSERT INTO role2 (`role_nm`) VALUES ('ADMIN');
INSERT INTO role2 (`role_nm`) VALUES ('DEVELOPER');
INSERT INTO role2 (`role_nm`) VALUES ('USER');

INSERT INTO user2 (`user_nm`, `user_pwd`,`reg_date`) VALUES ('관리자','ADMIN', NOW());
INSERT INTO user2 (`user_nm`, `user_pwd`,`reg_date`) VALUES ('개발자','DEV', NOW());
INSERT INTO user2 (`user_nm`, `user_pwd`,`reg_date`) VALUES ('사용자','USER', NOW());

INSERT INTO user2 (`user_nm`, `user_pwd`,`reg_date`) VALUES ('사용자1','USER', NOW());
INSERT INTO user2 (`user_nm`, `user_pwd`,`reg_date`) VALUES ('사용자2','USER', NOW());
INSERT INTO user2 (`user_nm`, `user_pwd`,`reg_date`) VALUES ('사용자3','USER', NOW());
INSERT INTO user2 (`user_nm`, `user_pwd`,`reg_date`) VALUES ('사용자4','USER', NOW());
INSERT INTO user2 (`user_nm`, `user_pwd`,`reg_date`) VALUES ('사용자5','USER', NOW());
INSERT INTO user2 (`user_nm`, `user_pwd`,`reg_date`) VALUES ('사용자6','USER', NOW());
INSERT INTO user2 (`user_nm`, `user_pwd`,`reg_date`) VALUES ('사용자7','USER', NOW());

COMMIT;

SELECT * FROM user2;
SELECT * FROM role2;
SELECT * FROM board2;

TRUNCATE TABLE board2;

INSERT INTO board2 (`board_title`, `user_id`) VALUES ('게시글1',1);
INSERT INTO board2 (`board_title`, `user_id`) VALUES ('게시글2',2);
INSERT INTO board2 (`board_title`, `user_id`) VALUES ('게시글3',3);
INSERT INTO board2 (`board_title`, `user_id`) VALUES ('게시글4',4);
INSERT INTO board2 (`board_title`, `user_id`) VALUES ('게시글5',5);
INSERT INTO board2 (`board_title`, `user_id`) VALUES ('게시글6',6);
INSERT INTO board2 (`board_title`, `user_id`) VALUES ('게시글7',7);
INSERT INTO board2 (`board_title`, `user_id`) VALUES ('게시글8',8);
INSERT INTO board2 (`board_title`, `user_id`) VALUES ('게시글9',9);
INSERT INTO board2 (`board_title`, `user_id`) VALUES ('게시글10',10);
INSERT INTO board2 (`board_title`, `user_id`) VALUES ('게시글11',1);
INSERT INTO board2 (`board_title`, `user_id`) VALUES ('게시글12',1);
INSERT INTO board2 (`board_title`, `user_id`) VALUES ('게시글13',2);

COMMIT;

SELECT board2.board_no, board2.board_title, user2.user_nm, role2.role_nm 
  FROM board2, user2, urmapping, role2 
 WHERE board2.user_id = user2. user_id
   AND user2.user_id = urmapping.user_id
   AND urmapping.role_no = role2.role_no
 ORDER BY 1;
    
    
    