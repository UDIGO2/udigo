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

-- 📌 충청 지역 호텔 데이터
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
        '/image/acm/chuncheong/solago1.jpg',
        '/image/acm/chuncheong/solago1.jpg',
        '/image/acm/chuncheong/solago1.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('충청', '오무아무아 풀빌라 단양', '충북 단양군 대강면 괴평리 164', 221000,
        '자연 속 한적한 시골마을에 위치한 독채 풀빌라로, 총 다섯 개의 복층 객실이 있으며, 각 객실별로 프라이빗한 야외정원과 4계절 야외 온수 풀이 갖추어져 있습니다. ', '0507-1497-1555', NOW(), 4, 50,
        '/image/acm/chuncheong/omuamua1.jpg',
        '/image/acm/chuncheong/omuamua1.jpg',
        '/image/acm/chuncheong/omuamua1.jpg',
        '/image/acm/chuncheong/omuamua1.jpg',
        '/image/acm/chuncheong/omuamua1.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('충청', '한옥스테이 연 청주', '충북 청주시 청원구 오창읍 미래지로 71-67 한옥스테이연', 68000,
        '청주시 오창읍 미래지 테마공원에 위치한 한옥스테이로, 전통의 아름다움과 한옥의 평온한 휴식을 즐길 수 있는 독채 공간입니다. ', '043-212-8959', NOW(), 6, 89,
        '/image/acm/chuncheong/yeon1.jpg',
        '/image/acm/chuncheong/yeon1.jpg',
        '/image/acm/chuncheong/yeon1.jpg',
        '/image/acm/chuncheong/yeon1.jpg',
        '/image/acm/chuncheong/yeon1.jpg'
       );

