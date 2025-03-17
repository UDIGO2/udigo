# --------------------------------------------------------
# db 생성 및 유저 권한 할당
# --------------------------------------------------------
# create member 'udigo'@'%' identified by 'udigo';
#
# show databases;
# use mysql;
#
# select * from member;
# select member from member;
#
# create database udigo;
#
# grant all privileges on udigo.* to 'udigo'@'%';
#
# show grants for 'udigo'@'%';
#
# use udigo;

-- --------------------------------------------------------
-- ddl 부분
-- --------------------------------------------------------

DROP TABLE IF EXISTS `tbl_member_roles`;
DROP TABLE IF EXISTS `tbl_board_comments`;
DROP TABLE IF EXISTS `tbl_board_posts`;
DROP TABLE IF EXISTS `tbl_reviews`;
DROP TABLE IF EXISTS `tbl_reservations`;
DROP TABLE IF EXISTS `tbl_pay`;
DROP TABLE IF EXISTS `tbl_cart`;
DROP TABLE IF EXISTS `tbl_acm`;
DROP TABLE IF EXISTS `tbl_user_roles`;
DROP TABLE IF EXISTS `tbl_roles`;
DROP TABLE IF EXISTS `tbl_login_his`;
DROP TABLE IF EXISTS `tbl_pwd_his`;
DROP TABLE IF EXISTS `tbl_member`;

-- 테이블 생성
CREATE TABLE `tbl_member` (
                              `member_code`	INT	NOT NULL AUTO_INCREMENT PRIMARY KEY	COMMENT '회원 고유 코드',
                              `member_id`	VARCHAR(50)	NOT NULL UNIQUE	COMMENT '사용자  아이디(UNIQUE)',
                              `member_name`	VARCHAR(30)	NOT NULL	COMMENT '사용자 이름',
                              `email`	VARCHAR(100)	NOT NULL UNIQUE COMMENT '회원 이메일(UNIQUE)',
                              `password`	VARCHAR(255)	NOT NULL	COMMENT '암호화된 비밀번호',
                              `phone_no`	VARCHAR(30)	NULL	COMMENT '휴대폰번호',
                              `join_date`	DATETIME	NULL	DEFAULT CURRENT_TIMESTAMP	COMMENT '가입일',
                              `oauth_provider`	VARCHAR(30)	NULL	COMMENT '카카오,네이버,구글 로그인',
                              `coupon_used`	BOOLEAN	NOT NULL	DEFAULT FALSE	COMMENT '쿠폰 사용 여부(기본값:미사용)',
                              `temp_pwd`	VARCHAR(30)	NULL	COMMENT '임시비밀번호',
                              `is_locked`	BOOLEAN	NOT NULL	DEFAULT FALSE	COMMENT '계정잠금여부',
                              `deactivated_at`	DATETIME	NULL	COMMENT '비활성화 시작일(탈퇴 요청일, 7일 후 삭제됨))',
                              `deleted_at`	DATETIME	NULL	COMMENT '완전삭제일(비활성화 후 7일 경과)',
                              `rejoin_at`	DATETIME	NULL	COMMENT '재가입 가능 날짜 (탈퇴 후 30일 후부터 가능)',
                              `email_verified`	BOOLEAN	NOT NULL	DEFAULT 0	COMMENT '이메일 인증 여부',
                              `is_verified`	BOOLEAN	NOT NULL	DEFAULT 0	COMMENT '계정검증여부'
);


