INSERT INTO tbl_user (user_id, user_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (1, 'admin', 'admin@naver.com', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', NULL, NOW(), TRUE, FALSE);

INSERT INTO tbl_user (user_id, user_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (101, '김건우', 'gunwoo@naver.com', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '010-3868-8803', NOW(), FALSE, FALSE);

INSERT INTO tbl_user (user_id, user_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (102, '김나영', 'nayoung@naver.com', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '016-3494-8126', NOW(), FALSE, FALSE);

INSERT INTO tbl_user (user_id, user_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (103, '박송이', 'songyi@naver.com', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '011-1190-2653', NOW(), FALSE, FALSE);

INSERT INTO tbl_user (user_id, user_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (104, '박성현', 'sunghyun@naver.com', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '011-2245-7620', NOW(), FALSE, FALSE);

INSERT INTO tbl_user (user_id, user_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (105, '조수민', 'sumin@naver.com', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '011-7339-7957', NOW(), FALSE, FALSE);

INSERT INTO tbl_user (user_id, user_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (106, '허아름', 'areum@daum.net', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '016-4814-3905', NOW(), FALSE, FALSE);

INSERT INTO tbl_roles (role_code, role_name) VALUES (1, 'ADMIN');
INSERT INTO tbl_roles (role_code, role_name) VALUES (2, 'USER');

INSERT INTO tbl_user_roles (user_id, role_code) VALUES (1, 1);
INSERT INTO tbl_user_roles (user_id, role_code) VALUES (1, 2);

INSERT INTO tbl_user_roles (user_id, role_code) VALUES (101, 2);
INSERT INTO tbl_user_roles (user_id, role_code) VALUES (102, 2);
INSERT INTO tbl_user_roles (user_id, role_code) VALUES (103, 2);
INSERT INTO tbl_user_roles (user_id, role_code) VALUES (104, 2);
INSERT INTO tbl_user_roles (user_id, role_code) VALUES (105, 2);
INSERT INTO tbl_user_roles (user_id, role_code) VALUES (106, 2);

ALTER TABLE tbl_user AUTO_INCREMENT = 107;
