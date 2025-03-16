// 장바구니 페이지 로드 시 실행
document.addEventListener("DOMContentLoaded", () => {
    console.log("장바구니 페이지 로드됨");

    // 삭제 버튼 클릭 시 확인 메시지 표시
    const deleteButtons = document.querySelectorAll(".delete-btn");
    deleteButtons.forEach((button) => {
        button.addEventListener("click", (e) => {
            if (!confirm("정말로 이 항목을 삭제하시겠습니까?")) {
                e.preventDefault(); // 삭제를 취소
            }
        });
    });

});
