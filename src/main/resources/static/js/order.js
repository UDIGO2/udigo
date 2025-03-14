document.addEventListener("DOMContentLoaded", function () {
    // 주문하기 버튼 클릭 이벤트 리스너
    document.querySelector(".order_btn").addEventListener("click", function () {
        // 체크된 항목들 가져오기
        let checkedItems = document.querySelectorAll('input[name="cartItem"]:checked');
        let totalPrice = 0;
        let selectedItems = [];

        // 체크된 항목들의 이름과 가격 계산
        checkedItems.forEach((item) => {
            let itemName = item.dataset.name;
            let itemPrice = parseInt(item.dataset.price);
            totalPrice += itemPrice;
            selectedItems.push({ name: itemName, price: itemPrice });
        });

        // 선택된 항목이 없으면 알림
        if (checkedItems.length === 0) {
            alert("선택된 상품이 없습니다. 주문할 상품을 선택해주세요.");
            return;
        }

        // 총 가격이 0이면 알림
        if (totalPrice <= 0) {
            alert("총 결제 금액이 없습니다. 다시 확인해주세요.");
            return;
        }

        // 선택된 상품 정보를 URL 파라미터로 넘기기
        let queryString = new URLSearchParams({ totalPrice: totalPrice }).toString();
        selectedItems.forEach((item, index) => {
            queryString += `&item${index}=${encodeURIComponent(item.name)}&price${index}=${item.price}`;
        });

        console.log("결제 페이지로 이동: ", queryString); // 이동 전 URL 출력
        window.location.href = `/payment?${queryString}`; // 결제 페이지로 이동
    });
});


function loadCartItems() {
    // 가짜 장바구니 데이터 (테스트용)
    let cartItems = [
        { acm_id: 101, acm_name: "강남 호텔", acm_price: 120000 },
        { acm_id: 102, acm_name: "해운대 리조트", acm_price: 150000 }
    ];

    let cartList = document.getElementById("cartItemList");
    cartList.innerHTML = "";

    cartItems.forEach(item => {
        let listItem = document.createElement("li");
        listItem.innerHTML = `
            <input type="checkbox" name="cartItem" value="${item.acm_id}">
            ${item.acm_name} - ${item.acm_price.toLocaleString()}원
        `;
        cartList.appendChild(listItem);
    });
}



