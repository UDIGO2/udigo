INSERT INTO tbl_member (member_code, member_id, member_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (1,'admin', 'admin', 'admin@naver.com', '$2b$12$1C5njm.3fcbzVILGq/K0l.f8LUSdVKyksThdTZm85CYcJpCVv0hBO', NULL, NOW(), TRUE, FALSE);

INSERT INTO tbl_member (member_code, member_id, member_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (101,'member01', '김건우', 'gunwoo@naver.com', '$2b$12$1C5njm.3fcbzVILGq/K0l.f8LUSdVKyksThdTZm85CYcJpCVv0hBO', '010-3868-8803', NOW(), FALSE, FALSE);

INSERT INTO tbl_member (member_code, member_id, member_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (102,'member02', '김나영', 'nayou5g@naver.com', '$2b$12$1C5njm.3fcbzVILGq/K0l.f8LUSdVKyksThdTZm85CYcJpCVv0hBO', '016-3494-8126', NOW(), FALSE, FALSE);

INSERT INTO tbl_member (member_code, member_id, member_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (103,'member03', '박송이', 'songyi@naver.com', '$2b$12$1C5njm.3fcbzVILGq/K0l.f8LUSdVKyksThdTZm85CYcJpCVv0hBO', '011-1190-2653', NOW(), FALSE, FALSE);

INSERT INTO tbl_member (member_code, member_id, member_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (104,'member04', '박성현', 'sunghyun@naver.com', '$2b$12$1C5njm.3fcbzVILGq/K0l.f8LUSdVKyksThdTZm85CYcJpCVv0hBO', '011-2245-7620', NOW(), FALSE, FALSE);

INSERT INTO tbl_member (member_code, member_id, member_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (105,'member05', '조수민', 'sumin@naver.com', '$2b$12$1C5njm.3fcbzVILGq/K0l.f8LUSdVKyksThdTZm85CYcJpCVv0hBO', '011-7339-7957', NOW(), FALSE, FALSE);

INSERT INTO tbl_member (member_code, member_id, member_name, email, password, phone_no, join_date, email_verified, is_locked)
VALUES (106,'member06', '허아름', 'areum@daum.net', '$2b$12$1C5njm.3fcbzVILGq/K0l.f8LUSdVKyksThdTZm85CYcJpCVv0hBO', '016-4814-3905', NOW(), FALSE, FALSE);

-- 쿠폰을 사용한 회원 (ACTIVE)
INSERT INTO tbl_member (member_code, member_id, member_name, email, password, phone_no, join_date, email_verified, is_locked, status, rejoin_at, coupon_used, deleted_at)
VALUES (107, 'member07', '김철수', 'chulsoo@example.com', '$2b$12$N7uLMTh9nydkZ6zSx/HWJe0wuqrKV.7BDuIrZMwYYNfGlPt3Hoynm', '010-5678-1234', NOW(), TRUE, FALSE, 'ACTIVE', NULL, TRUE, NULL);

-- 회원 탈퇴한 경우 (WITHDRAWN)
INSERT INTO tbl_member (member_code, member_id, member_name, email, password, phone_no, join_date, email_verified, is_locked, status, rejoin_at, coupon_used, deleted_at)
VALUES (108, 'deleted_member_108', '이영희', 'younghee@example.com', '$2b$12$Ph.Zj22hkoQpzSZ2m9Tx3.2wgkcpUHwehmS6GlNsL7qS5eCvOZSf2', '010-3456-7890', NOW(), TRUE, FALSE, 'WITHDRAWN', NULL, FALSE, NOW());

-- 회원 탈퇴 후 재가입 가능한 경우 (탈퇴 후 30일 경과)
INSERT INTO tbl_member (member_code, member_id, member_name, email, password, phone_no, join_date, email_verified, is_locked, status, rejoin_at, coupon_used, deleted_at)
VALUES (109, 'deleted_member_109', '박민수', 'minsoo@example.com', '$2b$12$LbsixVHkdKcociTjrMfReOjHntFgg.2Cg4S7s4FKynIc3WuzPjwK2', '010-2222-3333', NOW() - INTERVAL 40 DAY, TRUE, FALSE, 'WITHDRAWN', NOW() - INTERVAL 10 DAY, FALSE, NULL);

-- 쿠폰을 사용하고 회원 탈퇴한 경우
INSERT INTO tbl_member (member_code, member_id, member_name, email, password, phone_no, join_date, email_verified, is_locked, status, rejoin_at, coupon_used, deleted_at)
VALUES (110, 'deleted_member_110', '최지현', 'jihyun@example.com', '$2b$12$76ZNMl3GOINU.OU6YYvtYOrKXaLfqg50JMD262vLE73b6Fgyu12M6', '010-7777-8888', NOW() - INTERVAL 20 DAY, TRUE, FALSE, 'WITHDRAWN', NULL, TRUE, NOW());

-- 탈퇴 후 재가입 가능하지만 쿠폰을 사용한 경우
INSERT INTO tbl_member (member_code, member_id, member_name, email, password, phone_no, join_date, email_verified, is_locked, status, rejoin_at, coupon_used, deleted_at)
VALUES (111, 'deleted_member_111', '송다은', 'daeun@example.com', '$2b$12$XORYPlsOAhKsrvLtS08fHOO/IkHt72mkZiFM48vq15RiH0ZhiFpTq', '010-9999-0000', NOW() - INTERVAL 45 DAY, TRUE, FALSE, 'WITHDRAWN', NOW() - INTERVAL 15 DAY, TRUE, NULL);

UPDATE tbl_member SET role = 'ADMIN' WHERE member_code = 1;

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
INSERT INTO tbl_member_roles (member_code, role_code) VALUES (107, 1); -- 쿠폰 사용자
INSERT INTO tbl_member_roles (member_code, role_code) VALUES (108, 1); -- 탈퇴한 사용자
INSERT INTO tbl_member_roles (member_code, role_code) VALUES (109, 1); -- 재가입 가능한 사용자
INSERT INTO tbl_member_roles (member_code, role_code) VALUES (110, 2); -- 쿠폰 사용 후 탈퇴한 사용자
INSERT INTO tbl_member_roles (member_code, role_code) VALUES (111, 1); -- 쿠폰 사용 후 재가입 가능한 사용자

ALTER TABLE tbl_member AUTO_INCREMENT = 112;
--  서울/경기 호텔 데이터
INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES('서울/경기', '롯데호텔 서울', '서울특별시 중구 을지로 30', 150000,
       '롯데호텔 서울은 최고의 편안함과 서비스를 제공합니다.',  '02-771-1000', NOW(), 3, 403,
       '/image/acm/seoul/lotte1.jpg',
       '/image/acm/seoul/lotte2.jpg',
       '/image/acm/seoul/lotte3.jpg',
       '/image/acm/seoul/lotte4.jpg',
       '/image/acm/seoul/lotte5.jpg');

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES('서울/경기', '신라호텔 서울','서울특별시 중구 동호로 249', 250000,
       '신라호텔 서울은 최고의 편안함과 서비스를 제공합니다.', '02-2233-3131', NOW(), 6, 540,
       '/image/acm/seoul/shila.jpg',
       '/image/acm/seoul/shila2.jpg',
       '/image/acm/seoul/shila3.jpg',
       '/image/acm/seoul/shila4.jpg',
       '/image/acm/seoul/shila5.png'
      );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES('서울/경기', '웨스틴조선 서울', '서울특별시 중구 동호로 249', 200000,
       '웨스틴조선 서울은 최고의 편안함과 서비스를 제공합니다.', '02-2233-3131', NOW(), 4,78,
       '/image/acm/seoul/josun1.jpg',
       '/image/acm/seoul/josun2.jpg',
       '/image/acm/seoul/josun3.jpg',
       '/image/acm/seoul/josun4.jpg',
       '/image/acm/seoul/josun5.jpg');


INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES('서울/경기', '송암스페이스센터', '경기도 양주시 장흥면 권율로185번길 103',63000,
       '송암 스페이스센터는 최고의 편안함과 서비스를 제공합니다.', '031-894-6000', NOW(), 2, 87,
       '/image/acm/seoul/space1.jpg',
       '/image/acm/seoul/space2.jpg',
       '/image/acm/seoul/space3.jpg',
       '/image/acm/seoul/space4.jpg',
       '/image/acm/seoul/space5.jpg'
      );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('서울/경기', '홈즈스테이 수원', '경기 수원시 팔달구 인계로 116',54000,
        '홈즈스테이 수원에서 삶을 풍요롭게 하는 다채로운 경험의 시간을 누리세요.', '031-233-0338', NOW(),2, 32,
        '/image/acm/seoul/suwon.jpg',
        '/image/acm/seoul/suwon2.jpg',
        '/image/acm/seoul/suwon3.jpg',
        '/image/acm/seoul/suwon4.jpg',
        '/image/acm/seoul/suwon5.jpg'
       );

--  충청 지역 호텔 데이터
INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('충청', '롯데리조트 부여', '충남 부여군 규암면 백제문로 400',137800,
        '부여의 역사와 문화를 체험할 수 있는 고급 리조트로, 가족 또는 연인과 특별한 추억을 만들 수 있습니다.', '010-1200-9616', NOW(), 6, 501,
        '/image/acm/chuncheong/buyeo1.jpg',
        '/image/acm/chuncheong/buyeo2.jpg',
        '/image/acm/chuncheong/buyeo3.jpg',
        '/image/acm/chuncheong/buyeo4.jpg',
        '/image/acm/chuncheong/buyeo.jpg'
       );


INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4)
VALUES ('충청', '신라스테이 천안', '충남 천안시 서북구 동서대로 177',137800,
        '비즈니스와 관광 모두에 적합한 현대적인 시설을 갖춘 호텔입니다. ', '041-415-9000', NOW(), 6, 501,
        '/image/acm/chuncheong/shilla1.jpg',
        '/image/acm/chuncheong/shilla2.jpg',
        '/image/acm/chuncheong/shilla3.jpg',
        '/image/acm/chuncheong/shilla4.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4)
VALUES ('충청', '솔라고 리조트 태안', '충남 태안군 태안읍 기업도시9길 205 솔라고리조트', 239000,
        '아름다운 해안선을 따라 위치한 리조트로, 다양한 레저 시설을 제공합니다. ', '041-670-8887', NOW(), 12, 640,
        '/image/acm/chuncheong/solago1.jpg',
        '/image/acm/chuncheong/solago2.jpg',
        '/image/acm/chuncheong/solago3.jpg',
        '/image/acm/chuncheong/solago4.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('충청', '오무아무아 풀빌라 단양', '충북 단양군 대강면 괴평리 164', 221000,
        '자연 속 한적한 시골마을에 위치한 독채 풀빌라로, 총 다섯 개의 복층 객실이 있으며, 각 객실별로 프라이빗한 야외정원과 4계절 야외 온수 풀이 갖추어져 있습니다. ', '0507-1497-1555', NOW(), 4, 50,
        '/image/acm/chuncheong/omuamua1.jpg',
        '/image/acm/chuncheong/omuamua2.jpg',
        '/image/acm/chuncheong/omuamua3.jpg',
        '/image/acm/chuncheong/omuamua4.jpg',
        '/image/acm/chuncheong/omuamua5.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('충청', '한옥스테이 연 청주', '충북 청주시 청원구 오창읍 미래지로 71-67 한옥스테이연', 68000,
        '청주시 오창읍 미래지 테마공원에 위치한 한옥스테이로, 전통의 아름다움과 한옥의 평온한 휴식을 즐길 수 있는 독채 공간입니다. ', '043-212-8959', NOW(), 6, 89,
        '/image/acm/chuncheong/yeon1.jpg',
        '/image/acm/chuncheong/yeon2.jpg',
        '/image/acm/chuncheong/yeon3.jpg',
        '/image/acm/chuncheong/yeon4.jpg',
        '/image/acm/chuncheong/yeon5.jpg'
       );

--  강원 지역 호텔 데이터
INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('강원', '스카이베이 호텔 경포', '강원 강릉시 해안로 476 스카이베이호텔 경포', 120000,
        '동해의 아름다운 전경을 감상하며 럭셔리한 휴식을 즐길 수 있는 최고의 해안가 호텔입니다.', '033-923-2000', NOW(), 4, 77,
        '/image/acm/gangwon/gangreung1.jpg',
        '/image/acm/gangwon/gangreung2.jpg',
        '/image/acm/gangwon/gangreung3.jpg',
        '/image/acm/gangwon/gangreung4.jpg',
        '/image/acm/gangwon/gangreung5.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('강원', '스테이한량', '강원 춘천시 중앙로67번길 42-1 스테이한량', 90000,
        '전통 한옥 체험이 가능한, 정원이 아름다운 한옥 스테이입니다.', '0507-1444-5081', NOW(), 2, 102,
        '/image/acm/gangwon/chuncheon1.jpg',
        '/image/acm/gangwon/chuncheon2.jpg',
        '/image/acm/gangwon/chuncheon3.jpg',
        '/image/acm/gangwon/chuncheon4.jpg',
        '/image/acm/gangwon/chuncheon5.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('강원', '한화리조트 평창', '강원 평창군 봉평면 태기로 228-33 한화리조트 평창', 250000,
        '한화리조트 평창은 세계적인 수준의 슬로프와 아름다운 설경을 자랑하는 대한민국 최고의 겨울 스포츠 명소입니다.', '033-567-8901', NOW(), 8, 77,
        '/image/acm/gangwon/pyungchang1.jpg',
        '/image/acm/gangwon/pyungchang2.jpg',
        '/image/acm/gangwon/pyungchang3.jpg',
        '/image/acm/gangwon/pyungchang4.jpg',
        '/image/acm/gangwon/pyungchang5.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4)
VALUES ('강원', '속초오션뷰 스파펜션 오션 11', '강원 속초시 청호로4길 52 오션11', 70000,
        '오션 11은 푸른 동해를 한눈에 담을 수 있는 오션뷰 숙소로, 여유로운 휴식과 감성적인 힐링을 선사합니다.', '0507-1331-1574', NOW(), 2, 77,
        '/image/acm/gangwon/sokcho1.jpg',
        '/image/acm/gangwon/sokcho2.jpg',
        '/image/acm/gangwon/sokcho3.jpg',
        '/image/acm/gangwon/sokcho4.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('강원', '몬테리오글램핑', '강원 홍천군 서면 마곡리 121-6', 55000,
        '청정 자연 속에서 캠핑의 자유로움과 글램핑의 편안함을 동시에 즐길 수 있는 힐링 명소입니다.', '033-321-6547', NOW(), 4, 77,
        '/image/acm/gangwon/hongcheon1.jpg',
        '/image/acm/gangwon/hongcheon2.jpg',
        '/image/acm/gangwon/hongcheon3.jpg',
        '/image/acm/gangwon/hongcheon4.jpg',
        '/image/acm/gangwon/hongcheon5.jpg'
       );

--  제주 지역 호텔 데이터
INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3)
VALUES ('제주', '롯데호텔 제주', '제주특별자치도 서귀포시 중문관광로72번길 35', 250000,
        '롯데호텔 제주는 언제나 내 집과 같은 편안함과 아늑함을 제공합니다.',
        '064-731-1000', NOW(), 4, 800,
        '/image/acm/jeju/jeju-hotel.jpg',
        '/image/acm/jeju/jeju-hotel2.jpg',
        '/image/acm/jeju/din-LTJE.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4)
VALUES ('제주','제주 신라호텔','제주 서귀포시 중문관광로72번길 75', 250000,
        '내 집과 같은 편안함으로 공간 이상의 가치가 숨쉬고 있는 제주 신라호텔.',
        '064-735-5114', NOW(), 4,10,
        '/image/acm/jeju/silla1.jpg',
        '/image/acm/jeju/silla2.jpg',
        '/image/acm/jeju/silla3.jpg',
        '/image/acm/jeju/silla4.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4)
VALUES ('제주','해비치 호텔 & 리조트 제주','제주특별자치도 서귀포시 표선면 민속해안로 537', 250000,
        '''해가 처음 비추는 곳''이라는 뜻의 해비치 호텔앤드리조트는 때묻지 않은 자연 그대로의 제주와 에메랄드빛 바다가 한눈에 펼쳐지는 아름다운 곳에 위치하고 있습니다.',
        '064-780-8100', NOW(), 4,800,
        '/image/acm/jeju/haevichi-jeju.jpg',
        '/image/acm/jeju/haevichi-jeju2.jpg',
        '/image/acm/jeju/haevichi-jeju3.jpg',
        '/image/acm/jeju/havichi-jeju4.jpg' );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3)
VALUES ('제주','메종 글래드 제주','제주시 KR특별자치도 제주시 연동 노연로 80', 250000,
        '편리하고 편안하게 제대로 즐기는 제주, 누구보다 제주를 더 잘 아는 사람들이 색다른 머무름을 위해 만든 메종 글래드 제주에서 행복한 추억을 만들 수 있을 것 입니다.',
        '064-747-4900', NOW(), 4,800,
        '/image/acm/jeju/MAISON_GLAD_JEJU.jpg',
        '/image/acm/jeju/MAISON_GLAD_JEJU2.jpg',
        '/image/acm/jeju/MAISON_GLAD_JEJU3.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3)
VALUES ('제주','그랜드 하얏트 제주','제주특별자치도 제주시 노연로 12', 250000,
        '제주 시내 중심에 위치한 랜드마크 제주 드림타워에서 모던 코리안 라이프 스타일을 경험하세요.',
        '064-907-1234', NOW(), 4,800,
        '/image/acm/jeju/GrandHyatt.jpg',
        '/image/acm/jeju/GrandHyatt2.jpg',
        '/image/acm/jeju/GrandHyatt4.jpg'
       );
--  전라 지역 호텔 데이터

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4)
VALUES ('전라','쏠비치 호텔앤리조트','진도 전라남도 진도군 의신면 송군길 30-40', 250000,
        '언제나 최상의 서비스를 제공해드리고 행복한 추억을 만들 수 있는 장소, 쏠비치입니다.',
        '061-123-4567', NOW(), 4,800,
        '/image/acm/jeonla/solbeach1.jpg',
        '/image/acm/jeonla/solbeach2.jpg',
        '/image/acm/jeonla/solbeach3.jpg',
        '/image/acm/jeonla/solbeach4.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4)
VALUES ('전라','소노벨 변산','부안군 변산면 변산해변로 51', 250000,
        '변산반도의 아름다운 해변과 함께 여유로운 휴식을 즐길 수 있는 가족 친화형 리조트입니다.',
        '063-123-4567', NOW(), 4,800,
        '/image/acm/jeonla/sonobell1.jpg',
        '/image/acm/jeonla/sonobell2.jpg',
        '/image/acm/jeonla/sonobell3.jpg',
        '/image/acm/jeonla/sonobell4.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3)
VALUES ('전라','소노캄 여수','전라남도 여수시 오동도로 111', 250000,
        '여수 밤바다의 환상적인 전망과 럭셔리한 서비스를 제공하는 고품격 호텔입니다.',
        '061-123-4568', NOW(), 4,800,
        '/image/acm/jeonla/sonocam1.jpg',
        '/image/acm/jeonla/sonocam2.jpg',
        '/image/acm/jeonla/sonocam3.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4)
VALUES ('전라','홀리데이 인 광주호텔','광주광역시 서구 상무누리로 55', 250000,
        '광주의 중심에서 세련된 객실과 편리한 접근성을 갖춘 비즈니스 및 관광객을 위한 호텔입니다.',
        '062-610-7000', NOW(), 4,800,
        '/image/acm/jeonla/holyday1.jpg',
        '/image/acm/jeonla/holyday2.jpg',
        '/image/acm/jeonla/holyday3.jpg',
        '/image/acm/jeonla/holyday4.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3)
VALUES ('전라','베스트웨스턴플러스 전주호텔','전라북도 전주시 완산구 현무1길 4', 250000,
        '전주 한옥마을과 가까운 최적의 위치에서 편안한 숙박을 제공하는 모던한 스타일의 호텔입니다.',
        '063-123-4569', NOW(), 4,800,
        '/image/acm/jeonla/western1.jpg',
        '/image/acm/jeonla/western2.jpg',
        '/image/acm/jeonla/western3.jpg'
       );
--  경상 지역 호텔 데이터

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4,acm_photo5)
VALUES ('경상','그랜드 머큐어 앰배서더','창원  경상남도 창원시 의창구 원이대로 332', 250000,
        '품격 있는 서비스와 모던한 인테리어를 갖춘 고급 레지던스 호텔로, 장기 투숙객에게 최적화된 숙소입니다.',
        '063-123-4569', NOW(), 4,800,
        '/image/acm/gueongsang/grand1.jpg',
        '/image/acm/gueongsang/grand2.jpg',
        '/image/acm/gueongsang/grand3.jpg',
        '/image/acm/gueongsang/grand4.jpg',
        '/image/acm/gueongsang/grand5.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4,acm_photo5)
VALUES ('경상','토요코인 창원','경상남도 창원시 성산구 중앙대로 93', 250000,
        '합리적인 가격과 깔끔한 객실을 제공하는 비즈니스 호텔로, 창원 중심에서 편리한 숙박을 제공합니다.',
        '055-282-1045', NOW(), 4,800,
        '/image/acm/gueongsang/toyo1.jpg',
        '/image/acm/gueongsang/toyo2.jpg',
        '/image/acm/gueongsang/toyo3.jpg',
        '/image/acm/gueongsang/toyo4.jpg',
        '/image/acm/gueongsang/toyo5.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4,acm_photo5)
VALUES ('경상','마산관광호텔','경상남도 창원시 마산합포구 수산1길 285', 250000,
        '마산만의 멋진 전망과 함께 전통적인 호텔 서비스가 조화를 이루는 편안한 숙소입니다.',
        '055-123-4567', NOW(), 4,800,
        '/image/acm/gueongsang/masan1.jpg',
        '/image/acm/gueongsang/masan2.jpg',
        '/image/acm/gueongsang/masan3.jpg',
        '/image/acm/gueongsang/masan4.jpg',
        '/image/acm/gueongsang/masan5.jpg'
       );


INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4,acm_photo5)
VALUES ('경상','롯데호텔 김해','경상남도 김해시 장유로 38번길 33', 250000,
        '김해공항과 가까운 위치에 자리한 럭셔리 호텔로, 비즈니스와 여행객 모두에게 최적의 편의 시설을 제공합니다.',
        '055-123-4568', NOW(), 4,800,
        '/image/acm/gueongsang/lotte1.jpg',
        '/image/acm/gueongsang/lotte2.jpg',
        '/image/acm/gueongsang/lotte3.jpg',
        '/image/acm/gueongsang/lotte4.jpg',
        '/image/acm/gueongsang/lotte5.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3 , acm_photo4,acm_photo5)
VALUES ('경상','STX 리조트 문경','경상북도 문경시 농암면 청화로 509', 250000,
        '가장 한국적인 곳 경주, 세련된 감각의 인테리어 힐튼호텔에서의 특별한 하루',
        '054-123-4569', NOW(), 4,800,
        '/image/acm/gueongsang/stx1.jpg',
        '/image/acm/gueongsang/stx2.jpg',
        '/image/acm/gueongsang/stx3.jpg',
        '/image/acm/gueongsang/stx4.jpg',
        '/image/acm/gueongsang/stx5.jpg'
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


-- 기존 예약과 결제 더미 데이터 연결

-- 1번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             1, 101, 101, '카드결제', '결제완료', '신용카드', '2025-01-10 09:15:00',
             165000, 0, 0, 'TID-20250110-001', 'SHINHAN'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             101, 101, '2025-01-15', '2025-01-18', 2, 1, '2025-01-10 09:15:00', 1
         );

-- 2번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             2, 102, 102, '간편결제', '결제완료', '카카오페이', '2025-01-12 14:25:00',
             223000, 0, 0, 'TID-20250112-002', 'KAKAO'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             102, 102, '2025-01-20', '2025-01-23', 3, 1, '2025-01-12 14:25:00', 2
         );

-- 3번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             3, 103, 201, '카드결제', '결제완료', '신용카드', '2025-01-15 10:35:00',
             185000, 5000, 0, 'TID-20250115-003', 'HYUNDAI'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             201, 103, '2025-01-25', '2025-01-28', 2, 1, '2025-01-15 10:35:00', 3
         );

-- 4번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             4, 104, 202, '간편결제', '결제취소', '네이버페이', '2025-01-18 16:45:00',
             130000, 0, 130000, 'TID-20250118-004', 'NAVER'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             202, 104, '2025-01-28', '2025-01-30', 1, 0, '2025-01-18 16:45:00', 4
         );

-- 5번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             5, 105, 301, '카드결제', '결제완료', '신용카드', '2025-01-20 11:30:00',
             255000, 5000, 0, 'TID-20250120-005', 'SAMSUNG'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             301, 105, '2025-02-01', '2025-02-04', 4, 1, '2025-01-20 11:30:00', 5
         );

-- 6번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             6, 106, 302, '간편결제', '결제완료', '토스', '2025-01-22 09:15:00',
             175000, 0, 0, 'TID-20250122-006', 'TOSS'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             302, 106, '2025-02-05', '2025-02-08', 2, 1, '2025-01-22 09:15:00', 6
         );

-- 7번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             7, 101, 401, '카드결제', '환불완료', '신용카드', '2025-01-25 13:40:00',
             195000, 0, 0, 'TID-20250125-007', 'SHINHAN'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             401, 101, '2025-02-10', '2025-02-13', 3, 0, '2025-01-25 13:40:00', 7
         );

-- 8번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             8, 102, 304, '간편결제', '결제완료', '카카오페이', '2025-01-28 16:55:00',
             180000, 0, 0, 'TID-20250128-008', 'KAKAO'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             304, 102, '2025-02-15', '2025-02-18', 2, 1, '2025-01-28 16:55:00', 8
         );

-- 9번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             9, 103, 305, '카드결제', '결제취소', '신용카드', '2025-01-30 11:25:00',
             220000, 0, 220000, 'TID-20250130-009', 'HYUNDAI'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             305, 103, '2025-02-20', '2025-02-24', 3, 0, '2025-01-30 11:25:00', 9
         );

-- 10번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             10, 104, 401, '간편결제', '결제완료', '네이버페이', '2025-02-01 09:15:00',
             175000, 0, 0, 'TID-20250201-010', 'NAVER'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             401, 104, '2025-02-25', '2025-02-28', 2, 1, '2025-02-01 09:15:00', 10
         );

-- 11번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             11, 105, 402, '카드결제', '결제완료', '신용카드', '2025-02-03 15:30:00',
             190000, 0, 0, 'TID-20250203-011', 'SAMSUNG'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             402, 105, '2025-03-01', '2025-03-04', 2, 1, '2025-02-03 15:30:00', 11
         );

-- 12번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             12, 106, 403, '간편결제', '결제완료', '토스', '2025-02-05 12:45:00',
             225000, 0, 0, 'TID-20250205-012', 'TOSS'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             403, 106, '2025-03-05', '2025-03-08', 4, 1, '2025-02-05 12:45:00', 12
         );

-- 13번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             13, 101, 404, '카드결제', '환불완료', '신용카드', '2025-02-08 11:20:00',
             210000, 0, 210000, 'TID-20250208-013', 'SHINHAN'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             404, 101, '2025-03-10', '2025-03-14', 2, 0, '2025-02-08 11:20:00', 13
         );

-- 14번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             14, 102, 501, '간편결제', '결제완료', '카카오페이', '2025-02-10 14:30:00',
             165000, 0, 0, 'TID-20250210-014', 'KAKAO'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             501, 102, '2025-03-15', '2025-03-18', 3, 1, '2025-02-10 14:30:00', 14
         );

-- 15번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             15, 103, 502, '카드결제', '결제완료', '신용카드', '2025-02-12 10:15:00',
             195000, 0, 0, 'TID-20250212-015', 'HYUNDAI'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             502, 103, '2025-03-20', '2025-03-22', 1, 0, '2025-02-12 10:15:00', 15
         );

-- 16번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             16, 104, 503, '간편결제', '결제취소', '네이버페이', '2025-02-15 09:40:00',
             175000, 0, 175000, 'TID-20250215-016', 'NAVER'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             503, 104, '2025-03-25', '2025-03-28', 2, 1, '2025-02-15 09:40:00', 16
         );

-- 17번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             17, 105, 601, '카드결제', '결제완료', '신용카드', '2025-02-17 13:25:00',
             205000, 0, 0, 'TID-20250217-017', 'SAMSUNG'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             601, 105, '2025-04-01', '2025-04-05', 3, 1, '2025-02-17 13:25:00', 17
         );

-- 18번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             18, 106, 602, '간편결제', '결제완료', '토스', '2025-02-20 10:30:00',
             215000, 0, 0, 'TID-20250220-018', 'TOSS'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             602, 106, '2025-04-05', '2025-04-08', 4, 1, '2025-02-20 10:30:00', 18
         );

-- 19번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             19, 101, 205, '카드결제', '결제완료', '신용카드', '2025-02-22 17:25:00',
             212000, 0, 0, 'TID-20250222-019', 'SHINHAN'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             205, 101, '2025-04-10', '2025-04-14', 3, 1, '2025-02-22 17:25:00', 19
         );

-- 20번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             20, 102, 303, '간편결제', '결제완료', '카카오페이', '2025-02-25 11:40:00',
             195000, 0, 0, 'TID-20250225-020', 'KAKAO'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             303, 102, '2025-04-15', '2025-04-19', 4, 1, '2025-02-25 11:40:00', 20
         );
-- 21번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             21, 103, 304, '카드결제', '결제완료', '신용카드', '2025-02-28 10:15:00',
             185000, 0, 0, 'TID-20250228-021', 'HYUNDAI'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             304, 103, '2025-04-20', '2025-04-23', 2, 1, '2025-02-28 10:15:00', 21
         );

-- 22번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             22, 104, 305, '간편결제', '결제완료', '네이버페이', '2025-03-02 14:30:00',
             175000, 0, 0, 'TID-20250302-022', 'NAVER'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             305, 104, '2025-04-25', '2025-04-28', 3, 1, '2025-03-02 14:30:00', 22
         );

-- 23번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             23, 105, 403, '카드결제', '환불완료', '신용카드', '2025-03-05 09:45:00',
             195000, 0, 195000, 'TID-20250305-023', 'SAMSUNG'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             403, 105, '2025-05-01', '2025-05-04', 2, 0, '2025-03-05 09:45:00', 23
         );

-- 24번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             24, 106, 404, '간편결제', '결제완료', '토스', '2025-03-08 11:20:00',
             210000, 0, 0, 'TID-20250308-024', 'TOSS'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             404, 106, '2025-05-05', '2025-05-08', 4, 1, '2025-03-08 11:20:00', 24
         );

-- 25번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             25, 101, 103, '카드결제', '결제완료', '신용카드', '2025-03-10 15:40:00',
             168000, 0, 0, 'TID-20250310-025', 'SHINHAN'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             103, 101, '2025-05-10', '2025-05-14', 2, 1, '2025-03-10 15:40:00', 25
         );

-- 26번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             26, 102, 104, '간편결제', '결제취소', '카카오페이', '2025-03-12 10:15:00',
             205000, 0, 205000, 'TID-20250312-026', 'KAKAO'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             104, 102, '2025-05-15', '2025-05-18', 3, 0, '2025-03-12 10:15:00', 26
         );

-- 27번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             27, 103, 105, '카드결제', '결제완료', '신용카드', '2025-03-15 09:30:00',
             175000, 0, 0, 'TID-20250315-027', 'HYUNDAI'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             105, 103, '2025-05-20', '2025-05-23', 2, 1, '2025-03-15 09:30:00', 27
         );

-- 28번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             28, 104, 201, '간편결제', '결제완료', '네이버페이', '2025-03-18 14:50:00',
             195000, 0, 0, 'TID-20250318-028', 'NAVER'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             201, 104, '2025-05-25', '2025-05-28', 3, 1, '2025-03-18 14:50:00', 28
         );

-- 29번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             29, 105, 202, '카드결제', '결제완료', '신용카드', '2025-03-20 16:35:00',
             215000, 0, 0, 'TID-20250320-029', 'SAMSUNG'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             202, 105, '2025-06-01', '2025-06-04', 2, 1, '2025-03-20 16:35:00', 29
         );

-- 30번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             30, 106, 203, '간편결제', '결제완료', '토스', '2025-03-22 11:05:00',
             185000, 0, 0, 'TID-20250322-030', 'TOSS'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             203, 106, '2025-06-05', '2025-06-08', 3, 1, '2025-03-22 11:05:00', 30
         );

-- 31번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             31, 101, 204, '카드결제', '환불완료', '신용카드', '2025-03-25 14:20:00',
             175000, 0, 175000, 'TID-20250325-031', 'SHINHAN'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             204, 101, '2025-06-10', '2025-06-13', 2, 0, '2025-03-25 14:20:00', 31
         );

-- 32번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             32, 102, 205, '간편결제', '결제완료', '카카오페이', '2025-03-28 09:15:00',
             220000, 0, 0, 'TID-20250328-032', 'KAKAO'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             205, 102, '2025-06-15', '2025-06-19', 4, 1, '2025-03-28 09:15:00', 32
         );

-- 33번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             33, 103, 301, '카드결제', '결제완료', '신용카드', '2025-03-30 15:40:00',
             235000, 0, 0, 'TID-20250330-033', 'HYUNDAI'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             301, 103, '2025-06-20', '2025-06-24', 3, 1, '2025-03-30 15:40:00', 33
         );

-- 34번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             34, 104, 302, '간편결제', '결제취소', '네이버페이', '2025-04-02 10:25:00',
             180000, 0, 180000, 'TID-20250402-034', 'NAVER'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             302, 104, '2025-06-25', '2025-06-28', 2, 0, '2025-04-02 10:25:00', 34
         );

-- 35번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             35, 105, 303, '카드결제', '결제완료', '신용카드', '2025-04-05 13:35:00',
             195000, 0, 0, 'TID-20250405-035', 'SAMSUNG'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             303, 105, '2025-07-01', '2025-07-04', 2, 1, '2025-04-05 13:35:00', 35
         );

-- 36번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             36, 106, 304, '간편결제', '결제완료', '토스', '2025-04-08 16:45:00',
             175000, 0, 0, 'TID-20250408-036', 'TOSS'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             304, 106, '2025-07-05', '2025-07-08', 3, 1, '2025-04-08 16:45:00', 36
         );

-- 37번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             37, 101, 305, '카드결제', '결제완료', '신용카드', '2025-04-10 10:30:00',
             225000, 0, 0, 'TID-20250410-037', 'SHINHAN'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             305, 101, '2025-07-10', '2025-07-14', 2, 1, '2025-04-10 10:30:00', 37
         );

-- 38번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             38, 102, 401, '간편결제', '결제완료', '카카오페이', '2025-04-12 14:40:00',
             198000, 0, 0, 'TID-20250412-038', 'KAKAO'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             401, 102, '2025-07-15', '2025-07-18', 3, 1, '2025-04-12 14:40:00', 38
         );

-- 39번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             39, 103, 402, '카드결제', '환불완료', '신용카드', '2025-04-15 09:15:00',
             155000, 0, 155000, 'TID-20250415-039', 'HYUNDAI'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             402, 103, '2025-07-20', '2025-07-22', 1, 0, '2025-04-15 09:15:00', 39
         );

-- 40번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             40, 104, 403, '간편결제', '결제완료', '네이버페이', '2025-04-18 11:30:00',
             210000, 0, 0, 'TID-20250418-040', 'NAVER'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             403, 104, '2025-07-25', '2025-07-29', 4, 1, '2025-04-18 11:30:00', 40
         );

-- 41번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             41, 105, 404, '카드결제', '결제완료', '신용카드', '2025-04-20 15:25:00',
             190000, 0, 0, 'TID-20250420-041', 'SAMSUNG'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             404, 105, '2025-08-01', '2025-08-04', 2, 1, '2025-04-20 15:25:00', 41
         );

-- 42번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             42, 106, 501, '간편결제', '결제취소', '토스', '2025-04-22 13:45:00',
             230000, 0, 230000, 'TID-20250422-042', 'TOSS'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             501, 106, '2025-08-05', '2025-08-09', 4, 0, '2025-04-22 13:45:00', 42
         );

-- 43번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             43, 101, 502, '카드결제', '결제완료', '신용카드', '2025-04-25 10:15:00',
             185000, 0, 0, 'TID-20250425-043', 'SHINHAN'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             502, 101, '2025-08-10', '2025-08-13', 2, 1, '2025-04-25 10:15:00', 43
         );

-- 44번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             44, 102, 503, '간편결제', '결제완료', '카카오페이', '2025-04-28 14:30:00',
             195000, 5000, 0, 'TID-20250428-044', 'KAKAO'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             503, 102, '2025-08-15', '2025-08-18', 3, 1, '2025-04-28 14:30:00', 44
         );

-- 45번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             45, 103, 601, '카드결제', '결제완료', '신용카드', '2025-04-30 11:20:00',
             205000, 5000, 0, 'TID-20250430-045', 'HYUNDAI'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             601, 103, '2025-08-20', '2025-08-24', 4, 1, '2025-04-30 11:20:00', 45
         );

-- 46번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             46, 104, 602, '간편결제', '결제완료', '네이버페이', '2025-05-02 16:40:00',
             175000, 0, 0, 'TID-20250502-046', 'NAVER'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             602, 104, '2025-08-25', '2025-08-28', 2, 1, '2025-05-02 16:40:00', 46
         );

-- 47번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             47, 105, 101, '카드결제', '환불완료', '신용카드', '2025-05-05 10:25:00',
             165000, 0, 165000, 'TID-20250505-047', 'SAMSUNG'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             101, 105, '2025-09-01', '2025-09-04', 2, 0, '2025-05-05 10:25:00', 47
         );

-- 48번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             48, 106, 102, '간편결제', '결제완료', '토스', '2025-05-08 13:15:00',
             215000, 5000, 0, 'TID-20250508-048', 'TOSS'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             102, 106, '2025-09-05', '2025-09-09', 3, 1, '2025-05-08 13:15:00', 48
         );

-- 49번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             49, 101, 103, '카드결제', '결제완료', '신용카드', '2025-05-10 15:50:00',
             185000, 0, 0, 'TID-20250510-049', 'SHINHAN'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             103, 101, '2025-09-10', '2025-09-13', 2, 1, '2025-05-10 15:50:00', 49
         );

-- 50번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             50, 102, 104, '간편결제', '결제완료', '카카오페이', '2025-05-12 11:30:00',
             195000, 0, 0, 'TID-20250512-050', 'KAKAO'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             104, 102, '2025-09-15', '2025-09-19', 3, 1, '2025-05-12 11:30:00', 50
         );

-- 51번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             51, 101, 105, '카드결제', '결제완료', '신용카드', '2025-03-01 09:15:00',
             178000, 0, 0, 'TID-20250301-051', 'SHINHAN'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             105, 101, '2025-03-20', '2025-03-23', 2, 1, '2025-03-01 09:15:00', 51
         );

-- 52번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             52, 101, 201, '간편결제', '결제완료', '카카오페이', '2025-03-03 14:25:00',
             195000, 5000, 0, 'TID-20250303-052', 'KAKAO'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             201, 101, '2025-03-22', '2025-03-25', 3, 1, '2025-03-03 14:25:00', 52
         );

-- 53번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             53, 101, 302, '카드결제', '결제완료', '신용카드', '2025-03-05 11:30:00',
             165000, 0, 0, 'TID-20250305-053', 'SHINHAN'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             302, 101, '2025-03-19', '2025-03-21', 2, 1, '2025-03-05 11:30:00', 53
         );

-- 54번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             54, 101, 403, '간편결제', '결제취소', '네이버페이', '2025-03-07 16:45:00',
             205000, 0, 205000, 'TID-20250307-054', 'NAVER'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             403, 101, '2025-03-25', '2025-03-29', 4, 0, '2025-03-07 16:45:00', 54
         );

-- 55번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             55, 101, 501, '카드결제', '결제완료', '신용카드', '2025-03-09 10:20:00',
             185000, 0, 0, 'TID-20250309-055', 'SHINHAN'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             501, 101, '2025-03-18', '2025-03-21', 2, 1, '2025-03-09 10:20:00', 55
         );

-- 56번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             56, 101, 601, '간편결제', '결제완료', '토스', '2025-03-11 13:40:00',
             220000, 5000, 0, 'TID-20250311-056', 'TOSS'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             601, 101, '2025-03-25', '2025-03-29', 3, 1, '2025-03-11 13:40:00', 56
         );

-- 57번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             57, 101, 102, '카드결제', '환불완료', '신용카드', '2025-03-13 09:30:00',
             175000, 0, 175000, 'TID-20250313-057', 'SHINHAN'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             102, 101, '2025-03-21', '2025-03-24', 2, 0, '2025-03-13 09:30:00', 57
         );

-- 58번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             58, 101, 203, '간편결제', '결제완료', '카카오페이', '2025-03-15 15:50:00',
             190000, 0, 0, 'TID-20250315-058', 'KAKAO'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             203, 101, '2025-03-23', '2025-03-26', 3, 1, '2025-03-15 15:50:00', 58
         );

-- 59번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             59, 101, 304, '카드결제', '결제완료', '신용카드', '2025-03-17 12:15:00',
             180000, 0, 0, 'TID-20250317-059', 'SHINHAN'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             304, 101, '2025-03-27', '2025-03-30', 2, 1, '2025-03-17 12:15:00', 59
         );

-- 60번 쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             60, 101, 402, '간편결제', '결제완료', '네이버페이', '2025-03-18 17:20:00',
             215000, 0, 0, 'TID-20250318-060', 'NAVER'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             402, 101, '2025-03-29', '2025-04-02', 4, 1, '2025-03-18 17:20:00', 60
         );

-- 61쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             61, 101, 501, '간편결제', '결제완료', '네이버페이', '2025-03-18 17:20:00',
             250000, 0, 0, 'TID-20250318-060', 'NAVER'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             501, 101, '2025-03-23', '2025-03-25', 4, 1, '2025-03-18 17:20:00', 61
         );

-- 62번쌍
INSERT INTO tbl_pay (
    pay_id, member_code, acm_id, pay_method, pay_status, pay_type, pay_date,
    pay_price, discount, pay_ref, transaction_id, pay_provider
) VALUES (
             62, 102, 501, '간편결제', '결제완료', '네이버페이', '2025-03-18 17:20:00',
             250000, 0, 0, 'TID-20250318-060', 'NAVER'
         );

INSERT INTO tbl_reservations (
    acm_id, member_code, check_in, check_out, guest_count, is_resv, created_at, pay_id
) VALUES (
             501, 102, '2025-03-29', '2025-04-02', 4, 1, '2025-03-18 17:20:00', 62
         );



-- 게시판 관련 dml

-- 공지사항 (board_type = 1) 20개
INSERT INTO `tbl_board_posts` (`member_code`, `board_type`, `title`, `content`, `created_at`, `updated_at`) VALUES
(1, 1, '어디고 서비스 개편 안내', '안녕하세요, 어디고 회원 여러분! 더 나은 서비스 제공을 위해 2025년 4월 1일부터 웹사이트와 앱이 전면 개편됩니다. 새로운 디자인과 함께 예약 프로세스가 간소화되고, 실시간 리뷰 시스템이 도입됩니다. 이용에 참고 부탁드립니다.', NOW(), NULL),
(1, 1, '여름 성수기 예약 오픈 안내', '2025년 여름 성수기(7월 1일부터 8월 31일까지) 예약이 5월 1일부터 시작됩니다. 인기 숙소는 조기 마감될 수 있으니 서두르세요! 얼리버드 예약 시 최대 15% 할인 혜택을 놓치지 마세요.', NOW(), NULL),
(1, 1, '결제 시스템 점검 안내', '시스템 정기 점검으로 인해 2025년 3월 15일 오전 2시부터 6시까지 결제 서비스 이용이 제한됩니다. 해당 시간에는 예약은 가능하나 결제 진행은 어려우니 양해 부탁드립니다.', NOW(), NULL),
(1, 1, '신규 제휴 숙소 안내', '어디고에 새롭게 100여 개의 프리미엄 숙소가 추가되었습니다. 제주도, 강원도 지역의 럭셔리 풀빌라부터 서울의 부티크 호텔까지 다양한 숙소를 만나보세요. 신규 숙소 첫 예약 시 10% 할인 쿠폰이 자동 지급됩니다.', NOW(), NULL),
(1, 1, '앱 전용 특가 상품 안내', '어디고 앱에서만 만나볼 수 있는 특가 상품이 매주 업데이트됩니다. 최대 50% 할인된 가격으로 프리미엄 숙소를 경험해보세요. 앱 푸시 알림 설정 시 특가 오픈 소식을 가장 먼저 받아보실 수 있습니다.', NOW(), NULL),
(1, 1, '리뷰 작성 이벤트 안내', '2025년 4월 한 달간 숙소 이용 후 리뷰를 작성해주시면 추첨을 통해 100명에게 어디고 포인트 10만 점을 드립니다. 사진과 함께 상세한 리뷰를 남겨주시면 당첨 확률이 2배 높아집니다!', NOW(), NULL),
(1, 1, '어디고 멤버십 프로그램 개편', '어디고 멤버십 프로그램이 2025년 5월 1일부터 새롭게 개편됩니다. 기존 3단계에서 5단계로 확대되며, 등급별 혜택이 더욱 강화됩니다. 또한 포인트 적립률이 최대 5%로 상향되니 많은 이용 바랍니다.', NOW(), NULL),
(1, 1, '숙소 검색 필터 기능 강화', '고객님의 더 나은 검색 경험을 위해 숙소 검색 필터 기능이 강화되었습니다. 이제 주변 관광지, 부대시설, 객실 내 시설 등 더 세분화된 조건으로 원하는 숙소를 찾을 수 있습니다.', NOW(), NULL),
(1, 1, '연휴 기간 고객센터 운영 안내', '추석 연휴 기간(2025년 9월 10일~9월 12일) 동안 고객센터 운영 시간이 오전 10시부터 오후 4시까지로 단축됩니다. 긴급 문의는 앱 내 1:1 채팅으로 접수해 주시면 순차적으로 답변 드리겠습니다.', NOW(), NULL),
(1, 1, '개인정보 처리방침 개정 안내', '2025년 4월 1일부터 개인정보 처리방침이 개정됩니다. 주요 변경 사항으로는 개인정보 보관 기간 명확화, 제3자 제공 항목 세분화 등이 있습니다. 자세한 내용은 홈페이지 하단의 개인정보 처리방침에서 확인하실 수 있습니다.', NOW(), NULL),
(1, 1, '여름 휴가 추천 지역 특집', '2025년 여름 휴가 시즌을 맞아 어디고에서 엄선한 숨은 여행지를 소개합니다. 붐비는 관광지 대신 한적한 해변과 산속 리조트, 이색 테마 숙소까지 다양한 추천 숙소를 어디고 메인 페이지에서 만나보세요.', NOW(), NULL),
(1, 1, '모바일 청구서 서비스 오픈', '이제 어디고에서 예약한 모든 숙소의 영수증과 청구서를 모바일로 간편하게 받아보실 수 있습니다. 마이페이지 > 예약내역에서 언제든지 확인 및 다운로드 가능합니다.', NOW(), NULL),
(1, 1, '제휴 렌터카 서비스 안내', '어디고에서 숙소 예약 시 제휴 렌터카를 함께 예약하면 최대 30% 할인 혜택을 드립니다. 숙소 예약 완료 페이지에서 렌터카 옵션을 확인해보세요.', NOW(), NULL),
(1, 1, '어디고 친구 추천 프로그램', '친구에게 어디고를 추천하고 특별한 혜택을 받으세요! 추천인과 신규 가입자 모두에게 2만원 할인 쿠폰을 드립니다. 마이페이지 > 친구 초대하기 메뉴에서 초대 링크를 공유해보세요.', NOW(), NULL),
(1, 1, '숙소 예약 취소 정책 변경 안내', '2025년 5월 1일부터 숙소 예약 취소 정책이 일부 변경됩니다. 체크인 7일 전까지는 100% 환불, 3~6일 전은 70% 환불, 2일 전부터는 환불 불가로 조정됩니다. 단, 숙소별로 취소 정책이 다를 수 있으니 예약 전 반드시 확인해주세요.', NOW(), NULL),
(1, 1, '어디고 비즈니스 서비스 출시', '출장이 잦은 비즈니스 고객을 위한 어디고 비즈니스 서비스가 출시되었습니다. 법인 회원 가입 시 전용 대시보드 제공, 세금계산서 자동 발행, 출장 보고서 생성 등 편리한 기능을 이용해보세요.', NOW(), NULL),
(1, 1, '여름 성수기 인기 숙소 안내', '2025년 여름 성수기 인기 예상 숙소 리스트를 공개합니다. 작년 예약률 데이터를 기반으로 선정된 숙소들로, 조기 예약을 추천드립니다. 인기 숙소 목록은 메인 페이지 배너에서 확인하실 수 있습니다.', NOW(), NULL),
(1, 1, '어디고 포인트 소멸 안내', '2023년 상반기에 적립된 어디고 포인트가 2025년 6월 30일에 소멸될 예정입니다. 소멸 예정 포인트는 마이페이지에서 확인 가능하며, 소멸 전 사용하시어 혜택을 놓치지 마세요.', NOW(), NULL),
(1, 1, '숙소 안전 인증제 도입', '고객님의 안전한 숙박을 위해 어디고 안전 인증제를 도입합니다. 소방 안전, 위생 관리, 보안 시스템 등 엄격한 기준을 통과한 숙소에 안전 인증 마크가 부여됩니다. 인증 숙소는 검색 필터에서 별도로 확인하실 수 있습니다.', NOW(), NULL),
(1, 1, '지역 특산품 증정 이벤트', '2025년 5월 한 달간 지방 소재 숙소 예약 시 해당 지역 특산품을 증정합니다. 제주 감귤, 경북 사과, 전남 녹차 등 다양한 특산품으로 여행의 즐거움을 더하세요. 이벤트 참여 숙소는 상세 페이지에 별도 표기됩니다.', NOW(), NULL),

-- FAQ (board_type = 2) 20개
(1, 2, '예약은 어떻게 하나요?', '어디고 웹사이트나 앱에서 원하는 지역, 날짜, 인원수를 입력하여 숙소를 검색할 수 있습니다. 마음에 드는 숙소를 선택한 후 객실 타입과 옵션을 선택하고 결제를 진행하면 예약이 완료됩니다. 예약 확인 메일과 SMS가 자동으로 발송되며, 마이페이지에서도 예약 내역을 확인할 수 있습니다.', NOW(), NULL),
(1, 2, '예약 취소는 어떻게 하나요?', '마이페이지 > 예약내역에서 취소하려는 예약을 선택한 후 취소 버튼을 클릭하면 됩니다. 취소 수수료는 숙소별 취소 정책에 따라 다르며, 예약 시 안내된 취소 정책을 참고해 주세요. 취소 완료 후에는 취소 확인 메일이 발송됩니다.', NOW(), NULL),
(1, 2, '결제 방법은 어떤 것이 있나요?', '신용카드, 체크카드, 카카오페이, 네이버페이, 토스, 휴대폰 소액결제, 실시간 계좌이체 등 다양한 결제 방법을 제공합니다. 일부 숙소는 현장 결제도 가능하며, 이 경우 예약 시 별도 표기됩니다.', NOW(), NULL),
(1, 2, '예약 확인서는 어떻게 받을 수 있나요?', '예약 완료 후 등록된 이메일로 자동 발송되며, 마이페이지 > 예약내역에서도 언제든지 확인 및 출력이 가능합니다. 모바일 앱에서는 예약 상세 페이지에서 예약 확인서를 확인할 수 있습니다.', NOW(), NULL),
(1, 2, '어디고 포인트는 어떻게 적립되나요?', '숙소 이용 금액의 1~3%(회원 등급에 따라 상이)가 자동으로 포인트로 적립됩니다. 추가로 리뷰 작성 시 500포인트, 친구 추천 시 2,000포인트 등 다양한 방법으로 포인트를 모을 수 있습니다. 적립된 포인트는 다음 예약 시 1포인트 = 1원으로 사용 가능합니다.', NOW(), NULL),
(1, 2, '예약 변경이 가능한가요?', '대부분의 숙소는 체크인 3일 전까지 날짜 변경이 가능합니다. 마이페이지 > 예약내역에서 변경하려는 예약을 선택한 후 변경 버튼을 클릭하세요. 단, 숙소별로 변경 정책이 다를 수 있으며, 객실 타입 변경은 취소 후 재예약해야 할 수 있습니다.', NOW(), NULL),
(1, 2, '미성년자도 예약이 가능한가요?', '만 18세 이상부터 예약이 가능합니다. 미성년자의 경우 보호자 동반 또는 동의가 필요하며, 일부 숙소는 체크인 시 신분증을 확인할 수 있습니다. 자세한 사항은 각 숙소의 이용 규정을 확인해 주세요.', NOW(), NULL),
(1, 2, '예약 시 필요한 정보는 무엇인가요?', '예약자 이름, 연락처, 이메일 주소가 기본적으로 필요합니다. 또한 투숙객 정보(인원수, 아동 포함 여부)와 결제 정보가 필요합니다. 일부 숙소는 차량 정보나 도착 예정 시간 등 추가 정보를 요청할 수 있습니다.', NOW(), NULL),
(1, 2, '영수증이나 세금계산서 발급이 가능한가요?', '개인 영수증은 마이페이지 > 예약내역에서 직접 출력 가능합니다. 세금계산서가 필요한 경우, 예약 전 요청사항에 기재하거나 예약 후 고객센터로 사업자등록증을 첨부하여 요청해 주세요. 체크아웃 후 7일 이내에 요청하셔야 발급 가능합니다.', NOW(), NULL),
(1, 2, '예약 후 객실 타입 변경이 가능한가요?', '대부분의 경우 객실 타입 변경은 기존 예약 취소 후 재예약해야 합니다. 단, 동일 숙소 내에서 상위 객실로의 업그레이드는 가능한 경우가 있으니 고객센터로 문의해 주세요. 취소 수수료가 발생할 수 있으니 유의하시기 바랍니다.', NOW(), NULL),
(1, 2, '체크인과 체크아웃 시간은 어떻게 되나요?', '일반적으로 체크인은 오후 2시부터, 체크아웃은 오전 11시까지입니다. 단, 숙소별로 시간이 다를 수 있으니 예약 확인서나 숙소 상세 페이지에서 정확한 시간을 확인해 주세요. 얼리 체크인이나 레이트 체크아웃은 숙소에 직접 문의하시기 바랍니다.', NOW(), NULL),
(1, 2, '예약 시 요청사항을 남길 수 있나요?', '네, 예약 과정 중 요청사항 입력란에 특별 요청사항을 남길 수 있습니다. 예를 들어 늦은 체크인, 층수 지정, 침구 추가 등의 요청이 가능합니다. 단, 모든 요청은 숙소의 상황에 따라 수락 여부가 결정되며 추가 비용이 발생할 수 있습니다.', NOW(), NULL),
(1, 2, '예약 확정은 언제 되나요?', '결제 완료 즉시 예약이 확정되며, 예약 확인 메일과 SMS가 발송됩니다. 단, 일부 숙소는 예약 요청 후 숙소의 확인 과정을 거쳐 최종 확정되는 경우가 있으며, 이 경우 별도로 안내해 드립니다.', NOW(), NULL),
(1, 2, '여러 객실을 한 번에 예약할 수 있나요?', '네, 가능합니다. 객실 선택 단계에서 원하는 객실 타입별로 수량을 조절하여 여러 객실을 한 번에 예약할 수 있습니다. 단, 일부 숙소는 한 번에 예약 가능한 객실 수에 제한이 있을 수 있습니다.', NOW(), NULL),
(1, 2, '반려동물 동반 숙소는 어떻게 찾나요?', '숙소 검색 시 필터 옵션에서 "반려동물 동반 가능" 항목을 선택하면 관련 숙소만 표시됩니다. 반려동물 동반 시 추가 요금이 발생할 수 있으며, 반려동물의 크기나 종류에 제한이 있을 수 있으니 예약 전 반드시 숙소 규정을 확인해 주세요.', NOW(), NULL),
(1, 2, '예약 후 인원 변경이 가능한가요?', '체크인 전이라면 마이페이지 > 예약내역에서 인원 수 변경이 가능합니다. 인원이 증가하는 경우 추가 요금이 발생할 수 있으며, 최대 수용 인원을 초과할 수 없습니다. 인원 감소의 경우 환불은 불가능한 경우가 많으니 참고해 주세요.', NOW(), NULL),
(1, 2, '어디고 앱에서만 제공되는 혜택이 있나요?', '네, 앱 전용 특가, 앱 전용 쿠폰, 앱 예약 시 추가 포인트 적립 등 다양한 혜택이 있습니다. 또한 앱에서는 푸시 알림을 통해 특가 정보나 예약 관련 알림을 실시간으로 받아볼 수 있습니다.', NOW(), NULL),
(1, 2, '해외 숙소도 예약 가능한가요?', '현재 어디고는 국내 숙소 예약 서비스만 제공하고 있습니다. 향후 해외 숙소 서비스 오픈 시 공지사항을 통해 안내해 드리겠습니다.', NOW(), NULL),
(1, 2, '예약 내역을 인쇄하려면 어떻게 해야 하나요?', '마이페이지 > 예약내역에서 해당 예약을 선택한 후 "예약 확인서 출력" 버튼을 클릭하면 인쇄 가능한 형태의 확인서가 생성됩니다. 모바일에서는 PDF로 저장한 후 인쇄하실 수 있습니다.', NOW(), NULL),
(1, 2, '어디고 회원 등급은 어떻게 올라가나요?', '연간 예약 금액에 따라 회원 등급이 결정됩니다. 일반(50만원 미만), 실버(50만원 이상), 골드(200만원 이상), 플래티넘(500만원 이상), VIP(1,000만원 이상)의 5단계로 구성되며, 등급에 따라 포인트 적립률과 전용 혜택이 달라집니다.', NOW(), NULL),

-- 1대1 질문 (board_type = 3) 30개
(101, 3, '예약 변경 문의', '안녕하세요. 제주 오션뷰 리조트를 5월 15일부터 17일까지 예약했는데, 일정이 변경되어 5월 20일부터 22일로 바꾸고 싶습니다. 가능할까요? 예약번호는 ABC12345입니다.', NOW(), NULL),
(101, 3, '결제 오류 발생', '숙소 예약 중 결제 과정에서 오류가 발생했습니다. 카드 결제를 시도했으나 "결제 처리 중 오류가 발생했습니다"라는 메시지가 뜹니다. 하지만 문자로는 결제 완료 메시지가 왔습니다. 예약이 된 건지 확인 부탁드립니다.', NOW(), NULL),
(101, 3, '객실 뷰 관련 문의', '강릉 씨사이드 호텔 오션뷰 객실을 예약했는데, 실제로 바다가 잘 보이는지 궁금합니다. 또한 객실 층수 지정이 가능한가요? 가능하면 고층으로 배정 요청 드립니다. 예약번호는 DEF67890입니다.', NOW(), NULL),
(101, 3, '유아 동반 시설 문의', '다음 주에 경주 한옥 리조트를 예약했는데, 22개월 아기와 함께 갑니다. 유아용 침대나 식기가 구비되어 있나요? 또한 아기와 함께 이용할만한 시설이 있는지 알려주세요. 예약번호는 GHI24680입니다.', NOW(), NULL),
(101, 3, '포인트 소멸 관련 문의', '제 계정에 적립된 포인트가 얼마인지, 그리고 언제 소멸되는지 알고 싶습니다. 지난번 예약 시 적립된 포인트를 사용하려고 하는데 확인이 안 됩니다.', NOW(), NULL),
(101, 3, '예약 취소 수수료 문의', '부산 해운대 호텔 예약을 취소하려고 합니다. 체크인 5일 전인데 취소 수수료가 얼마나 발생하는지 알려주세요. 예약번호는 JKL13579입니다.', NOW(), NULL),
(101, 3, '숙소 주변 교통편 문의', '서울 북촌 한옥스테이를 예약했는데, 인천공항에서 숙소까지 가는 가장 편리한 교통편을 알려주세요. 또한 주변 관광지까지의 이동 방법도 궁금합니다. 예약번호는 MNO97531입니다.', NOW(), NULL),
(102, 3, '조식 추가 가능 여부', '이미 예약한 숙소에 조식을 추가하고 싶습니다. 가능한가요? 가능하다면 추가 비용은 얼마인지, 어떻게 신청해야 하는지 알려주세요. 예약번호는 PQR86420입니다.', NOW(), NULL),
(102, 3, '리뷰 작성 포인트 미적립', '지난주 이용한 숙소에 리뷰를 작성했는데 포인트가 적립되지 않았습니다. 확인 부탁드립니다. 예약번호는 STU75319입니다.', NOW(), NULL),
(102, 3, '숙소 시설 정보 문의', '예약한 펜션에 바베큐 시설이 있다고 했는데, 이용 가능 시간과 추가 비용이 있는지 궁금합니다. 또한 숯과 그릴은 제공되나요? 예약번호는 VWX42680입니다.', NOW(), NULL),
(102, 3, '계정 정보 변경 방법', '가입 시 등록한 휴대폰 번호를 변경하고 싶은데 어떻게 해야 하나요? 또한 이메일 주소도 함께 변경하고 싶습니다.', NOW(), NULL),
(102, 3, '쿠폰 사용 오류', '10% 할인 쿠폰을 적용하려고 하는데 "사용 조건에 맞지 않습니다"라는 메시지가 뜹니다. 쿠폰 사용 조건을 확인해주시고, 사용 가능하도록 도와주세요. 쿠폰 번호는 SUMMER2025입니다.', NOW(), NULL),
(102, 3, '예약 확인 메일 재발송 요청', '어제 예약을 완료했는데 예약 확인 메일을 받지 못했습니다. 스팸함도 확인해봤지만 없습니다. 메일 재발송 부탁드립니다. 예약번호는 YZA13579입니다.', NOW(), NULL),
(102, 3, '숙소 전화번호 문의', '내일 체크인 예정인데 늦게 도착할 것 같아서 숙소에 직접 연락하고 싶습니다. 숙소 전화번호를 알려주세요. 예약번호는 BCD24680입니다.', NOW(), NULL),
(102, 3, '결제 영수증 발급 요청', '지난달 이용한 숙소의 결제 영수증이 필요합니다. 마이페이지에서 확인이 안 되어 요청드립니다. 예약번호는 EFG97531입니다.', NOW(), NULL),
(102, 3, '앱 오류 신고', '어디고 앱에서 숙소 검색 시 필터 적용 후 결과가 나오지 않는 오류가 발생합니다. 어제부터 계속 같은 문제가 발생하고 있습니다. iOS 최신 버전을 사용 중입니다.', NOW(), NULL),
(103, 3, '특정 숙소 검색 안됨', '전에 북마크해둔 강원도 양양의 "파인 비치 풀빌라"를 검색해도 결과에 나오지 않습니다. 해당 숙소가 더 이상 어디고와 제휴하지 않는 건가요? 아니면 검색 오류인가요?', NOW(), NULL),
(105, 3, '예약 내역 삭제 문의', '취소된 예약이 마이페이지에 계속 표시되어 불편합니다. 취소된 예약 내역을 삭제하는 방법이 있나요?', NOW(), NULL),
(105, 3, '회원 탈퇴 방법 문의', '어디고 회원 탈퇴를 하고 싶은데 방법을 알려주세요. 탈퇴 시 적립된 포인트는 어떻게 되나요?', NOW(), NULL),
(105, 3, '결제 방법 변경 가능 여부', '예약 시 신용카드로 결제했는데, 체크카드로 변경하고 싶습니다. 가능한가요? 예약번호는 HIJ86420입니다.', NOW(), NULL),
(105, 3, '숙소 위치 정확성 문의', '예약한 펜션의 지도 위치가 정확한지 확인하고 싶습니다. 네비게이션 주소를 정확히 알려주세요. 예약번호는 KLM75319입니다.', NOW(), NULL),
(106, 3, '객실 내 시설 문의', '예약한 호텔 객실에 전자레인지와 미니 냉장고가 있나요? 간단한 조리가 가능한지 알고 싶습니다. 예약번호는 NOP42680입니다.', NOW(), NULL),
(106, 3, '숙소 예약 증빙 서류 요청', '회사 출장으로 이용한 숙소의 숙박 증명서가 필요합니다. 발급 방법을 알려주세요. 예약번호는 QRS13579입니다.', NOW(), NULL),
(106, 3, '포인트 합산 문의', '두 개의 계정을 사용 중인데, 한 계정으로 포인트를 합산할 수 있나요? 가능하다면 방법을 알려주세요.', NOW(), NULL),
(106, 3, '숙소 평점 관련 문의', '제가 예약한 숙소의 평점이 예약 당시보다 많이 낮아진 것 같습니다. 혹시 최근에 문제가 있었던 건가요? 예약번호는 TUV24680입니다.', NOW(), NULL),
(106, 3, '예약자명 변경 가능 여부', '친구 대신 제 계정으로 예약했는데, 예약자명을 친구 이름으로 변경할 수 있나요? 예약번호는 WXY97531입니다.', NOW(), NULL),
(106, 3, '숙소 내 와이파이 문의', '예약한 숙소의 와이파이 속도가 궁금합니다. 재택근무를 병행할 예정이라 화상회의가 가능한 수준인지 알고 싶습니다. 예약번호는 ZAB86420입니다.', NOW(), NULL),
(106, 3, '단체 예약 문의', '회사 워크숍으로 20명이 이용할 숙소를 알아보고 있습니다. 단체 예약 시 할인이나 특별 혜택이 있나요? 또한 세미나실이 있는 숙소를 추천해주세요.', NOW(), NULL),
(106, 3, '숙소 내 반려동물 동반 문의', '예약한 숙소가 반려동물 동반 가능으로 표시되어 있는데, 특별한 제한사항(크기, 종류 등)이 있는지 알고 싶습니다. 5kg 포메라니안을 데려갈 예정입니다. 예약번호는 CDE75319입니다.', NOW(), NULL),
(106, 3, '예약 사이트와 숙소 정보 불일치', '어디고에서 본 객실 사진과 실제 방문했을 때 객실이 많이 달랐습니다. 특히 욕실 크기가 사진보다 훨씬 작았습니다. 이런 경우 어떻게 해야 하나요?', NOW(), NULL);

-- 댓글 (board_type = 3에 대한 답변) 10개

INSERT INTO `tbl_board_comments` (`post_id`, `content`, `created_at`) VALUES
(31, '안녕하세요, 어디고입니다. 문의 주셔서 감사합니다. 예약 변경 가능 여부를 확인해보았습니다. 다행히 5월 20일부터 22일까지 동일한 객실 타입이 예약 가능합니다. 변경 시 요금 차이는 없으며, 변경을 원하시면 고객센터(1588-1234)로 연락 부탁드립니다. 감사합니다.', NOW()),
(32, '안녕하세요, 어디고입니다. 불편을 드려 죄송합니다. 확인 결과 결제는 정상적으로 완료되었으며, 예약도 확정되었습니다. 결제 내역은 마이페이지에서 확인 가능합니다. 시스템 오류로 인한 불편 사항은 개선하도록 하겠습니다. 추가 문의사항 있으시면 언제든지 연락 주세요.', NOW()),
(35, '안녕하세요, 어디고입니다. 현재 회원님의 계정에는 15,000포인트가 적립되어 있습니다. 이 중 10,000포인트는 2023년 6월에 적립되어 2025년 6월 30일에 소멸 예정입니다. 나머지 5,000포인트는 2024년 적립되어 2026년까지 사용 가능합니다. 포인트는 예약 시 결제 페이지에서 사용 가능합니다. 감사합니다.', NOW()),
(36, '안녕하세요, 어디고입니다. 부산 해운대 호텔의 취소 정책을 확인해보았습니다. 체크인 5일 전 취소의 경우, 예약 금액의 30%가 취소 수수료로 발생합니다. 귀하의 예약 금액은 300,000원이므로, 90,000원의 취소 수수료가 발생하며 210,000원이 환불됩니다. 취소를 원하시면 마이페이지에서 직접 취소하시거나 고객센터로 연락 주세요.', NOW()),
(39, '안녕하세요, 어디고입니다. 리뷰 작성 포인트 미적립 건 확인해보았습니다. 시스템 오류로 인해 포인트가 적립되지 않았네요. 방금 500포인트를 수동으로 적립해드렸습니다. 마이페이지에서 확인 가능합니다. 불편을 드려 죄송합니다. 앞으로 더 나은 서비스로 보답하겠습니다.', NOW()),
(42, '안녕하세요, 어디고입니다. SUMMER2025 쿠폰 사용 조건을 확인해보았습니다. 해당 쿠폰은 15만원 이상 결제 시 사용 가능하며, 주말(금,토) 숙박에는 적용되지 않습니다. 또한 특가 상품에는 중복 할인이 불가합니다. 현재 선택하신 상품이 이 조건에 해당되는지 확인해보시고, 추가 문의사항은 언제든지 알려주세요.', NOW()),
(46, '안녕하세요, 어디고입니다. 앱 오류 신고 감사합니다. 현재 iOS 앱에서 필터 관련 버그가 확인되어 수정 중입니다. 임시 해결책으로 앱을 최신 버전으로 업데이트하거나, 캐시를 삭제 후 재시도해보세요. 웹사이트에서는 정상 작동하니 급한 예약은 웹으로 진행해주시기 바랍니다. 불편을 드려 죄송합니다.', NOW()),
(49, '안녕하세요, 어디고입니다. 회원 탈퇴는 마이페이지 > 설정 > 회원 탈퇴 메뉴에서 가능합니다. 탈퇴 시 적립된 포인트는 모두 소멸되며, 진행 중인 예약이 있는 경우 탈퇴가 제한될 수 있습니다. 탈퇴 전 사용 가능한 포인트를 모두 사용하시고, 개인정보는 관련 법령에 따라 일정 기간 보관 후 파기됩니다.', NOW()),
(53, '안녕하세요, 어디고입니다. 숙박 증명서는 마이페이지 > 예약내역 > 해당 예약 상세 페이지에서 "숙박 증명서 발급" 버튼을 통해 직접 발급 가능합니다. 특별한 양식이 필요하시면 고객센터로 연락 주시기 바랍니다. 출장 보고용으로 적합한 형태로 제공해 드리겠습니다.', NOW()),
(58, '안녕하세요, 어디고입니다. 20명 규모의 단체 예약은 일반 예약이 아닌 단체 예약 서비스를 이용하시는 것이 좋습니다. 10명 이상 단체 예약 시 최대 15% 할인 혜택을 제공하며, 세미나실 무료 대여 등 추가 혜택도 가능합니다. 강원도 홍천의 "포레스트 리조트"와 경기도 양평의 "그린 밸리 호텔"을 추천드립니다. 자세한 상담은 단체 예약 전용 번호(02-123-4567)로 연락 주시기 바랍니다.', NOW()),
(59, '안녕하세요, 어디고입니다. 해당 숙소는 반려동물 동반 가능하며, 10kg 이하의 소형견만 입실 가능합니다. 포메라니안은 크기가 적합하여 동반 가능합니다. 다만, 예약 시 반려동물 동반 여부를 미리 알려주셔야 하며, 1마리당 30,000원의 추가 요금이 발생합니다. 또한 반려동물 전용 시트와 배변패드는 직접 준비하셔야 합니다. 추가 문의사항 있으시면 언제든지 연락 주세요.', NOW());


# 리뷰 데이터 / 리뷰 이미지 추가 예정
INSERT INTO `tbl_reviews` (member_code, acm_id, resv_id, content, written_at, re_photo1, re_photo2, re_photo3) VALUES
(101, 101, 1, '이 호텔은 정말 최고였습니다! 객실은 넓고 깨끗했으며, 침대는 아주 편안했습니다. 특히 창문에서 보이는 도시 전경이 환상적이었어요. 직원들도 매우 친절하고 전문적이었습니다. 다음에 서울에 가면 꼭 다시 방문할 것입니다.', '2025-01-20 15:30:00', '/image/review/review1.jpg.jpeg', '/image/review/review2.jpg.jpg', '/image/review/review3.jpg.jpeg'),
(102, 102, 2, '서비스와 시설 모두 기대 이상이었습니다. 조식도 종류가 다양하고 맛있었어요. 위치도 쇼핑과 관광하기 좋은 곳에 있어 편리했습니다. 다만 욕실 샤워 수압이 조금 약한 것이 아쉬웠어요. 그래도 전반적으로 만족스러운 숙박이었습니다.', '2025-01-25 16:45:00', '/image/review/review4.jpg.jpg', '/image/review/review5.jpg.jpeg', NULL),
(103, 201, 3, '충청 지역 여행에 딱 맞는 숙소였습니다. 특히 수영장 시설이 정말 좋았고, 아이들이 너무 좋아했어요. 주변에 자연환경도 아름다워서 산책하기 좋았습니다. 객실도 넓고 청결했어요. 다음 가족여행에도 이용하고 싶습니다.', '2025-01-30 10:15:00', NULL, NULL, NULL),
(104, 301, 5, '강원도의 아름다운 풍경을 즐기기에 최적의 위치에 있는 숙소였습니다. 방 안에서도 산과 바다가 보여 전망이 훌륭했어요. 객실 내부도 모던하고 깔끔했습니다. 다만, 주차 공간이 조금 부족한 것이 아쉬웠어요. 그래도 다시 방문하고 싶은 곳입니다.', '2025-02-05 14:20:00', '/image/review/review6.jpg.jpg', '/image/review/review7.jpg.jpeg', NULL),
(105, 401, 11, '제주 여행의 완벽한 마무리를 할 수 있었습니다. 객실에서 보이는 오션뷰가 정말 환상적이었어요! 직원들도 매우 친절했고, 특히 조식이 다양하고 맛있었습니다. 호텔 내 부대시설도 잘 갖춰져 있어 비가 와도 지루하지 않았어요.', '2025-02-10 18:30:00', '/image/review/review8.jpg.jpg', '/image/review/review9.jpg.jpeg', '/image/review/review10.jpg.jpg'),
(106, 501, 14, '전라도의 맛과 멋을 느낄 수 있는 좋은 위치에 있었습니다. 한옥 스타일의 인테리어가 정말 마음에 들었어요. 침구도 고급스럽고 편안했습니다. 주변에 맛집도 많아서 식사하기도 편리했습니다. 다음에 전라도 여행 시 꼭 다시 묵고 싶습니다.', '2025-02-15 13:40:00', NULL, NULL, NULL),
(101, 601, 17, '경상도 여행의 중심지에 위치해 이동하기 편리했습니다. 객실은 깔끔했고, 침대가 너무 푹신해서 잠을 정말 잘 잤어요. 특히 스파 시설이 훌륭해 피로를 풀기 좋았습니다. 다음에 기회가 되면 꼭 다시 방문하고 싶어요.', '2025-02-20 17:15:00', '/image/review/review11.jpg.jpg', '/image/review/review12.jpg.jpg', NULL),
(102, 103, 25, '가족 여행으로 방문했는데, 아이들이 정말 좋아했습니다. 키즈룸도 잘 되어있고, 직원분들도 아이들에게 친절했어요. 객실도 넓고 깨끗해서 만족스러웠습니다. 조식도 종류가 다양해서 좋았어요. 가족 여행에 강력 추천합니다!', '2025-02-25 11:30:00', '/image/review/review13.jpg.jpg', '/image/review/review14.jpg.jpg', NULL),
(103, 204, 28, '비즈니스 출장으로 방문했는데 매우 만족스러웠습니다. 와이파이가 빠르고 안정적이었고, 책상도 넓어서 업무 보기 좋았어요. 침대도 편안해서 숙면을 취할 수 있었습니다. 주변에 식당도 많아 식사하기도 편리했습니다.', '2025-03-02 09:45:00', NULL, NULL, NULL),
(104, 305, 22, '커플 여행으로 방문했는데 로맨틱한 분위기가 너무 좋았습니다. 특히 야외 테라스에서 보는 야경이 환상적이었어요. 직원들도 프라이버시를 존중해주어 편안하게 쉴 수 있었습니다. 특별한 날에 다시 방문하고 싶은 곳입니다.', '2025-03-10 20:00:00', '/image/review/review15.jpg.jpg', '/image/review/review16.jpg.jpg', '/image/review/review17.jpg.jpg'),
(105, 402, 29, '친구들과 함께 여행왔는데 정말 즐거운 시간을 보냈습니다. 객실이 넓어서 4명이 지내기에 충분했고, 각종 편의시설도 잘 갖춰져 있었어요. 특히 바베큐 시설이 있어서 저녁에 고기를 구워 먹을 수 있어 좋았습니다.', '2025-03-25 15:20:00', '/image/review/review18.jpg.jpg', NULL, NULL),
(106, 203, 30, '한적한 곳에서 힐링하기 좋은 숙소였습니다. 주변이 조용해서 푹 쉴 수 있었고, 객실에서 보이는 자연 경관도 아름다웠어요. 조식으로 나온 지역 특산물로 만든 요리도 맛있었습니다. 일상에서 벗어나 쉬고 싶을 때 추천합니다.', '2025-04-05 12:10:00', '/image/review/review19.jpg.jpg', NULL, NULL),
(101, 304, 37, '겨울 여행으로 방문했는데, 객실 내 난방이 잘 되어 따뜻하게 지낼 수 있었습니다. 특히 온천 시설이 있어 추운 날씨에도 편안하게 즐길 수 있었어요. 주변 스키장과도 가까워서 접근성이 좋았습니다.', '2025-04-15 16:50:00', NULL, NULL, NULL),
(102, 403, 40, '가족 여행으로 방문했습니다. 객실이 넓고 깨끗했으며, 주방 시설도 잘 갖춰져 있어 간단한 요리를 해먹을 수 있어 좋았어요. 아이들을 위한 놀이시설도 있어 아이들이 심심하지 않게 즐길 수 있었습니다.', '2025-04-20 14:15:00', NULL, NULL, NULL),
(103, 502, 43, '전반적으로 만족스러운 숙박이었습니다. 객실은 깨끗했고, 직원들도 친절했어요. 조식의 퀄리티가 기대보다 훌륭했습니다. 다만, 주변에 편의시설이 조금 부족한 것이 아쉬웠어요. 그래도 조용히 쉬기에는 좋은 곳이었습니다.', '2025-04-30 11:30:00', NULL, NULL, NULL),
(104, 602, 46, '럭셔리한 숙박을 원하시는 분들께 추천합니다. 객실 인테리어부터 서비스까지 모든 것이 완벽했어요. 특히 침구류가 고급스럽고 편안해서 정말 좋았습니다. 스파 시설도 이용해봤는데 정말 만족스러웠어요.', '2025-05-10 18:20:00', NULL, NULL, NULL),
(105, 102, 48, '출장으로 방문했는데 비즈니스 고객을 위한 서비스가 잘 갖춰져 있었습니다. 비즈니스 센터도 있고, 와이파이도 빨라서 업무 처리하기 좋았어요. 조용한 환경이라 숙면을 취할 수 있었고, 조식도 만족스러웠습니다.', '2025-05-15 09:45:00', NULL, NULL, NULL),
(106, 103, 49, '가성비 좋은 숙소를 찾고 있다면 강력 추천합니다! 가격 대비 시설과 서비스가 우수했어요. 객실은 심플하지만 필요한 것들은 모두 갖춰져 있었습니다. 위치도 중심지에 있어 이동하기 편리했어요.', '2025-05-20 13:35:00', NULL, NULL, NULL),
(101, 104, 50, '친구들과 함께 여행왔는데 정말 즐거운 시간을 보냈습니다. 객실이 넓어서 4명이 지내기에 충분했고, 주변에 맛집과 관광지가 많아 다니기 편리했어요. 다음에 또 방문하고 싶은 숙소입니다.', '2025-06-01 17:00:00', NULL, NULL, NULL),
(102, 105, 50, '조용하고 한적한 분위기가 마음에 들었습니다. 자연 속에서 힐링할 수 있는 완벽한 장소였어요. 객실도 청결하고 아늑했으며, 주변 산책로도 잘 정비되어 있어 산책하기 좋았습니다. 특히 저녁에 보이는 별들이 인상적이었어요.', '2025-06-10 18:30:00', NULL, NULL, NULL),
(103, 403, 40, '호텔 직원들의 서비스가 정말 훌륭했습니다. 체크인부터 체크아웃까지 세심한 배려가 느껴졌어요. 객실도 깨끗하고 넓어서 편안하게 지냈습니다. 특히 조식 퀄리티가 기대 이상으로 맛있었어요!', '2025-06-15 11:45:00', NULL, NULL, NULL),
(104, 204, 28, '조용히 휴식을 취하기에 최적의 장소였습니다. 침구가 특히 편안해서 오랜만에 숙면을 취할 수 있었어요. 주변 환경도 깨끗하고 공기도 좋아 산책하기 좋았습니다. 다음에는 가족들과 함께 오고 싶네요.', '2025-06-20 14:15:00', '/image/review/review13.jpg.jpg', '/image/review/review14.jpg.jpg', NULL),
(105, 505, 43, '가족 여행으로 방문했는데 아이들이 너무 좋아했습니다. 키즈 프로그램이 다양하게 준비되어 있어서 아이들이 지루해하지 않았어요. 부모님도 편안하게 쉴 수 있어서 모두가 만족한 여행이었습니다.', '2025-06-25 16:30:00', NULL, NULL, NULL),
(106, 301, 33, '친절한 직원분들 덕분에 즐거운 여행이 되었습니다. 체크인할 때부터 지역 관광지 추천까지 세심하게 챙겨주셔서 감사했어요. 객실도 깨끗하고 전망도 좋았습니다. 조식도 다양한 메뉴로 구성되어 있어 만족스러웠어요.', '2025-07-01 09:30:00', NULL, NULL, NULL),
(101, 202, 52, '비즈니스 출장으로 이용했는데 매우 만족스러웠습니다. 와이파이 속도가 빠르고 책상이 넓어 업무 처리하기 편했어요. 객실도 깔끔하게 정돈되어 있었고, 조식도 다양한 메뉴로 구성되어 있어 좋았습니다.', '2025-07-05 12:45:00', '/image/review/review4.jpg.jpg', '/image/review/review5.jpg.jpeg', NULL),
(102, 604, 46, '숙소 위치가 관광하기 정말 좋았습니다. 주요 관광지까지 도보로 이동 가능한 거리였고, 주변에 맛집도 많아서 편리했어요. 객실도 깨끗하고 직원분들도 친절해서 즐거운 여행이 되었습니다.', '2025-07-10 19:20:00', NULL, NULL, NULL),
(103, 303, 35, '커플 여행으로 방문했는데 로맨틱한 분위기가 너무 좋았습니다. 특히 해질녘 테라스에서 보는 전경이 아름다웠어요. 침구도 편안하고 객실도 청결했습니다. 연인과 함께하기 좋은 숙소입니다.', '2025-07-15 20:30:00', '/image/review/review15.jpg.jpg', '/image/review/review16.jpg.jpg', '/image/review/review17.jpg.jpg'),
(105, 603, 46, '가격 대비 정말 훌륭한 숙소였습니다. 객실은 넓고 청결했으며, 어메니티도 고급스러웠어요. 스파 시설도 이용해봤는데 피로가 확 풀리는 느낌이었습니다. 다음에 기회가 되면 꼭 다시 방문하고 싶습니다.', '2025-07-20 15:50:00', NULL, NULL, NULL)

