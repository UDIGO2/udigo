document.addEventListener("DOMContentLoaded", function () {
    // 선택 삭제 기능
    document.querySelector(".remove-selected").addEventListener("click", function () {
        document.querySelectorAll(".cart-checkbox:checked").forEach(checkbox => {
            const cartCode = checkbox.dataset.id;
            removeCartItem(cartCode);
        });
    });

    // 개별 삭제 기능
    document.querySelectorAll(".remove-item").forEach(button => {
        button.addEventListener("click", function (event) {
            event.preventDefault();
            const cartCode = this.dataset.id;
            removeCartItem(cartCode);
        });
    });

    // 수량 증가/감소 기능
    document.querySelectorAll(".increase-quantity").forEach(button => {
        button.addEventListener("click", function () {
            const cartCode = this.dataset.id;
            updateQuantity(cartCode, 1);
        });
    });

    document.querySelectorAll(".decrease-quantity").forEach(button => {
        button.addEventListener("click", function () {
            const cartCode = this.dataset.id;
            updateQuantity(cartCode, -1);
        });
    });

    // 장바구니 아이템 삭제 요청
    function removeCartItem(cartCode) {
        fetch(`/cart/delete?cartCode=${cartCode}`, { method: "POST" })
            .then(response => {
                if (response.ok) {
                    location.reload(); // 삭제 후 페이지 리로드
                } else {
                    alert("삭제에 실패했습니다.");
                }
            });
    }

    // 수량 업데이트 요청
    function updateQuantity(cartCode, change) {
        fetch(`/cart/updateQuantity?cartCode=${cartCode}&change=${change}`, { method: "POST" })
            .then(response => {
                if (response.ok) {
                    location.reload(); // 업데이트 후 페이지 리로드
                } else {
                    alert("수량 업데이트에 실패했습니다.");
                }
            });
    }
});
