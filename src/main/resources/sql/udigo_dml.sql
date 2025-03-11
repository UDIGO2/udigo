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

-- 📌 서울/경기 호텔 데이터
INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES('서울/경기', '롯데호텔 서울', '서울특별시 중구 을지로 30', 150000,
       '롯데호텔 서울은 최고의 편안함과 서비스를 제공합니다.',  '02-771-1000', NOW(), 3, 403,
       'hotel1_1.jpg',
       'hotel1_2.jpg',
       'hotel1_3.jpg',
       'hotel1_4.jpg',
       'hotel1_5.jpg');

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES('서울/경기', '신라호텔 서울','서울특별시 중구 동호로 249', 250000,
       '신라호텔 서울은 최고의 편안함과 서비스를 제공합니다.', '02-2233-3131', NOW(), 6, 540,
       'hotel2_1.jpg',
       'hotel2_2.jpg',
       'hotel2_3.jpg',
       'hotel2_4.jpg',
       'hotel2_5.jpg');

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES('서울/경기', '웨스틴조선 서울', '서울특별시 중구 동호로 249', 200000,
       '웨스틴조선 서울은 최고의 편안함과 서비스를 제공합니다.', '02-2233-3131', NOW(), 4,78,
       'hotel3_1.jpg',
       'hotel3_2.jpg',
       'hotel3_3.jpg',
       'hotel3_4.jpg',
       'hotel3_5.jpg');

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES('서울/경기', '송암스페이스센터', '경기도 양주시 장흥면 권율로185번길 103',
       63000,'송암 스페이스센터는 최고의 편안함과 서비스를 제공합니다.', '031-894-6000', NOW(), 2, 87,
       'hotel4_1.jpg',
       'hotel4_2.jpg',
       'hotel4_3.jpg',
       'hotel4_4.jpg',
       'hotel4_5.jpg');

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('서울/경기', '홈즈스테이 수원', '경기 수원시 팔달구 인계로 116',54000,
        '홈즈스테이 수원에서 삶을 풍요롭게 하는 다채로운 경험의 시간을 누리세요.', '031-233-0338', NOW(),2, 32,
        'hotel5_1.jpg',
        'hotel5_2.jpg',
        'hotel5_3.jpg',
        'hotel5_4.jpg',
        'hotel5_5.jpg');

-- 📌 충청 지역 호텔 데이터
INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('충청', '롯데리조트 부여', '충남 부여군 규암면 백제문로 400',137800,
        '부여의 역사와 문화를 체험할 수 있는 고급 리조트로, 가족 또는 연인과 특별한 추억을 만들 수 있습니다.', '010-1200-9616', NOW(), 6, 501,
        'hotel6_1.jpg',
        'hotel6_2.jpg',
        'hotel6_3.jpg',
        'hotel6_4.jpg',
        'hotel6_5.jpg');

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('충청', '신라스테이 천안', '충남 천안시 서북구 동서대로 177',137800,
        '비즈니스와 관광 모두에 적합한 현대적인 시설을 갖춘 호텔입니다. ', '041-415-9000', NOW(), 6, 501,
        'hotel6_1.jpg',
        'hotel6_2.jpg',
        'hotel6_3.jpg',
        'hotel6_4.jpg',
        'hotel6_5.jpg');

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('충청', '솔라고 리조트 태안', '충남 태안군 태안읍 기업도시9길 205 솔라고리조트', 239000,
        '아름다운 해안선을 따라 위치한 리조트로, 다양한 레저 시설을 제공합니다. ', '041-670-8887', NOW(), 12, 640,
        'hotel8_1.jpg',
        'hotel8_2.jpg',
        'hotel8_3.jpg',
        'hotel8_4.jpg',
        'hotel8_5.jpg');

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('충청', '오무아무아 풀빌라 단양', '충북 단양군 대강면 괴평리 164', 221000,
        '자연 속 한적한 시골마을에 위치한 독채 풀빌라로, 총 다섯 개의 복층 객실이 있으며, 각 객실별로 프라이빗한 야외정원과 4계절 야외 온수 풀이 갖추어져 있습니다. ', '0507-1497-1555', NOW(), 4, 50,
        'hotel9_1.jpg',
        'hotel9_2.jpg',
        'hotel9_3.jpg',
        'hotel9_4.jpg',
        'hotel9_5.jpg');

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('충청', '한옥스테이 연 청주', '충북 청주시 청원구 오창읍 미래지로 71-67 한옥스테이연', 68000,
        '청주시 오창읍 미래지 테마공원에 위치한 한옥스테이로, 전통의 아름다움과 한옥의 평온한 휴식을 즐길 수 있는 독채 공간입니다. ', '043-212-8959', NOW(), 6, 89,
        'hotel10_1.jpg',
        'hotel10_2.jpg',
        'hotel10_3.jpg',
        'hotel10_4.jpg',
        'hotel10_5.jpg');

