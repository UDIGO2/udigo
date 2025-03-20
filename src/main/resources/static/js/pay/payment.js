document.addEventListener("DOMContentLoaded", function () {
    getPaymentPage();

    // 결제 버튼 클릭 이벤트 등록
    $(document).on("click", ".payButton", function () {
        console.log("결제 버튼 클릭됨!");
        requestPayment();
    });
});

/**
 * 결제 페이지 데이터 로드 함수
 * URL에서 숙소 ID를 가져와 서버에 숙소 정보를 요청
 */
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

                $("#checkIn").text(data.checkIn || ""); // 체크인 날짜
                $("#checkOut").text(data.checkOut || ""); // 체크아웃 날짜
                $("#guestCount").text(data.guestCount || 2); // 인원 수
                $("#defaultPrice").text((cartData.acmPrice * 1).toLocaleString()); // 기본 가격

                // 접속자 정보 불러오기
                $("#userName").val(userData.memberName).data("acmId", cartData.acmId).data("memberCode", userData.memberCode); // 접속자 정보 및 숙소 정보
                $("#phoneNo").val(userData.phoneNo); // 접속자 전화번호

                // 총액 불러오기 (1은 총 묵는 날짜)
                $("#totalPrice").text((cartData.acmPrice * 1).toLocaleString()); // 총액
            } else {
                alert("카트 내역 불러오기 실패!");
            }
        }).catch(error => {
        console.error("카트 내역 불러오기 중 오류:", error);
        alert("카트 내역 불러오기 중 오류 발생!");
    });
}

/**
 * 결제 API 호출 함수
 * 포트원(구 아임포트) 결제 요청
 */
function requestPayment() {
    IMP.init("imp10103100"); // PortOne 가맹점 코드 입력

    let userName = $("#userName").val();
    let phoneNumber = $("#phoneNo").val();
    let amount = $("#totalPrice").text().replace(/,/g, ""); // 결제 금액

    console.log("결제 API 요청 시작");

    IMP.request_pay({
        pg: "html5_inicis.INIpayTest", // 이니시스 PG 사용
        pay_method: "card", // 카드 결제
        merchant_uid: "ORDER_" + new Date().getTime(), // 주문 번호 (고유값)
        name: "숙소 예약 결제",
        amount: 100, // 테스트용 결제 금액 (100원)
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

/**
 * API 결제 성공 시 데이터 저장하는 함수
 * @param {Object} rsp - 결제 응답 객체
 */
function verifyPayment(rsp) {
    console.log("결제 API 성공 이후 데이터 저장하는 AJAX 시작");

    const date = new Date(rsp.paid_at * 1000); // 유닉스 타임스탬프 값을 밀리초 단위로 변환

    fetch("/payment/save", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            memberCode: $("#userName").data("memberCode"),
            acmId: $("#userName").data("acmId"),
            payMethod: rsp.pay_method,
            payStatus: "결제완료",
            payType: rsp.pg_type,
            payDate: date,
            payPrice: rsp.paid_amount,
            discount: 0,
            transactionId: rsp.merchant_uid,
            payProvider: rsp.pg_provider,
            impUid: rsp.imp_uid,
            checkIn: $("#checkIn").text(),
            checkOut: $("#checkOut").text(),
            guestCount: $("#guestCount").text(),
            isResv: rsp.success
        })
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

