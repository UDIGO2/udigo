INSERT INTO tbl_user (user_code,user_id, user_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (1,'admin', 'admin', 'admin@naver.com', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', NULL, NOW(), TRUE, FALSE);

INSERT INTO tbl_user (user_code,user_id, user_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (101,'user01', '김건우', 'gunwoo@naver.com', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '010-3868-8803', NOW(), FALSE, FALSE);

INSERT INTO tbl_user (user_code,user_id, user_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (102,'user02', '김나영', 'nayoung@naver.com', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '016-3494-8126', NOW(), FALSE, FALSE);

INSERT INTO tbl_user (user_code,user_id, user_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (103,'user02', '박송이', 'songyi@naver.com', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '011-1190-2653', NOW(), FALSE, FALSE);

INSERT INTO tbl_user (user_code,user_id, user_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (104,'user02', '박성현', 'sunghyun@naver.com', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '011-2245-7620', NOW(), FALSE, FALSE);

INSERT INTO tbl_user (user_code,user_id, user_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (105,'user02', '조수민', 'sumin@naver.com', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '011-7339-7957', NOW(), FALSE, FALSE);

INSERT INTO tbl_user (user_code,user_id, user_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (106,'user02', '허아름', 'areum@daum.net', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '016-4814-3905', NOW(), FALSE, FALSE);

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

-- 서울/경기 지역에 새로운 데이터 삽입
INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('서울/경기','서울 강남 호텔','주소주주소소', 250000, '서울/경기 호텔은 최고의 편안함과 서비스를 제공합니다.', '010-1234-5678', NOW(), 4,800, 'new_hotel_1.jpg', 'new_hotel_2.jpg', 'new_hotel_3.jpg', 'new_hotel_4.jpg', 'new_hotel_5.jpg');

INSERT INTO tbl_acm (acm_location, acm_name, acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('충청','서울 충청충청 호텔', 250000, '서울/경기 호텔은 최고의 편안함과 서비스를 제공합니다.', '010-1234-5678', NOW(), 4,800, 'new_hotel_1.jpg', 'new_hotel_2.jpg', 'new_hotel_3.jpg', 'new_hotel_4.jpg', 'new_hotel_5.jpg');


-- 📌 충청 지역 호텔 데이터

-- 📌 강원 지역 호텔 데이터

-- 📌 제주 지역 호텔 데이터
INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('제주','롯데호텔 제주','제주특별자치도 서귀포시 중문관광로72번길 35', 250000, '롯데호텔 제주는 언제나 내 집과 같은 편안함과 아늑함을 제공합니다.', '064-731-1000', NOW(), 4,800, 'new_hotel_1.jpg', 'new_hotel_2.jpg', 'new_hotel_3.jpg', 'new_hotel_4.jpg', 'new_hotel_5.jpg');

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('제주','제주 신라호텔','제주특별자치도 서귀포시 특별자치도, 중문관광로72번길 75', 250000, '내 집과 같은 편안함으로 공간 이상의 가치가 숨쉬고 있는 제주 신라호텔.', '064-735-5114', NOW(), 4,800, 'new_hotel_1.jpg', 'new_hotel_2.jpg', 'new_hotel_3.jpg', 'new_hotel_4.jpg', 'new_hotel_5.jpg');

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('제주','해비치 호텔 & 리조트 제주','제주특별자치도 서귀포시 표선면 민속해안로 537', 250000, '''해가 처음 비추는 곳''이라는 뜻의 해비치 호텔앤드리조트는 때묻지 않은 자연 그대로의 제주와 에메랄드빛 바다가 한눈에 펼쳐지는 아름다운 곳에 위치하고 있습니다.', '064-780-8100', NOW(), 4,800, 'new_hotel_1.jpg', 'new_hotel_2.jpg', 'new_hotel_3.jpg', 'new_hotel_4.jpg', 'new_hotel_5.jpg');

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('제주','롯데 호텔 제주','제주특별자치도 서귀포시 중문관광로72번길 35', 250000, '롯데호텔 제주는 언제나 내 집과 같은 편안함과 아늑함을 제공합니다.', '064-731-1000', NOW(), 4,800, 'new_hotel_1.jpg', 'new_hotel_2.jpg', 'new_hotel_3.jpg', 'new_hotel_4.jpg', 'new_hotel_5.jpg');

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('제주','롯데 호텔 제주','제주특별자치도 서귀포시 중문관광로72번길 35', 250000, '롯데호텔 제주는 언제나 내 집과 같은 편안함과 아늑함을 제공합니다.', '064-731-1000', NOW(), 4,800, 'new_hotel_1.jpg', 'new_hotel_2.jpg', 'new_hotel_3.jpg', 'new_hotel_4.jpg', 'new_hotel_5.jpg');
-- 📌 전라 지역 호텔 데이터

-- 📌 경상 지역 호텔 데이터

-- 📌 다음 신규 숙소 ID를 31부터 시작하도록 설정
