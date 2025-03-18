document.addEventListener("DOMContentLoaded", function () {
    getPaymentPage();
    // checkLoginData();

    // 결제 버튼 클릭 이벤트 등록
    $(document).on("click", ".payButton", function () {
        console.log("결제 버튼 클릭됨!");
        requestPayment();
    });
});


function checkLoginData() {
    // 로그인 상태 확인
    // let memberCode = localStorage.getItem("memberCode");
    let memberCode = $("#userName").data("memberCode");

    if (memberCode) {
        console.log(`✅ 현재 로그인된 사용자: ${memberCode}`);
    } else {
        console.log("❌ 로그인되지 않음.");
    }
}

// 카트에서 날짜 선택 항목이 나올 떄까지 임시로 사용할 함수
// 랜덤한 날짜 가져오기 (startDate ~ endDate 사이의 랜덤한 날짜)
function getRandomDate(startDate, endDate) {
    const start = new Date(startDate).getTime(); // 첫날
    const end = new Date(endDate).getTime(); // 마지막 날
    const randomTime = start + Math.random() * (end - start);
    return new Date(randomTime);
}


function getPaymentPage() {
    // URL에서 파라미터 가져오기
    const urlParams = new URLSearchParams(window.location.search);
    // URL으로 넘긴 acmId 값 추출
    const params = urlParams.get("selectedIds");

    console.log("결제 API 페이지 데이터 전달 받는 AJAX 시작");

    fetch("/payment", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            selectedIds: params,  // selectedIds를 body로 전달
        }),
    }).then(response => response.json())
        .then(data => {
            console.log(data);
            if (data) {
                console.log('카트 내역 불러오기 성공!');

                let cartData = data.cartItems;
                let userData = data.memberInfo;

                // 카트 페이지 내에 날짜 및 인원 선택이 없어서 하드 코딩함
                let startDate = getRandomDate("2020-01-01", "2025-03-10");
                let lastDate = new Date(startDate);
                lastDate.setDate(lastDate.getDate() + 1);

                $("#checkIn").text(startDate.toISOString().split("T")[0]); // 체크인 날짜
                $("#checkOut").text(lastDate.toISOString().split("T")[0]); // 체크아웃 날짜
                $("#guestCount").text(2); // 인원 수
                $("#defaultPrice").text((cartData.acmPrice * 1).toLocaleString()); // 기본 가격

                // 접속자 정보 불러오기
                $("#userName").val(userData.memberName).data("acmId", cartData.acmId).data("memberCode", userData.memberCode); // 접속자 정보 및 숙소 정보
                $("#phoneNo").val(userData.phoneNo); // 접속자 전화번호

                // 총액 불러오기 (1은 총 묵는 날짜)
                $("#totalPrice").text((cartData.acmPrice * 1).toLocaleString()); // 총액

                // local storage 값이 제대로 넘어오지 않아 다르게 처리
                checkLoginData();

            } else {
                alert("카트 내역 불러오기 실패!");
            }
        }).catch(error => {
        console.error("카트 내역 불러오기 중 오류:", error);
        alert("카트 내역 불러오기 중 오류 발생!");
    });
}

// 결제 API 호출
// PortOne(구 아임포트) 결제 요청 함수
function requestPayment() {
    IMP.init("imp61481528"); // PortOne 가맹점 코드 입력

    let userName = $("#userName").val();
    let phoneNumber = $("#phoneNo").val();
    let amount = $("#totalPrice").text(); // 실제 결제 금액 (예제 값)

    console.log("결제 API 요청 시작");

    IMP.request_pay({
        pg: "html5_inicis.INIpayTest", // 이니시스 PG 사용
        pay_method: "card", // 카드 결제
        merchant_uid: "ORDER_" + new Date().getTime(), // 주문 번호 (고유값)
        name: "숙소 예약 결제",
        // amount: amount, // 결제 금액
        amount: 100, // 결제 금액
        buyer_email: "user@example.com", // 예제 이메일 (실제 적용 시 변경 필요)
        buyer_name: userName,
        buyer_tel: phoneNumber
    }, function (rsp) {
        if (rsp.success) {
            console.log("결제 성공:", rsp);
            verifyPayment(rsp);
        } else {
            console.error("결제 실패:", rsp.error_msg);
            alert("결제 실패: " + rsp.error_msg);
        }
    });
}

// API 결제 성공 시 데이터 저장하는 함수
function verifyPayment(rsp) {

    console.log("결제 API 성공 이후 데이터 저장하는 AJAX 시작");

    const date = new Date(rsp.paid_at * 1000); // 유닉스 타임스탬프 값을 밀리초 단위로 변환

    fetch("/payment/save", {
        method: "POST", // GET: 보안 X / URL blogPost&page=3 / GET 방식은 속도가 빨라, POST: 암호화돼서 넘어가 / 보안 good~! / 조금 더 느림
        headers: { "Content-Type": "application/json" }, // Content-Type: ajax 요청 보낼 때 이 데이터가 무슨 값인지 백엔드(JAVA) 알려주는 용도 - 파일 형태가 json이라고 알려주는 거
        body: JSON.stringify({
            memberCode: $("#userName").data("memberCode"),
            acmId: $("#userName").data("acmId"),
            payMethod: rsp.pay_method,
            payStatus: "결제완료",
            payType: rsp.pg_type,
            payDate: date,
            payPrice: rsp.paid_amount,
            discount: 0, // 추후 수정
            transactionId: rsp.merchant_uid,
            payProvider: rsp.pg_provider,
            impUid: rsp.imp_uid,
            checkIn: $("#checkIn").text(),
            checkOut: $("#checkOut").text(),
            guestCount: $("#guestCount").text(),
            isResv: rsp.success,
            // merchantUid: rsp.merchantUid
        }) // 넘겨질 데이터
    }).then(response => response.json())
        .then(data => {
            console.log(data);
            if (data.status) {
                alert("결제 성공!");
                window.location.href = "/payList"; // 결제 완료 페이지 이동
            } else {
                alert("결제 검증 실패!");
            }
        }).catch(error => {
        console.error("결제 검증 중 오류:", error);
        alert("결제 검증 중 오류 발생!");
    });

}