CREATE TABLE `tbl_pwd_his` (
                               `pwd_no` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '비밀번호 변경 이력 번호',
                               `member_code` INT NOT NULL COMMENT '회원  ID',
                               `exp_time` DATETIME NULL COMMENT '임시비밀번호  만료일시',
                               `change_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '변경일시',
                               `old_pwd` VARCHAR(255) NULL COMMENT '이전 비밀번호(해시저장)',
                               `is_temp` BOOLEAN NULL DEFAULT FALSE COMMENT '임시 비밀번호 여부',
                               CONSTRAINT `FK_tbl_member_TO_tbl_pwd_his_1` FOREIGN KEY (`member_code`) REFERENCES `tbl_member` (`member_code`)
);

CREATE TABLE `tbl_acm` (
                           `acm_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '숙소 관리 ID',
                           `acm_name` VARCHAR(255) NOT NULL COMMENT '숙소명',
                           `acm_address` VARCHAR(255) NOT NULL COMMENT '숙소 상세 주소',
                           `acm_location` VARCHAR(255) NOT NULL COMMENT '숙소 위치',
                           `acm_price` BIGINT NOT NULL COMMENT '숙소 가격',
                           `acm_info` VARCHAR(255) NOT NULL COMMENT '숙소 설명',
                           `acm_phone` VARCHAR(30) NOT NULL COMMENT '숙소 전화번호',
                           `regist_date` DATETIME NOT NULL COMMENT '숙소 등록일자',
                           `max_guest` INT NOT NULL COMMENT '최대 숙박인원',
                           `liked_count` INT NULL COMMENT '좋아요 개수',
                           `acm_photo1` VARCHAR(255) NOT NULL COMMENT '숙소 사진1',
                           `acm_photo2` VARCHAR(255) NOT NULL COMMENT '숙소 사진2',
                           `acm_photo3` VARCHAR(255) NOT NULL COMMENT '숙소 사진3',
                           `acm_photo4` VARCHAR(255) NULL COMMENT '숙소사진4',
                           `acm_photo5` VARCHAR(255) NULL COMMENT '숙소 사진5'
);


DROP TRIGGER IF EXISTS before_insert_tbl_acm;
DELIMITER $$

CREATE TRIGGER before_insert_tbl_acm
    BEFORE INSERT ON tbl_acm
    FOR EACH ROW
BEGIN
    DECLARE max_id INT;

    -- 서울/경기 지역 처리
    IF NEW.acm_location = '서울/경기' THEN
        SELECT MAX(acm_id) INTO max_id FROM tbl_acm WHERE acm_location = '서울/경기';
        IF max_id IS NULL THEN
            SET NEW.acm_id = 101;
        ELSE
            SET NEW.acm_id = max_id + 1;
        END IF;

        -- 충청 지역 처리
    ELSEIF NEW.acm_location = '충청' THEN
        SELECT MAX(acm_id) INTO max_id FROM tbl_acm WHERE acm_location = '충청';
        IF max_id IS NULL THEN
            SET NEW.acm_id = 201;
        ELSE
            SET NEW.acm_id = max_id + 1;
        END IF;

        -- 강원 지역 처리
    ELSEIF NEW.acm_location = '강원' THEN
        SELECT MAX(acm_id) INTO max_id FROM tbl_acm WHERE acm_location = '강원';
        IF max_id IS NULL THEN
            SET NEW.acm_id = 301;
        ELSE
            SET NEW.acm_id = max_id + 1;
        END IF;

        -- 제주 지역 처리
    ELSEIF NEW.acm_location = '제주' THEN
        SELECT MAX(acm_id) INTO max_id FROM tbl_acm WHERE acm_location = '제주';
        IF max_id IS NULL THEN
            SET NEW.acm_id = 401;
        ELSE
            SET NEW.acm_id = max_id + 1;
        END IF;

        -- 전라 지역 처리
    ELSEIF NEW.acm_location = '전라' THEN
        SELECT MAX(acm_id) INTO max_id FROM tbl_acm WHERE acm_location = '전라';
        IF max_id IS NULL THEN
            SET NEW.acm_id = 501;
        ELSE
            SET NEW.acm_id = max_id + 1;
        END IF;

        -- 경상 지역 처리
    ELSEIF NEW.acm_location = '경상' THEN
        SELECT MAX(acm_id) INTO max_id FROM tbl_acm WHERE acm_location = '경상';
        IF max_id IS NULL THEN
            SET NEW.acm_id = 601;
        ELSE
            SET NEW.acm_id = max_id + 1;
        END IF;

    END IF;
END $$

DELIMITER ;


CREATE TABLE tbl_cart (
                          cart_code INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '장바구니 고유 코드',
                          member_code INT NOT NULL COMMENT '회원 고유 코드',
                          acm_id INT NOT NULL COMMENT '숙소 관리 ID',
                          FOREIGN KEY (member_code) REFERENCES tbl_member(member_code),
                          FOREIGN KEY (acm_id) REFERENCES tbl_acm(acm_id)
);