-- 📌 강원 지역 호텔 데이터
INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('강원', '강릉 오션뷰 호텔', '강원도 강릉시 해변로 123', 120000,
        '동해의 아름다운 전경을 감상하며 럭셔리한 휴식을 즐길 수 있는 최고의 해안가 호텔입니다.', '033-123-4567', NOW(), 4, 77,
        '/image/acm/gangwon/gangreung1.jpg',
        '/image/acm/gangwon/gangreung1.jpg',
        '/image/acm/gangwon/gangreung1.jpg',
        '/image/acm/gangwon/gangreung1.jpg',
        '/image/acm/gangwon/gangreung1.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('강원', '춘천 한옥 스테이', '강원도 춘천시 한옥길 45', 90000,
        '전통 한옥 체험이 가능한, 정원이 아름다운 한옥 스테이입니다.', '033-987-6543', NOW(), 4, 102,
        '/image/acm/gangwon/chuncheon1.jpg',
        '/image/acm/gangwon/chuncheon1.jpg',
        '/image/acm/gangwon/chuncheon1.jpg',
        '/image/acm/gangwon/chuncheon1.jpg',
        '/image/acm/gangwon/chuncheon1.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('강원', '평창 스키 리조트', '강원도 평창군 올림픽로 567', 250000,
        '평창 스키 리조트는 세계적인 수준의 슬로프와 아름다운 설경을 자랑하는 대한민국 최고의 겨울 스포츠 명소입니다.', '033-567-8901', NOW(), 4, 77,
        '/image/acm/gangwon/pyungchang1.jpg',
        '/image/acm/gangwon/pyungchang1.jpg',
        '/image/acm/gangwon/pyungchang1.jpg',
        '/image/acm/gangwon/pyungchang1.jpg',
        '/image/acm/gangwon/pyungchang1.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4)
VALUES ('강원', '속초 바다 펜션', '강원도 속초시 해변길 89', 70000,
        '속초 바다 펜션은 푸른 동해를 한눈에 담을 수 있는 오션뷰 숙소로, 여유로운 휴식과 감성적인 힐링을 선사합니다.', '033-432-1098', NOW(), 4, 77,
        '/image/acm/gangwon/sokcho1.jpg',
        '/image/acm/gangwon/sokcho1.jpg',
        '/image/acm/gangwon/sokcho1.jpg',
        '/image/acm/gangwon/sokcho1.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3, acm_photo4, acm_photo5)
VALUES ('강원', '홍천 캠핑 글램핑', '강원도 홍천군 산속길 321', 150000,
        '청정 자연 속에서 캠핑의 자유로움과 글램핑의 편안함을 동시에 즐길 수 있는 힐링 명소입니다.', '033-321-6547', NOW(), 4, 77,
        '/image/acm/gangwon/hongcheon1.jpg',
        '/image/acm/gangwon/hongcheon1.jpg',
        '/image/acm/gangwon/hongcheon1.jpg',
        '/image/acm/gangwon/hongcheon1.jpg',
        '/image/acm/gangwon/hongcheon1.jpg'
       );

-- 📌 제주 지역 호텔 데이터
INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3)
VALUES ('제주', '롯데호텔 제주', '제주특별자치도 서귀포시 중문관광로72번길 35', 250000,
        '롯데호텔 제주는 언제나 내 집과 같은 편안함과 아늑함을 제공합니다.',
        '064-731-1000', NOW(), 4, 800,
        '/image/acm/jeju/jeju-hotel.jpg',
        '/image/acm/jeju/jeju-hotel2.jpg',
        '/image/acm/jeju/din-LTJE.jpg'
       );

INSERT INTO tbl_acm (acm_location, acm_name, acm_address , acm_price, acm_info, acm_phone,regist_date, max_guest,liked_count, acm_photo1, acm_photo2, acm_photo3)
VALUES ('제주','제주 신라호텔','제주특별자치도 서귀포시 특별자치도, 중문관광로72번길 75', 250000,
        '내 집과 같은 편안함으로 공간 이상의 가치가 숨쉬고 있는 제주 신라호텔.',
        '064-735-5114', NOW(), 4,800,
        '/image/acm/jeju/sinla.jpg',
        '/image/acm/jeju/sinla2.jpg',
        '/image/acm/jeju/sinla3.jpg'
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
-- 📌 전라 지역 호텔 데이터

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


VALUES ('전라','베스트웨스턴플러스 전주호텔','전라북도 전주시 완산구 현무1길 4', 250000,
        '전주 한옥마을과 가까운 최적의 위치에서 편안한 숙박을 제공하는 모던한 스타일의 호텔입니다.',
        '063-123-4569', NOW(), 4,800,
        '/image/acm/jeonla/western1.jpg',
        '/image/acm/jeonla/western2.jpg',
        '/image/acm/jeonla/western3.jpg'
       );
-- 📌 경상 지역 호텔 데이터

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

-- 공지사항 (board_type = 1) 20개
INSERT INTO `tbl_board_posts` (`member_code`, `board_type`, `title`, `content`, `created_at`, `updated_at`) VALUES
                                                                                                                (1, 1, '호텔 리노베이션 안내', '안녕하세요, 고객 여러분! 호텔 내부 리노베이션 공사가 2025년 4월 1일부터 4월 15일까지 진행될 예정입니다. 이 기간 동안 일부 시설 이용에 제한이 있을 수 있으니 이용에 참고 부탁드립니다. 불편을 끼쳐드려 죄송합니다.', NOW(), NULL),
                                                                                                                (1, 1, '객실 요금 변경 안내', '다가오는 성수기(2025년 7월 1일부터 8월 31일까지)에 맞춰 객실 요금이 10% 인상될 예정입니다. 자세한 내용은 공식 홈페이지를 참고해주세요. 기존 예약 고객님들께는 변경된 요금이 적용되지 않으니 안심하세요.', NOW(), NULL),
                                                                                                                (1, 1, '수영장 이용 시간 변경', '호텔 수영장의 운영 시간이 2025년 3월 1일부터 조정되었습니다. 변경된 운영 시간은 오전 8시부터 오후 10시까지입니다. 또한 매주 월요일은 정기 청소로 인해 오후 1시부터 이용 가능합니다.', NOW(), NULL),
                                                                                                                (1, 1, '신규 레스토랑 오픈 안내', '호텔 1층에 새로운 이탈리안 레스토랑 "라 트라토리아"가 2025년 4월 20일 그랜드 오픈합니다. 오픈 기념 이벤트로 첫 주 방문 고객께는 웰컴 드링크를 무료로 제공해 드립니다.', NOW(), NULL),
                                                                                                                (1, 1, '주차장 공사 안내', '호텔 주차장 확장 공사로 인해 2025년 5월 10일부터 5월 20일까지 주차 공간이 제한될 예정입니다. 해당 기간 투숙객께서는 인근 제휴 주차장을 이용해 주시기 바랍니다. 불편을 드려 죄송합니다.', NOW(), NULL),
                                                                                                                (1, 1, '여름 시즌 스페셜 패키지 출시', '2025년 여름 시즌을 맞아 특별 패키지 상품을 출시합니다. 객실 1박과 조식 2인, 수영장 무료 이용권이 포함된 패키지로, 5월 1일부터 예약 가능합니다. 얼리버드 예약 시 10% 추가 할인 혜택을 놓치지 마세요!', NOW(), NULL),
                                                                                                                (1, 1, '호텔 앱 업데이트 안내', '호텔 모바일 앱이 새롭게 업데이트되었습니다. 이제 앱을 통해 룸서비스 주문, 시설 예약, 체크인/체크아웃까지 더욱 편리하게 이용하실 수 있습니다. 앱스토어에서 최신 버전으로 업데이트해 주세요.', NOW(), NULL),
                                                                                                                (1, 1, '객실 내 비품 교체 안내', '고객님의 더 나은 투숙 경험을 위해 전 객실의 침구류와 타월을 친환경 소재로 교체하였습니다. 또한 객실 내 커피머신도 최신형으로 업그레이드되었으니 편안한 휴식과 함께 즐겨보세요.', NOW(), NULL),
                                                                                                                (1, 1, '호텔 멤버십 프로그램 개편', '호텔 멤버십 프로그램이 2025년 6월 1일부터 새롭게 개편됩니다. 포인트 적립률이 상향되고, 다양한 제휴사 혜택이 추가됩니다. 기존 회원님들은 자동으로 새 프로그램으로 전환되며, 추가 보너스 포인트도 지급됩니다.', NOW(), NULL),
                                                                                                                (1, 1, '코로나19 방역 지침 안내', '고객님의 안전한 투숙을 위해 코로나19 방역 지침을 강화하였습니다. 모든 공용 공간에서 마스크 착용을 권장드리며, 입구에 손소독제가 비치되어 있습니다. 또한 객실 청소 시 UV 살균기를 추가로 사용하여 위생 관리에 만전을 기하고 있습니다.', NOW(), NULL),
                                                                                                                (1, 1, '호텔 셔틀버스 노선 확대', '2025년 4월부터 호텔 셔틀버스 노선이 확대됩니다. 기존 공항 노선에 더해 주요 관광지를 순환하는 노선이 신설되어 더욱 편리하게 이동하실 수 있습니다. 자세한 운행 시간표는 프론트 데스크에서 확인하실 수 있습니다.', NOW(), NULL),
                                                                                                                (1, 1, '객실 예약 시스템 점검 안내', '시스템 정기 점검으로 인해 2025년 3월 25일 오전 2시부터 6시까지 온라인 예약 시스템 이용이 제한됩니다. 해당 시간에는 전화 예약만 가능하오니 양해 부탁드립니다.', NOW(), NULL),
                                                                                                                (1, 1, '호텔 피트니스 센터 리뉴얼', '더 나은 서비스 제공을 위해 피트니스 센터가 2025년 5월 1일부터 15일까지 리뉴얼 공사를 진행합니다. 공사 기간 동안 인근 제휴 피트니스 센터를 무료로 이용하실 수 있으니 프론트에 문의해 주세요.', NOW(), NULL),
                                                                                                                (1, 1, '어린이날 특별 이벤트 안내', '2025년 5월 5일 어린이날을 맞아 호텔에서 특별 이벤트를 진행합니다. 키즈 쿠킹 클래스, 페이스 페인팅, 마술 공연 등 다양한 프로그램이 준비되어 있으니 가족과 함께 특별한 추억을 만들어 보세요.', NOW(), NULL),
                                                                                                                (1, 1, '호텔 레스토랑 메뉴 개편', '계절의 변화와 함께 호텔 내 모든 레스토랑의 메뉴가 새롭게 개편되었습니다. 지역 특산물을 활용한 신메뉴와 시그니처 칵테일을 선보이니 투숙하시는 동안 색다른 미식 경험을 즐겨보세요.', NOW(), NULL),
                                                                                                                (1, 1, '호텔 주변 교통 통제 안내', '호텔 인근에서 진행되는 마라톤 대회로 인해 2025년 4월 10일 오전 7시부터 오후 2시까지 일부 도로가 통제됩니다. 해당 시간에 체크인/체크아웃 예정인 고객께서는 교통 혼잡에 유의하시기 바랍니다.', NOW(), NULL),
                                                                                                                (1, 1, '객실 내 비상 대피 안내문 갱신', '고객님의 안전을 위해 객실 내 비상 대피 안내문이 갱신되었습니다. 투숙 시 반드시 객실 문 뒤에 부착된 대피 경로를 확인해 주시기 바랍니다. 또한 매월 첫째 주 화요일에는 화재 경보 테스트가 진행됩니다.', NOW(), NULL),
                                                                                                                (1, 1, '호텔 수영장 계절 운영 안내', '야외 수영장이 2025년 6월 1일부터 9월 30일까지 계절 운영됩니다. 시원한 음료와 함께 도심 속 휴양을 즐겨보세요. 주말에는 수영장 DJ 이벤트도 진행되니 많은 이용 바랍니다.', NOW(), NULL),
                                                                                                                (1, 1, '호텔 뷔페 레스토랑 임시 휴업', '뷔페 레스토랑 "더 테라스"가 시설 보수로 인해 2025년 4월 5일부터 4월 10일까지 임시 휴업합니다. 해당 기간 투숙객께서는 다른 레스토랑을 이용해 주시기 바라며, 불편을 드려 죄송합니다.', NOW(), NULL),
                                                                                                                (1, 1, '호텔 주변 관광 정보 업데이트', '호텔 주변 관광 정보가 업데이트되었습니다. 새롭게 오픈한 박물관과 쇼핑몰 정보가 추가되었으니, 컨시어지 데스크에서 최신 관광 가이드를 받아가세요. 투숙객 전용 할인 쿠폰도 함께 제공됩니다.', NOW(), NULL),

-- FAQ (board_type = 2) 20개
                                                                                                                (1, 2, '체크인 및 체크아웃 시간은 언제인가요?', '체크인은 오후 3시부터 가능하며, 체크아웃은 오전 11시까지 완료해주셔야 합니다. 얼리 체크인이나 레이트 체크아웃을 원하시면 프론트 데스크로 문의해 주세요. 가능 여부에 따라 추가 요금이 발생할 수 있습니다.', NOW(), NULL),
                                                                                                                (1, 2, '반려동물 동반 입실이 가능한가요?', '죄송합니다. 당 호텔은 반려동물 동반 입실을 제한하고 있습니다. 단, 안내견은 예외적으로 입실이 가능합니다. 주변에 반려동물 호텔을 안내해 드릴 수 있으니 필요하시면 문의해 주세요.', NOW(), NULL),
                                                                                                                (1, 2, '추가 침대 요청이 가능한가요?', '네, 가능합니다. 추가 침대는 1박당 30,000원의 요금이 발생하며, 객실 크기에 따라 배치가 제한될 수 있습니다. 사전에 예약 시 요청해 주시거나 체크인 시 프론트 데스크에 문의해 주세요.', NOW(), NULL),
                                                                                                                (1, 2, '호텔 내 주차 시설이 있나요?', '네, 호텔 내 지하 주차장이 마련되어 있습니다. 투숙객은 1박당 1대의 차량에 한해 무료 주차가 가능합니다. 추가 차량은 시간당 5,000원의 주차 요금이 부과됩니다.', NOW(), NULL),
                                                                                                                (1, 2, '객실 내 금연인가요?', '네, 모든 객실은 금연입니다. 흡연 시 객실 클리닝 비용 100,000원이 추가로 청구될 수 있습니다. 흡연을 원하시는 고객께서는 1층과 옥상에 마련된 흡연 구역을 이용해 주시기 바랍니다.', NOW(), NULL),
                                                                                                                (1, 2, '와이파이는 무료로 제공되나요?', '네, 호텔 전 구역에서 고속 와이파이가 무료로 제공됩니다. 객실 내 안내문에 접속 방법이 기재되어 있으며, 추가 도움이 필요하시면 프론트 데스크로 문의해 주세요.', NOW(), NULL),
                                                                                                                (1, 2, '조식은 몇 시부터 몇 시까지인가요?', '조식은 평일(월-금) 오전 6시 30분부터 10시까지, 주말 및 공휴일은 오전 7시부터 10시 30분까지 운영됩니다. 1층 메인 레스토랑에서 뷔페 형식으로 제공됩니다.', NOW(), NULL),
                                                                                                                (1, 2, '객실 내 미니바 이용은 어떻게 하나요?', '객실 내 미니바는 유료로 운영되며, 이용하신 품목은 체크아웃 시 계산됩니다. 미니바 품목 리스트와 가격은 객실 내 안내문을 참고해 주세요.', NOW(), NULL),
                                                                                                                (1, 2, '호텔에서 세탁 서비스를 제공하나요?', '네, 세탁 및 드라이클리닝 서비스를 제공합니다. 오전 9시 이전에 요청하시면 당일 저녁에 받으실 수 있습니다. 세탁물 가방과 신청서는 옷장 안에 구비되어 있습니다.', NOW(), NULL),
                                                                                                                (1, 2, '호텔에서 공항까지 셔틀 서비스가 있나요?', '네, 호텔에서 공항까지 셔틀 서비스를 운영하고 있습니다. 1일 4회(오전 7시, 10시, 오후 1시, 4시) 운행하며, 이용 시 최소 24시간 전에 예약이 필요합니다. 프론트 데스크에서 예약 가능합니다.', NOW(), NULL),
                                                                                                                (1, 2, '객실 내 금고 사용법을 알려주세요.', '객실 내 금고는 옷장 안에 위치해 있습니다. 사용 시 원하는 4-6자리 비밀번호를 설정하신 후 # 버튼을 누르면 잠깁니다. 열 때는 설정한 비밀번호를 입력 후 # 버튼을 누르시면 됩니다.', NOW(), NULL),
                                                                                                                (1, 2, '호텔 내 비즈니스 센터가 있나요?', '네, 2층에 비즈니스 센터가 위치해 있으며 24시간 이용 가능합니다. 컴퓨터, 프린터, 복사기, 팩스 등의 서비스를 제공하며, 회의실 대여도 가능합니다.', NOW(), NULL),
                                                                                                                (1, 2, '객실 내 다리미를 사용할 수 있나요?', '네, 다리미와 다리미판은 프론트 데스크에 요청하시면 무료로 대여해 드립니다. 일부 스위트룸에는 기본으로 구비되어 있습니다.', NOW(), NULL),
                                                                                                                (1, 2, '호텔 내 수영장 이용 시간은 어떻게 되나요?', '실내 수영장은 오전 6시부터 오후 10시까지, 야외 수영장(계절 운영)은 오전 8시부터 오후 8시까지 이용 가능합니다. 수영장 이용 시 수영모 착용은 선택 사항입니다.', NOW(), NULL),
                                                                                                                (1, 2, '객실 예약 취소 정책은 어떻게 되나요?', '체크인 날짜로부터 7일 전까지 취소 시 전액 환불됩니다. 3-6일 전 취소 시 1박 요금이 위약금으로 부과되며, 2일 이내 취소 또는 노쇼의 경우 전체 예약 금액이 청구됩니다.', NOW(), NULL),
                                                                                                                (1, 2, '호텔 내 레스토랑 예약은 어떻게 하나요?', '호텔 내 레스토랑 예약은 객실 전화로 7번을 누르시거나, 프론트 데스크를 방문하시면 도움을 드립니다. 주말 및 성수기에는 사전 예약을 권장합니다.', NOW(), NULL),
                                                                                                                (1, 2, '객실에서 룸서비스 주문은 어떻게 하나요?', '객실 내 메뉴판을 참고하신 후, 객실 전화로 3번을 누르시면 룸서비스로 연결됩니다. 룸서비스는 24시간 운영되나, 심야 시간(오후 11시 - 오전 6시)에는 제한된 메뉴만 주문 가능합니다.', NOW(), NULL),
                                                                                                                (1, 2, '호텔 내 사우나 시설이 있나요?', '네, 지하 1층에 사우나 시설이 있으며, 오전 6시부터 오후 10시까지 이용 가능합니다. 투숙객은 무료로 이용하실 수 있으며, 타월과 어메니티가 제공됩니다.', NOW(), NULL),
                                                                                                                (1, 2, '객실 내 에어컨/난방 조절은 어떻게 하나요?', '객실 내 온도 조절기는 침대 옆 벽면에 위치해 있습니다. 원하시는 온도를 설정하신 후 전원 버튼을 누르시면 작동합니다. 추가 도움이 필요하시면 프론트 데스크로 문의해 주세요.', NOW(), NULL),
                                                                                                                (1, 2, '호텔에서 관광 티켓 구매나 투어 예약이 가능한가요?', '네, 1층 컨시어지 데스크에서 주변 관광지 티켓 구매 및 투어 예약을 도와드립니다. 일부 인기 관광지는 호텔 투숙객 할인이 적용됩니다.', NOW(), NULL),

-- 1대1 질문 (board_type = 3) 30개
                                                                                                                (101, 3, '객실 예약 변경이 가능한가요?', '안녕하세요. 4월 15일부터 17일까지 예약한 디럭스 더블룸을 4월 20일부터 22일로 변경하고 싶습니다. 가능할까요? 예약번호는 ABC12345입니다.', NOW(), NULL),
                                                                                                                (101, 3, '객실 내 냉장고 크기가 궁금합니다', '다음 주에 투숙 예정인데, 객실 내 냉장고 크기가 궁금합니다. 1.5L 생수 몇 병 정도 들어갈 수 있나요? 음식물을 좀 가져갈 예정이라서요.', NOW(), NULL),
                                                                                                                (101, 3, '유아용 침대 요청 가능한가요?', '다음 달 투숙 예정인데 10개월 아기가 있어서 유아용 침대가 필요합니다. 추가 비용은 얼마인지, 미리 예약해야 하는지 알려주세요.', NOW(), NULL),
                                                                                                                (102, 3, '조식 포함 여부 문의', '이번 주말에 투숙 예정인데, 예약한 객실에 조식이 포함되어 있는지 확인하고 싶습니다. 예약번호는 DEF67890입니다.', NOW(), NULL),
                                                                                                                (102, 3, '수영장 이용 가능 시간이 궁금합니다', '다음 주에 투숙 예정인데 수영장 이용 가능 시간과 수영모 착용 여부가 궁금합니다. 또한 수영장 타월은 별도로 제공되나요?', NOW(), NULL),
                                                                                                                (102, 3, '객실 전망 관련 문의', '오션뷰 객실로 예약했는데, 실제로 바다가 잘 보이는지 궁금합니다. 혹시 상층부 객실로 배정 요청이 가능할까요?', NOW(), NULL),
                                                                                                                (103, 3, '공항 픽업 서비스가 있나요?', '호텔에서 공항까지 픽업 서비스를 제공하나요? 제공된다면 이용 방법과 비용을 알려주세요. 다음 주 화요일 오후 3시에 도착 예정입니다.', NOW(), NULL),
                                                                                                                (103, 3, '객실 내 비품 추가 요청', '이번 주말 투숙 예정인데, 객실에 추가 베개와 담요를 요청하고 싶습니다. 가능할까요? 예약번호는 GHI24680입니다.', NOW(), NULL),
                                                                                                                (103, 3, '주변 맛집 추천 부탁드립니다', '다음 주에 가족여행으로 투숙 예정인데, 호텔 주변에 가볼만한 맛집이나 카페를 추천해주세요. 아이들도 함께 가는데 적합한 곳이면 좋겠습니다.', NOW(), NULL),
                                                                                                                (104, 3, '객실 내 와이파이 속도는 어떤가요?', '업무차 방문 예정인데 화상회의를 진행해야 해서 와이파이 속도가 궁금합니다. 안정적으로 사용 가능한지 알려주세요.', NOW(), NULL),
                                                                                                                (104, 3, '체크아웃 시간 연장 가능한가요?', '이번 주 토요일 체크아웃 예정인데, 오후 비행기라 체크아웃 시간을 2시간 정도 연장하고 싶습니다. 가능할까요? 추가 비용은 얼마인가요?', NOW(), NULL),
                                                                                                                (104, 3, '객실 내 커피머신 사용법', '현재 투숙 중인데 객실에 있는 커피머신 사용법을 모르겠습니다. 설명서가 없어서 문의드립니다. 객실 번호는 1234호입니다.', NOW(), NULL),
                                                                                                                (105, 3, '호텔 내 비즈니스 센터 이용 문의', '다음 주에 비즈니스 출장으로 투숙 예정인데, 호텔 내 비즈니스 센터 이용 가능 시간과 제공 서비스(프린터, 복사기 등)가 궁금합니다.', NOW(), NULL),
                                                                                                                (105, 3, '객실 청소 시간 조정 가능한가요?', '현재 투숙 중인데, 내일은 오후 2시부터 4시 사이에 회의가 있어서 그 시간에 객실 청소를 피하고 싶습니다. 청소 시간 조정이 가능할까요?', NOW(), NULL),
                                                                                                                (105, 3, '호텔 내 레스토랑 예약 문의', '이번 주말 투숙 예정인데, 호텔 내 레스토랑에서 저녁 식사를 하고 싶습니다. 예약이 필요한가요? 또한 드레스 코드가 있는지도 알려주세요.', NOW(), NULL),
                                                                                                                (106, 3, '객실 내 금고 고장', '현재 투숙 중인데 객실 내 금고가 작동하지 않습니다. 비밀번호를 설정했는데 열리지 않아요. 도움이 필요합니다. 객실 번호는 5678호입니다.', NOW(), NULL),
                                                                                                                (106, 3, '주변 관광지 교통편 문의', '다음 주에 관광 목적으로 투숙 예정인데, 주요 관광지까지 가는 교통편과 소요 시간을 알려주세요. 또한 호텔에서 투어 예약도 가능한가요?', NOW(), NULL),
                                                                                                                (106, 3, '룸서비스 메뉴 문의', '오늘 밤 늦게 체크인 예정인데, 룸서비스가 24시간 운영되는지 궁금합니다. 늦은 시간에 이용 가능한 메뉴가 있을까요?', NOW(), NULL),
                                                                                                                (101, 3, '객실 내 미니바 이용 방법', '현재 투숙 중인데 미니바 이용 시 별도로 프론트에 알려야 하나요? 아니면 자동으로 계산되나요? 가격표는 어디서 확인할 수 있을까요?', NOW(), NULL),
                                                                                                                (101, 3, '호텔 내 헬스장 이용 시간', '다음 주에 투숙 예정인데 헬스장 이용 가능 시간과 시설 현황(러닝머신, 웨이트 기구 등)이 궁금합니다. 별도의 이용료가 있나요?', NOW(), NULL),
                                                                                                                (101, 3, '세탁 서비스 이용 방법', '출장으로 1주일간 투숙 예정인데, 세탁 서비스를 이용하고 싶습니다. 이용 방법과 비용, 소요 시간을 알려주세요.', NOW(), NULL),
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
(201,101,'2025-03-11','2025-03-13',3,true,NOW()),
(202,101,'2025-03-15','2025-03-19',3,true,NOW()),
# (101,102,'2025-03-18','2025-03-20',3,true,NOW()), #넣으려면 주석
(102,103,'2025-03-11','2025-03-14',3,true,NOW()),
(103,104,'2025-03-11','2025-03-14',3,true,NOW()),
(104,104,'2025-03-11','2025-03-14',3,true,NOW()),
# (104,105,'2025-03-13','2025-03-15',3,true,NOW()), #넣으려면 주석
(105,105,'2025-03-11','2025-03-14',3,true,NOW());

# 리뷰 데이터 / 리뷰 이미지 추가 예정
INSERT INTO `tbl_reviews` (member_code, acm_id, resv_id, content, written_at) VALUES
(101,101,1,'후기 작성 내용 입니다.1',now()),
(101,102,2,'후기 작성 내용 입니다.2',now()),
(101,103,3,'후기 작성 내용 입니다.3',now()),
(101,104,4,'후기 작성 내용 입니다.4',now()),
(101,105,5,'후기 작성 내용 입니다.5',now()),
(102,201,6,'후기 작성 내용 입니다.6',now()),
(102,202,1,'후기 작성 내용 입니다.7',now()),
(102,203,2,'후기 작성 내용 입니다.8',now()),
(102,204,3,'후기 작성 내용 입니다.9',now()),
(102,205,4,'후기 작성 내용 입니다.10',now()),
(103,301,5,'후기 작성 내용 입니다.11',now()),
(103,302,6,'후기 작성 내용 입니다.12',now()),
(103,303,1,'후기 작성 내용 입니다.13',now()),
(103,304,2,'후기 작성 내용 입니다.14',now()),
(103,305,3,'후기 작성 내용 입니다.15',now());

