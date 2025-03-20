document.addEventListener("DOMContentLoaded", function () {
    getPayListPage();
});

/**
 * 결제 내역 페이지에 데이터를 로드하는 함수
 * 서버로부터 결제 내역을 가져와 테이블에 표시
 */
function getPayListPage() {
    console.log("숙소 결제 내역 페이지 데이터 전달 받는 AJAX 시작");

    fetch("/payList", {
        method: "POST",
    }).then(response => response.json())
        .then(data => {
            console.log(data);
            if (data) {
                console.log('결제 내역 불러오기 성공!');

                let payListData = data.payListItems; // 숙소 결제 내역
                console.log(payListData);
                let payTable = $("#payListTable tbody"); // payList Table의 tbody 선택

                payTable.empty();

                payListData.forEach(item => {
                    // 날짜를 'yyyy-MM-dd' 형식으로 변환
                    let payDate = new Date(item.payDate).toISOString().split("T")[0];
                    let checkIn = new Date(item.checkIn).toISOString().split("T")[0];
                    let checkOut = new Date(item.checkOut).toISOString().split("T")[0];
                    let payPrice = item.payPrice.toLocaleString();

                    let tableRow = `<tr>
                        <td>${payDate}</td>
                        <td>${item.acmName}</td>
                        <td>${item.guestCount}</td>
                        <td>${checkIn} ~ ${checkOut}</td>
                        <td>${checkIn}</td>
                        <td>${payPrice}</td>
                    </tr>`;

                    payTable.append(tableRow);
                });
            } else {
                alert("결제 내역 불러오기 실패!");
            }
        }).catch(error => {
        console.error("결제 내역 불러오기 중 오류:", error);
        alert("결제 내역 불러오기 중 오류 발생!");
    });
}