CREATE TABLE `tbl_pay` (
                           `pay_id` INT NOT NULL AUTO_INCREMENT COMMENT '거래 내역 고유 번호(기본 키)',
                           `member_code` INT NOT NULL COMMENT '회원 고유 코드',
                           `acm_id` INT NOT NULL COMMENT '숙소 관리 ID',
                           `pay_method` VARCHAR(30) NOT NULL COMMENT '간편결제, 카드결제',
                           `pay_status` ENUM('결제완료', '결제취소', '환불완료') NOT NULL COMMENT '현재 거래 상태(결제취소, 결제완료 등)',
                           `pay_type` VARCHAR(30) NOT NULL COMMENT '결제수단 정보(카드사 등)',
                           `pay_date` DATETIME NOT NULL COMMENT '거래가 발생한 일시',
                           `pay_price` INT NOT NULL COMMENT '결제한 금액',
                           `discount` INT NOT NULL DEFAULT 0 COMMENT '회원가입 시 발생하는 쿠폰의 할인 금액',
                           `pay_ref` INT NULL DEFAULT 0 NULL COMMENT '환불된 금액 (NULL 허용)',
                           `transaction_id` VARCHAR(30) NOT NULL COMMENT 'PG사에서 제공되는 거래고유 ID',
                           `pay_provider` VARCHAR(30) NOT NULL COMMENT '결제 서비스 제공업체',
                           PRIMARY KEY (`pay_id`),
                           CONSTRAINT `FK_tbl_member_TO_tbl_pay_1` FOREIGN KEY (`member_code`) REFERENCES `tbl_member` (`member_code`),
                           CONSTRAINT `FK_tbl_acm_TO_tbl_pay_1` FOREIGN KEY (`acm_id`) REFERENCES `tbl_acm` (`acm_id`)
);
CREATE TABLE `tbl_login_his` (
                                 `login_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '로그인 이력 고유 ID',
                                 `member_code` INT NOT NULL COMMENT '로그인한 회원식별코드',
                                 `login_ip` VARCHAR(50) NULL COMMENT '로그인 시 사용된 IP 주소',
                                 `success` BOOLEAN NOT NULL DEFAULT FALSE COMMENT 'TRUE: 성공, FALSE: 실패',
                                 CONSTRAINT `FK_tbl_member_TO_tbl_login_his_1` FOREIGN KEY (`member_code`) REFERENCES `tbl_member` (`member_code`)
);

CREATE TABLE `tbl_roles` (
                             `role_code` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '권한 코드',
                             `role_name` VARCHAR(50) NOT NULL COMMENT '권한 이름'
);

CREATE TABLE `tbl_reservations` (
                                    `resv_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '예약 고유 번호(기본키)',
                                    `acm_id` INT NOT NULL COMMENT '예약한 숙소 ID',
                                    `member_code` INT NOT NULL COMMENT '예약한 회원의 ID',
                                    `check_in` DATETIME NOT NULL COMMENT '체크인 날짜',
                                    `check_out` DATETIME NOT NULL COMMENT '체크아웃 날짜',
                                    `guest_count` INT NOT NULL COMMENT '숙박인원',
                                    `is_resv` INT NOT NULL DEFAULT FALSE COMMENT '예약 상태',
                                    `created_at` DATETIME NOT NULL COMMENT '생성일자',
                                    CONSTRAINT `FK_tbl_acm_TO_tbl_reservations_1` FOREIGN KEY (`acm_id`) REFERENCES `tbl_acm` (`acm_id`),
                                    CONSTRAINT `FK_tbl_member_TO_tbl_reservations_1` FOREIGN KEY (`member_code`) REFERENCES `tbl_member` (`member_code`)
);

DELIMITER $$

CREATE TRIGGER before_insert_tbl_reservations
    BEFORE INSERT ON tbl_reservations
    FOR EACH ROW
