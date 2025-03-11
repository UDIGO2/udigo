INSERT INTO tbl_user (user_code,user_id, user_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (1,'admin', 'admin', 'admin@naver.com', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', NULL, NOW(), TRUE, FALSE);

INSERT INTO tbl_user (user_code,user_id, user_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (101,'user01', '김건우', 'gunwoo@naver.com', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '010-3868-8803', NOW(), FALSE, FALSE);

INSERT INTO tbl_user (user_code,user_id, user_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (102,'user02', '김나영', 'nayoung@naver.com', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '016-3494-8126', NOW(), FALSE, FALSE);

INSERT INTO tbl_user (user_code,user_id, user_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (103,'user03', '박송이', 'songyi@naver.com', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '011-1190-2653', NOW(), FALSE, FALSE);

INSERT INTO tbl_user (user_code,user_id, user_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (104,'user04', '박성현', 'sunghyun@naver.com', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '011-2245-7620', NOW(), FALSE, FALSE);

INSERT INTO tbl_user (user_code,user_id, user_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (105,'user05', '조수민', 'sumin@naver.com', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '011-7339-7957', NOW(), FALSE, FALSE);

INSERT INTO tbl_user (user_code,user_id, user_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (106,'user06', '허아름', 'areum@daum.net', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '016-4814-3905', NOW(), FALSE, FALSE);

INSERT INTO tbl_roles (role_code, role_name) VALUES (1, 'ADMIN');
INSERT INTO tbl_roles (role_code, role_name) VALUES (2, 'USER');

INSERT INTO tbl_user_roles (user_code, role_code) VALUES (1, 1);
INSERT INTO tbl_user_roles (user_code, role_code) VALUES (1, 2);

INSERT INTO tbl_user_roles (user_code, role_code) VALUES (101, 2);
INSERT INTO tbl_user_roles (user_code, role_code) VALUES (102, 2);
INSERT INTO tbl_user_roles (user_code, role_code) VALUES (103, 2);
INSERT INTO tbl_user_roles (user_code, role_code) VALUES (104, 2);
INSERT INTO tbl_user_roles (user_code, role_code) VALUES (105, 2);
INSERT INTO tbl_user_roles (user_code, role_code) VALUES (106, 2);

ALTER TABLE tbl_user AUTO_INCREMENT = 107;

-- 📌 서울/경기 지역 호텔 데이터

-- 📌 충청 지역 호텔 데이터

-- 📌 강원 지역 호텔 데이터

-- 📌 제주 지역 호텔 데이터
INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3)
VALUES ('제주', '롯데호텔 제주', '제주특별자치도 서귀포시 중문관광로72번길 35', 250000,
        '롯데호텔 제주는 언제나 내 집과 같은 편안함과 아늑함을 제공합니다.',
        '064-731-1000', NOW(), 4, 800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/jeju-hotel.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/jeju-hotel2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/din-LTJE.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3)
VALUES ('제주','제주 신라호텔','제주특별자치도 서귀포시 특별자치도, 중문관광로72번길 75', 250000,
        '내 집과 같은 편안함으로 공간 이상의 가치가 숨쉬고 있는 제주 신라호텔.',
        '064-735-5114', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/sinla.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/sinla2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/sinla3.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4)
VALUES ('제주','해비치 호텔 & 리조트 제주','제주특별자치도 서귀포시 표선면 민속해안로 537', 250000,
        '''해가 처음 비추는 곳''이라는 뜻의 해비치 호텔앤드리조트는 때묻지 않은 자연 그대로의 제주와 에메랄드빛 바다가 한눈에 펼쳐지는 아름다운 곳에 위치하고 있습니다.',
        '064-780-8100', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/havichi-jeju4.jpg' );

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3)
VALUES ('제주','메종 글래드 제주','제주시 KR특별자치도 제주시 연동 노연로 80', 250000,
        '편리하고 편안하게 제대로 즐기는 제주, 누구보다 제주를 더 잘 아는 사람들이 색다른 머무름을 위해 만든 메종 글래드 제주에서 행복한 추억을 만들 수 있을 것 입니다.',
        '064-747-4900', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/MAISON_GLAD_JEJU.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/MAISON_GLAD_JEJU2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/MAISON_GLAD_JEJU3.jpg'
        );

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3)
VALUES ('제주','그랜드 하얏트 제주','제주특별자치도 제주시 노연로 12', 250000,
        '제주 시내 중심에 위치한 랜드마크 제주 드림타워에서 모던 코리안 라이프 스타일을 경험하세요.',
        '064-907-1234', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/GrandHyatt.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/GrandHyatt2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/GrandHyatt4.jpg'
        );
-- 📌 전라 지역 호텔 데이터

-- 📌 경상 지역 호텔 데이터

-- 📌 다음 신규 숙소 ID를 31부터 시작하도록 설정