-- 📌 강원 지역 호텔 데이터
INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('강원', '강릉 오션뷰 호텔', '강원도 강릉시 해변로 123', 120000,
        '무료 Wi-Fi, 주차장, 조식 포함, 바다 전망 ', '033-123-4567', NOW(), 4, 77,
        'hotel10_1.jpg',
        'hotel10_2.jpg',
        'hotel10_3.jpg',
        'hotel10_4.jpg',
        'hotel10_5.jpg');

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('강원', '춘천 한옥 스테이', '강원도 춘천시 한옥길 45', 90000,
        '전통 한옥 체험, 정원, 무료 조식, 바베큐 시설 ', '033-987-6543', NOW(), 4, 102,
        'hotel10_1.jpg',
        'hotel10_2.jpg',
        'hotel10_3.jpg',
        'hotel10_4.jpg',
        'hotel10_5.jpg');

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('강원', '평창 스키 리조트', '강원도 평창군 올림픽로 567', 250000,
        '무료 Wi-Fi, 주차장, 조식 포함, 바다 전망 ', '033-567-8901', NOW(), 4, 77,
        'hotel10_1.jpg',
        'hotel10_2.jpg',
        'hotel10_3.jpg',
        'hotel10_4.jpg',
        'hotel10_5.jpg');

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('강원', '속초 바다 펜션', '강원도 속초시 해변길 89', 70000,
        '무료 Wi-Fi, 주차장, 조식 포함, 바다 전망 ', '033-432-1098', NOW(), 4, 77,
        'hotel10_1.jpg',
        'hotel10_2.jpg',
        'hotel10_3.jpg',
        'hotel10_4.jpg',
        'hotel10_5.jpg');

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('강원', '홍천 캠핑 글램핑', '강원도 홍천군 산속길 321', 150000,
        '무료 Wi-Fi, 주차장, 조식 포함, 바다 전망 ', '033-321-6547', NOW(), 4, 77,
        'hotel10_1.jpg',
        'hotel10_2.jpg',
        'hotel10_3.jpg',
        'hotel10_4.jpg',
        'hotel10_5.jpg');

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

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4)
VALUES ('전라','쏠비치 호텔앤리조트','진도 전라남도 진도군 의신면 송군길 30-40', 250000,
        '''해가 처음 비추는 곳''이라는 뜻의 해비치 호텔앤드리조트는 때묻지 않은 자연 그대로의 제주와 에메랄드빛 바다가 한눈에 펼쳐지는 아름다운 곳에 위치하고 있습니다.',
        '061-123-4567', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/havichi-jeju4.jpg' );

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4)
VALUES ('전라','소노벨 변산','부안군 변산면 변산해변로 51', 250000,
        '''해가 처음 비추는 곳''이라는 뜻의 해비치 호텔앤드리조트는 때묻지 않은 자연 그대로의 제주와 에메랄드빛 바다가 한눈에 펼쳐지는 아름다운 곳에 위치하고 있습니다.',
        '063-123-4567', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/havichi-jeju4.jpg' );

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4)
VALUES ('전라','소노캄 여수','전라남도 여수시 오동도로 111', 250000,
        '''해가 처음 비추는 곳''이라는 뜻의 해비치 호텔앤드리조트는 때묻지 않은 자연 그대로의 제주와 에메랄드빛 바다가 한눈에 펼쳐지는 아름다운 곳에 위치하고 있습니다.',
        '061-123-4568', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/havichi-jeju4.jpg' );

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4)
VALUES ('전라','홀리데이 인 광주호텔','광주광역시 서구 상무누리로 55', 250000,
        '''해가 처음 비추는 곳''이라는 뜻의 해비치 호텔앤드리조트는 때묻지 않은 자연 그대로의 제주와 에메랄드빛 바다가 한눈에 펼쳐지는 아름다운 곳에 위치하고 있습니다.',
        '062-610-7000', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/havichi-jeju4.jpg' );

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4)
VALUES ('전라','베스트웨스턴플러스 전주호텔','전라북도 전주시 완산구 현무1길 4', 250000,
        '''해가 처음 비추는 곳''이라는 뜻의 해비치 호텔앤드리조트는 때묻지 않은 자연 그대로의 제주와 에메랄드빛 바다가 한눈에 펼쳐지는 아름다운 곳에 위치하고 있습니다.',
        '063-123-4569', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/havichi-jeju4.jpg' );
-- 📌 경상 지역 호텔 데이터

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4)
VALUES ('경상','그랜드 머큐어 앰배서더','창원  경상남도 창원시 의창구 원이대로 332', 250000,
        '''해가 처음 비추는 곳''이라는 뜻의 해비치 호텔앤드리조트는 때묻지 않은 자연 그대로의 제주와 에메랄드빛 바다가 한눈에 펼쳐지는 아름다운 곳에 위치하고 있습니다.',
        '063-123-4569', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/havichi-jeju4.jpg' );

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4)
VALUES ('경상','베스트웨스턴플러스 전주호텔','전라북도 전주시 완산구 현무1길 4', 250000,
        '''해가 처음 비추는 곳''이라는 뜻의 해비치 호텔앤드리조트는 때묻지 않은 자연 그대로의 제주와 에메랄드빛 바다가 한눈에 펼쳐지는 아름다운 곳에 위치하고 있습니다.',
        '055-600-0700', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/havichi-jeju4.jpg' );

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4)
VALUES ('경상','토요코인 창원','경상남도 창원시 성산구 중앙대로 93', 250000,
        '''해가 처음 비추는 곳''이라는 뜻의 해비치 호텔앤드리조트는 때묻지 않은 자연 그대로의 제주와 에메랄드빛 바다가 한눈에 펼쳐지는 아름다운 곳에 위치하고 있습니다.',
        '055-282-1045', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/havichi-jeju4.jpg' );

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4)
VALUES ('경상','마산관광호텔','경상남도 창원시 마산합포구 수산1길 285', 250000,
        '''해가 처음 비추는 곳''이라는 뜻의 해비치 호텔앤드리조트는 때묻지 않은 자연 그대로의 제주와 에메랄드빛 바다가 한눈에 펼쳐지는 아름다운 곳에 위치하고 있습니다.',
        '055-123-4567', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/havichi-jeju4.jpg' );

INSERT INTO tbl_acm (acm_location, acm_name, acm_adress , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4)
VALUES ('경상','롯데호텔 김해','경상남도 김해시 장유로 38번길 33', 250000,
        '''해가 처음 비추는 곳''이라는 뜻의 해비치 호텔앤드리조트는 때묻지 않은 자연 그대로의 제주와 에메랄드빛 바다가 한눈에 펼쳐지는 아름다운 곳에 위치하고 있습니다.',
        '055-123-4568', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/havichi-jeju4.jpg' );


