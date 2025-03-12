INSERT INTO tbl_member (member_code, member_id, member_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (1,'admin', 'admin', 'admin@naver.com', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', NULL, NOW(), TRUE, FALSE);

INSERT INTO tbl_member (member_code, member_id, member_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (101,'member01', '김건우', 'gunwoo@naver.com', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '010-3868-8803', NOW(), FALSE, FALSE);

INSERT INTO tbl_member (member_code, member_id, member_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (102,'member02', '김나영', 'nayoung@naver.com', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '016-3494-8126', NOW(), FALSE, FALSE);

INSERT INTO tbl_member (member_code, member_id, member_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (103,'member03', '박송이', 'songyi@naver.com', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '011-1190-2653', NOW(), FALSE, FALSE);

INSERT INTO tbl_member (member_code, member_id, member_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (104,'member04', '박성현', 'sunghyun@naver.com', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '011-2245-7620', NOW(), FALSE, FALSE);

INSERT INTO tbl_member (member_code, member_id, member_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (105,'member05', '조수민', 'sumin@naver.com', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '011-7339-7957', NOW(), FALSE, FALSE);

INSERT INTO tbl_member (member_code, member_id, member_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (106,'member06', '허아름', 'areum@daum.net', '9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c', '016-4814-3905', NOW(), FALSE, FALSE);

INSERT INTO tbl_roles (role_code, role_name) VALUES (1, 'ADMIN');
INSERT INTO tbl_roles (role_code, role_name) VALUES (2, 'member');

INSERT INTO tbl_member_roles (member_code, role_code) VALUES (1, 1);
INSERT INTO tbl_member_roles (member_code, role_code) VALUES (1, 2);

INSERT INTO tbl_member_roles (member_code, role_code) VALUES (101, 2);
INSERT INTO tbl_member_roles (member_code, role_code) VALUES (102, 2);
INSERT INTO tbl_member_roles (member_code, role_code) VALUES (103, 2);
INSERT INTO tbl_member_roles (member_code, role_code) VALUES (104, 2);
INSERT INTO tbl_member_roles (member_code, role_code) VALUES (105, 2);
INSERT INTO tbl_member_roles (member_code, role_code) VALUES (106, 2);

ALTER TABLE tbl_member AUTO_INCREMENT = 107;

-- 📌 서울/경기 호텔 데이터
INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES('서울/경기', '롯데호텔 서울', '서울특별시 중구 을지로 30', 150000,
       '롯데호텔 서울은 최고의 편안함과 서비스를 제공합니다.',  '02-771-1000', NOW(), 3, 403,
       'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/lotte1.jpg',
       'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/lotte2.jpg',
       'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/lotte3.jpg',
       'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/lotte4.jpg',
       'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/lotte5.jpg');

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES('서울/경기', '신라호텔 서울','서울특별시 중구 동호로 249', 250000,
       '신라호텔 서울은 최고의 편안함과 서비스를 제공합니다.', '02-2233-3131', NOW(), 6, 540,
       'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/shila.jpg',
       'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/shila2.jpg',
       'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/shila3.jpg',
       'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/shila4.jpg',
       'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/shila5.png'
      );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES('서울/경기', '웨스틴조선 서울', '서울특별시 중구 동호로 249', 200000,
       '웨스틴조선 서울은 최고의 편안함과 서비스를 제공합니다.', '02-2233-3131', NOW(), 4,78,
       'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/josun1.jpg',
       'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/josun2.jpg',
       'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/josun3.jpg',
       'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/josun4.jpg',
       'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/josun5.jpg');


INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES('서울/경기', '송암스페이스센터', '경기도 양주시 장흥면 권율로185번길 103',63000,
       '송암 스페이스센터는 최고의 편안함과 서비스를 제공합니다.', '031-894-6000', NOW(), 2, 87,
       'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/space1.jpg',
       'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/space2.jpg',
       'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/space3.jpg',
       'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/space4.jpg',
       'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/space5.jpg'
      );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('서울/경기', '홈즈스테이 수원', '경기 수원시 팔달구 인계로 116',54000,
        '홈즈스테이 수원에서 삶을 풍요롭게 하는 다채로운 경험의 시간을 누리세요.', '031-233-0338', NOW(),2, 32,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/suwon.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/suwon2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/suwon3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/suwon4.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/seoul/suwon5.jpg'
       );

-- 📌 충청 지역 호텔 데이터
INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('충청', '롯데리조트 부여', '충남 부여군 규암면 백제문로 400',137800,
        '부여의 역사와 문화를 체험할 수 있는 고급 리조트로, 가족 또는 연인과 특별한 추억을 만들 수 있습니다.', '010-1200-9616', NOW(), 6, 501,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/buyeo1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/buyeo2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/buyeo3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/buyeo4.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/buyeo.jpg'
       );


INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4)
VALUES ('충청', '신라스테이 천안', '충남 천안시 서북구 동서대로 177',137800,
        '비즈니스와 관광 모두에 적합한 현대적인 시설을 갖춘 호텔입니다. ', '041-415-9000', NOW(), 6, 501,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/shilla1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/shilla2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/shilla3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/shilla4.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4)
VALUES ('충청', '솔라고 리조트 태안', '충남 태안군 태안읍 기업도시9길 205 솔라고리조트', 239000,
        '아름다운 해안선을 따라 위치한 리조트로, 다양한 레저 시설을 제공합니다. ', '041-670-8887', NOW(), 12, 640,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/solago1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/solago1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/solago1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/solago1.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('충청', '오무아무아 풀빌라 단양', '충북 단양군 대강면 괴평리 164', 221000,
        '자연 속 한적한 시골마을에 위치한 독채 풀빌라로, 총 다섯 개의 복층 객실이 있으며, 각 객실별로 프라이빗한 야외정원과 4계절 야외 온수 풀이 갖추어져 있습니다. ', '0507-1497-1555', NOW(), 4, 50,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/omuamua1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/omuamua1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/omuamua1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/omuamua1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/omuamua1.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('충청', '한옥스테이 연 청주', '충북 청주시 청원구 오창읍 미래지로 71-67 한옥스테이연', 68000,
        '청주시 오창읍 미래지 테마공원에 위치한 한옥스테이로, 전통의 아름다움과 한옥의 평온한 휴식을 즐길 수 있는 독채 공간입니다. ', '043-212-8959', NOW(), 6, 89,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/yeon1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/yeon1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/yeon1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/yeon1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/chuncheong/yeon1.jpg'
       );

-- 📌 강원 지역 호텔 데이터
INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('강원', '강릉 오션뷰 호텔', '강원도 강릉시 해변로 123', 120000,
        '동해의 아름다운 전경을 감상하며 럭셔리한 휴식을 즐길 수 있는 최고의 해안가 호텔입니다.', '033-123-4567', NOW(), 4, 77,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/gangreung1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/gangreung1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/gangreung1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/gangreung1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/gangreung1.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('강원', '춘천 한옥 스테이', '강원도 춘천시 한옥길 45', 90000,
        '전통 한옥 체험이 가능한, 정원이 아름다운 한옥 스테이입니다.', '033-987-6543', NOW(), 4, 102,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/chuncheon1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/chuncheon1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/chuncheon1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/chuncheon1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/chuncheon1.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('강원', '평창 스키 리조트', '강원도 평창군 올림픽로 567', 250000,
        '평창 스키 리조트는 세계적인 수준의 슬로프와 아름다운 설경을 자랑하는 대한민국 최고의 겨울 스포츠 명소입니다.', '033-567-8901', NOW(), 4, 77,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/pyungchang1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/pyungchang1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/pyungchang1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/pyungchang1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/pyungchang1.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4)
VALUES ('강원', '속초 바다 펜션', '강원도 속초시 해변길 89', 70000,
        '속초 바다 펜션은 푸른 동해를 한눈에 담을 수 있는 오션뷰 숙소로, 여유로운 휴식과 감성적인 힐링을 선사합니다.', '033-432-1098', NOW(), 4, 77,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/sokcho1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/sokcho1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/sokcho1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/sokcho1.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('강원', '홍천 캠핑 글램핑', '강원도 홍천군 산속길 321', 150000,
        '청정 자연 속에서 캠핑의 자유로움과 글램핑의 편안함을 동시에 즐길 수 있는 힐링 명소입니다.', '033-321-6547', NOW(), 4, 77,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/hongcheon1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/hongcheon1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/hongcheon1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/hongcheon1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gangwon/hongcheon1.jpg'
       );

-- 📌 제주 지역 호텔 데이터
INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3)
VALUES ('제주', '롯데호텔 제주', '제주특별자치도 서귀포시 중문관광로72번길 35', 250000,
        '롯데호텔 제주는 언제나 내 집과 같은 편안함과 아늑함을 제공합니다.',
        '064-731-1000', NOW(), 4, 800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/jeju-hotel.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/jeju-hotel2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/din-LTJE.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3)
VALUES ('제주','제주 신라호텔','제주특별자치도 서귀포시 특별자치도, 중문관광로72번길 75', 250000,
        '내 집과 같은 편안함으로 공간 이상의 가치가 숨쉬고 있는 제주 신라호텔.',
        '064-735-5114', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/sinla.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/sinla2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/sinla3.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4)
VALUES ('제주','해비치 호텔 & 리조트 제주','제주특별자치도 서귀포시 표선면 민속해안로 537', 250000,
        '''해가 처음 비추는 곳''이라는 뜻의 해비치 호텔앤드리조트는 때묻지 않은 자연 그대로의 제주와 에메랄드빛 바다가 한눈에 펼쳐지는 아름다운 곳에 위치하고 있습니다.',
        '064-780-8100', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/haevichi-jeju3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/havichi-jeju4.jpg' );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3)
VALUES ('제주','메종 글래드 제주','제주시 KR특별자치도 제주시 연동 노연로 80', 250000,
        '편리하고 편안하게 제대로 즐기는 제주, 누구보다 제주를 더 잘 아는 사람들이 색다른 머무름을 위해 만든 메종 글래드 제주에서 행복한 추억을 만들 수 있을 것 입니다.',
        '064-747-4900', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/MAISON_GLAD_JEJU.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/MAISON_GLAD_JEJU2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/MAISON_GLAD_JEJU3.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3)
VALUES ('제주','그랜드 하얏트 제주','제주특별자치도 제주시 노연로 12', 250000,
        '제주 시내 중심에 위치한 랜드마크 제주 드림타워에서 모던 코리안 라이프 스타일을 경험하세요.',
        '064-907-1234', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/GrandHyatt.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/GrandHyatt2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeju/GrandHyatt4.jpg'
       );
-- 📌 전라 지역 호텔 데이터

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4)
VALUES ('전라','쏠비치 호텔앤리조트','진도 전라남도 진도군 의신면 송군길 30-40', 250000,
        '언제나 최상의 서비스를 제공해드리고 행복한 추억을 만들 수 있는 장소, 쏠비치입니다.',
        '061-123-4567', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeonla/solbeach1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeonla/solbeach2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeonla/solbeach3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeonla/solbeach4.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4)
VALUES ('전라','소노벨 변산','부안군 변산면 변산해변로 51', 250000,
        '변산반도의 아름다운 해변과 함께 여유로운 휴식을 즐길 수 있는 가족 친화형 리조트입니다.',
        '063-123-4567', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeonla/sonobell1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeonla/sonobell2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeonla/sonobell3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeonla/sonobell4.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3)
VALUES ('전라','소노캄 여수','전라남도 여수시 오동도로 111', 250000,
        '여수 밤바다의 환상적인 전망과 럭셔리한 서비스를 제공하는 고품격 호텔입니다.',
        '061-123-4568', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeonla/sonocam1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeonla/sonocam2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeonla/sonocam3.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4)
VALUES ('전라','홀리데이 인 광주호텔','광주광역시 서구 상무누리로 55', 250000,
        '광주의 중심에서 세련된 객실과 편리한 접근성을 갖춘 비즈니스 및 관광객을 위한 호텔입니다.',
        '062-610-7000', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeonla/holyday1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeonla/holyday2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeonla/holyday3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeonla/holyday4.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3)
VALUES ('전라','베스트웨스턴플러스 전주호텔','전라북도 전주시 완산구 현무1길 4', 250000,
        '전주 한옥마을과 가까운 최적의 위치에서 편안한 숙박을 제공하는 모던한 스타일의 호텔입니다.',
        '063-123-4569', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeonla/western1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeonla/western2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/jeonla/western3.jpg'
       );
-- 📌 경상 지역 호텔 데이터

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4,acm_photo5)
VALUES ('경상','그랜드 머큐어 앰배서더','창원  경상남도 창원시 의창구 원이대로 332', 250000,
        '품격 있는 서비스와 모던한 인테리어를 갖춘 고급 레지던스 호텔로, 장기 투숙객에게 최적화된 숙소입니다.',
        '063-123-4569', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/grand1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/grand2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/grand3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/grand4.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/grand5.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4,acm_photo5)
VALUES ('경상','토요코인 창원','경상남도 창원시 성산구 중앙대로 93', 250000,
        '합리적인 가격과 깔끔한 객실을 제공하는 비즈니스 호텔로, 창원 중심에서 편리한 숙박을 제공합니다.',
        '055-282-1045', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/toyo1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/toyo2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/toyo3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/toyo4.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/toyo5.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4,acm_photo5)
VALUES ('경상','마산관광호텔','경상남도 창원시 마산합포구 수산1길 285', 250000,
        '마산만의 멋진 전망과 함께 전통적인 호텔 서비스가 조화를 이루는 편안한 숙소입니다.',
        '055-123-4567', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/masan1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/masan2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/masan3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/masan4.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/masan5.jpg'
       );


INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4,acm_photo5)
VALUES ('경상','롯데호텔 김해','경상남도 김해시 장유로 38번길 33', 250000,
        '김해공항과 가까운 위치에 자리한 럭셔리 호텔로, 비즈니스와 여행객 모두에게 최적의 편의 시설을 제공합니다.',
        '055-123-4568', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/lotte1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/lotte2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/lotte3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/lotte4.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/lotte5.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4,acm_photo5)
VALUES ('경상','STX 리조트 문경','경상북도 문경시 농암면 청화로 509', 250000,
        '가장 한국적인 곳 경주, 세련된 감각의 인테리어 힐튼호텔에서의 특별한 하루',
        '054-123-4569', NOW(), 4,800,
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/stx1.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/stx2.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/stx3.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/stx4.jpg',
        'https://github.com/UDIGO2/udigo-midea/blob/main/images/gueongsang/stx5.jpg'
       );


INSERT INTO tbl_cart (member_code, acm_id) VALUES
                                               (101, 101),
                                               (101, 201),
                                               (102, 202),
                                               (102, 203),
                                               (103, 101),
                                               (103, 202),
                                               (104, 203),
                                               (104, 301),
                                               (105, 303),
                                               (106, 305);


INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES
-- 1번 결제 데이터 (카카오페이, 결제완료)
(1, 101, 101, '카드결제', 1, '카드', '2025-03-11 14:25:00',
 150000, 5000, 0, 'TID1234567890', 'KAKAO'),

(2, 102, 102, '간편결제', 1, '네이버페이', '025-03-14 11:30:00',
 130000, 5000, 0, 'TID1122334455', 'NAVER'),

-- 2번 결제 데이터 (토스페이, 결제취소)
(3, 103, 103, '간편결제', 2, '계좌이체', '2025-03-12 10:10:00',
 200000, 5000, 200000, 'TID0987654321', 'TOSS'),

-- 3번 결제 데이터 (이니시스, 환불완료)
(4, 104, 203, '카드결제', 2, '신한카드', '2025-03-15 16:20:00',
 170000, 5000, 170000, 'TID5566778899', 'SHINHAN'),

(5, 105, 301, '카드결제', 3, '카드', '2025-03-13 18:45:00',
 180000, 5000, 180000, 'TID5678901234', 'INICIS'),

(6, 106, 401, '카드결제', 3, '카카오페이', '2025-03-16 09:00:00',
 140000, 5000, 140000, 'TID7788990011', 'KAKAO');

-- 게시판 관련 dml

INSERT INTO `tbl_board_posts` (`member_code`, `board_type`, `title`, `content`, `created_at`, `updated_at`) VALUES
-- 공지사항 (board_type = 1)
(1, 1, '호텔 리노베이션 안내', '안녕하세요, 고객 여러분! 호텔 내부 리노베이션 공사가 진행될 예정입니다. 이용에 참고 부탁드립니다.', NOW(), NULL),
(1, 1, '객실 요금 변경 안내', '다가오는 성수기에 맞춰 객실 요금이 조정될 예정입니다. 자세한 내용은 공식 홈페이지를 참고해주세요.', NOW(), NULL),
(1, 1, '수영장 이용 시간 변경', '호텔 수영장의 운영 시간이 조정되었습니다. 변경된 운영 시간은 오전 8시부터 오후 10시까지입니다.', NOW(), NULL),

-- FAQ (board_type = 2)
(1, 2, '체크인 및 체크아웃 시간은 언제인가요?', '체크인은 오후 3시부터 가능하며, 체크아웃은 오전 11시까지 완료해주셔야 합니다.', NOW(), NULL),
(1, 2, '반려동물 동반 입실이 가능한가요?', '죄송합니다. 당 호텔은 반려동물 동반 입실을 제한하고 있습니다.', NOW(), NULL),
(1, 2, '추가 침대 요청이 가능한가요?', '네, 가능하지만 추가 요금이 발생할 수 있으며 사전 요청이 필요합니다.', NOW(), NULL),

-- 1대1 질문 (board_type = 3)
(101,3, '객실 예약 변경이 가능한가요?', '예약한 객실을 다른 날짜로 변경하고 싶습니다. 가능할까요?', NOW(), NULL),
(101,3, '객실 예약 취소가가가가가이 가능한가요?', '취소가가가가가가가한 객실을 다른 날짜로 변경하고 싶습니다. 가능할까요?', NOW(), NULL),
(102,3, '객실 예약 변경이 가능한가요요요요요요?', '요요요요예약한 객실을 다른 날짜로 변경하고 싶습니다. 가능할까요?', NOW(), NULL),
(102, 3, '조식 포함 여부 문의', '예약한 객실에 조식이 포함되어 있는지 확인하고 싶습니다.', NOW(), NULL),
(103, 3, '공항 픽업 서비스가 있나요?', '호텔에서 공항까지 픽업 서비스를 제공하나요? 제공된다면 이용 방법을 알려주세요.', NOW(), NULL
);

INSERT INTO `tbl_board_comments` (`post_id`,`content`,`created_at`) VALUES
(7,'답면변변벼녑ㄴ변',NOW()),
(1,'답면변변벼녑ㄴ변',NOW()),
(8,'답면변변벼녑ㄴ변222222222',NOW()),
(9,'답면변변벼녑ㄴ변33333333',NOW()),
(10,'답면변변벼녑ㄴ변44444444',NOW()),
(11,'답면변변벼녑ㄴ변555555555',NOW());



INSERT INTO `tbl_reservations` (acm_id, member_code, check_in, check_out, guest_count, is_resv,created_at) VALUES
(101,101,'2025-03-11','2025-03-14',3,true,NOW()),
(101,101,'2025-03-15','2025-03-19',3,true,NOW()),
# (101,102,'2025-03-18','2025-03-20',3,true,NOW()), #넣으려면 주석
(102,103,'2025-03-11','2025-03-14',3,true,NOW()),
(103,104,'2025-03-11','2025-03-14',3,true,NOW()),
(104,104,'2025-03-11','2025-03-14',3,true,NOW()),
# (104,105,'2025-03-13','2025-03-15',3,true,NOW()), #넣으려면 주석
(105,105,'2025-03-11','2025-03-14',3,true,NOW());