BEGIN
    DECLARE overlap_count INT;

    -- 겹치는 예약이 있는지 확인
    SELECT COUNT(*)
    INTO overlap_count
    FROM tbl_reservations
    WHERE acm_id = NEW.acm_id
      AND (
        (NEW.check_in BETWEEN check_in AND check_out)
            OR (NEW.check_out BETWEEN check_in AND check_out)
            OR (check_in BETWEEN NEW.check_in AND NEW.check_out)
            OR (check_out BETWEEN NEW.check_in AND NEW.check_out)
        );

    -- 겹치는 예약이 있으면 에러 발생
    IF overlap_count > 0 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = '예약 날짜가 겹칩니다.';
    END IF;
END $$

DELIMITER ;



CREATE TABLE `tbl_board_posts` (
                                   `post_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '게시글 고유 번호',
                                   `member_code` INT NOT NULL COMMENT '작성자 회원식별코드',
                                   `board_type` INT NOT NULL COMMENT '게시판 분류 코드(faq, 1대1, 공지)',
                                   `title` VARCHAR(255) NOT NULL COMMENT '게시글 제목',
                                   `content` TEXT NOT NULL COMMENT '게시글 내용',
                                   `created_at` DATETIME NOT NULL COMMENT '게시글 작성 시간',
                                   `updated_at` DATETIME NULL COMMENT '게시글 수정 시간',
                                   CONSTRAINT `FK_tbl_member_TO_tbl_board_posts_1` FOREIGN KEY (`member_code`) REFERENCES `tbl_member` (`member_code`)
);

CREATE TABLE `tbl_board_comments` (
                                      `comment_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '답변 고유 번호 (기본 키)',
                                      `post_id` INT NOT NULL COMMENT '게시글 고유 번호 (기본 키)',
                                      `content` VARCHAR(255) NOT NULL COMMENT '답변 본문 내용',
                                      `created_at` DATETIME NOT NULL COMMENT '답변 작성 시간',
                                      CONSTRAINT `FK_tbl_board_posts_TO_tbl_board_comments_1` FOREIGN KEY (`post_id`) REFERENCES `tbl_board_posts` (`post_id`)
);



CREATE TABLE `tbl_reviews` (
                               `review_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '후기 고유 번호',
                               `member_code` INT NOT NULL COMMENT '작성한 회원식별코드',
                               `acm_id` INT NOT NULL COMMENT '숙소 ID',
                               `resv_id` INT NULL COMMENT '예약 고유 번호',
                               `content` VARCHAR(255) NOT NULL COMMENT '후기 내용',
                               `written_at` DATETIME NOT NULL COMMENT '작성 날짜',
                               `re_photo1` VARCHAR(255) NULL COMMENT '후기 사진1',
                               `re_photo2` VARCHAR(255) NULL COMMENT '후기 사진2',
                               `re_photo3` VARCHAR(255) NULL COMMENT '후기 사진3',
                               CONSTRAINT `FK_tbl_member_TO_tbl_reviews_1` FOREIGN KEY (`member_code`) REFERENCES `tbl_member` (`member_code`),
                               CONSTRAINT `FK_tbl_acm_TO_tbl_reviews_1` FOREIGN KEY (`acm_id`) REFERENCES `tbl_acm` (`acm_id`),
                               CONSTRAINT `FK_tbl_reservations_TO_tbl_reviews_1` FOREIGN KEY (`resv_id`) REFERENCES `tbl_reservations` (`resv_id`)
);


CREATE TABLE `tbl_member_roles` (
                                  `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '인조식별자',
                                  `member_code` INT NOT NULL COMMENT '회원 고유코드',
                                  `role_code` INT NOT NULL COMMENT ' 부여된 권한 코드',
                                  UNIQUE KEY `UK_member_role` (`member_code`, `role_code`),
                                  CONSTRAINT `FK_tbl_member_TO_tbl_member_roles_1` FOREIGN KEY (`member_code`) REFERENCES `tbl_member` (`member_code`),
                                  CONSTRAINT `FK_tbl_roles_TO_tbl_member_roles_1` FOREIGN KEY (`role_code`) REFERENCES `tbl_roles` (`role_code`)
);
ALTER TABLE tbl_member ADD COLUMN role VARCHAR(20) DEFAULT 'USER';

ALTER TABLE tbl_reservations
    ADD COLUMN pay_id INT NULL COMMENT '결제 ID',
    ADD CONSTRAINT FK_tbl_pay_TO_tbl_reservations FOREIGN KEY (pay_id) REFERENCES tbl_pay(pay_id);
