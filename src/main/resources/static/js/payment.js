$(document).ready(function () {
    // ✅ 결제 버튼 클릭 이벤트 등록 (기존 코드 유지)
    $(document).on("click", ".payButton", function () {
        console.log("결제 버튼 클릭됨!");
        requestPayment();
    });

    // ✅ 쿠폰 적용 버튼 기능 추가
    $("#applyCouponButton").on("click", function () {
        if (couponApplied) {
            alert("이미 쿠폰을 사용하였습니다.");
            return;
        }

        // ✅ HTML에서 memberId 가져오기
        let userInfoElement = document.getElementById("userInfo");
        let memberId = userInfoElement ? userInfoElement.dataset.memberId : null;

        if (!memberId || memberId.trim() === "") {
            alert("로그인이 필요합니다.");
            return;
        }

        axios.post(`/member/useCoupon?memberId=${memberId}`)
            .then(response => {
                if (response.data.includes("성공적으로 사용")) {
                    alert("쿠폰이 적용되었습니다! 5000원 할인이 적용됩니다.");

                    let totalPriceElement = $("#totalPrice");
                    let totalPrice = parseInt(totalPriceElement.text().replace(/,/g, ""));
                    totalPrice -= 5000;
                    totalPriceElement.text(totalPrice.toLocaleString() + "원");

                    couponApplied = true; // ✅ 쿠폰 적용 상태 변경
                    $("#applyCouponButton").prop("disabled", true);
                } else {
                    alert(response.data);
                }
            })
            .catch(error => {
                console.error("쿠폰 적용 실패:", error);
                alert("쿠폰을 적용할 수 없습니다.");
            });
    });
});

// ✅ PortOne(구 아임포트) 결제 요청 함수 (기존 코드 유지)
function requestPayment() {
    IMP.init("imp61481528"); // PortOne 가맹점 코드 입력

    let userName = $("input[placeholder='회원 이름을 입력해주세요.']").val();
    let phoneNumber = $("input[placeholder='전화번호를 입력해주세요.']").val();
    let amount = parseInt($("#totalPrice").text().replace(/,/g, "")); // ✅ 현재 결제 금액 적용

    if (couponApplied) {
        amount -= 5000; // ✅ 쿠폰 적용 시 5000원 할인
    }

    IMP.request_pay({
        pg: "html5_inicis", // 이니시스 PG 사용
        pay_method: "card", // 카드 결제
        merchant_uid: "ORDER_" + new Date().getTime(), // 주문 번호 (고유값)
        name: "숙소 예약 결제",
        amount: amount, // ✅ 실제 결제 금액 반영
        buyer_email: "user@example.com",
        buyer_name: userName,
        buyer_tel: phoneNumber
    }, function (rsp) {
        if (rsp.success) {
            console.log("결제 성공:", rsp);
            verifyPayment(rsp.imp_uid, rsp.merchant_uid);
        } else {
            console.error("결제 실패:", rsp.error_msg);
            alert("결제 실패: " + rsp.error_msg);
        }
    });
}

// ✅ 백엔드로 결제 검증 요청 (기존 코드 유지)
function verifyPayment(impUid, merchantUid) {
    fetch("/api/payment/verify", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ impUid: impUid, merchantUid: merchantUid })
    }).then(response => response.json())
        .then(data => {
            if (data.success) {
                alert("결제 성공!");
                window.location.href = "/order-confirmation"; // 결제 완료 페이지 이동
            } else {
                alert("결제 검증 실패!");
            }
        }).catch(error => {
        console.error("결제 검증 중 오류:", error);
        alert("결제 검증 중 오류 발생!");
    });
}

// ✅ 기존 코드 유지: 장바구니 데이터 불러오기
document.addEventListener("DOMContentLoaded", function () {
    loadCartItems();
});

// ✅ 기존 코드 유지: 장바구니 데이터 로드 함수
function loadCartItems() {
    console.log("장바구니 아이템 불러오기...");
}
