document.addEventListener('DOMContentLoaded', function() {
    debugger;

    // 내비게이션 링크 핸들링
    const navLinks = document.querySelectorAll('.nav-links a');
    navLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
        });
    });

    // 비밀번호 변경 링크 핸들링
    const passwordChangeLink = document.querySelector('.password-change');
    if (passwordChangeLink) {
        passwordChangeLink.addEventListener('click', (e) => {
            e.preventDefault();
        });
    }

    // 예약 관련 링크 핸들링
    const reservationLinks = document.querySelectorAll('.reservation-links a');
    reservationLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            debugger;
            e.preventDefault();
        });
    });

    // 장바구니 관련 링크 핸들링
    const basketLinks = document.querySelectorAll('.basket-links a');
    basketLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            debugger;
            e.preventDefault();
        });
    });

    // 로그아웃 핸들링
    const logoutLink = document.querySelector('.logout');
    if (logoutLink) {
        logoutLink.addEventListener('click', (e) => {
            e.preventDefault();
            if (confirm('로그아웃 하시겠습니까?')) {
            }
        });
    }

    // 소셜 미디어 링크 핸들링
    const socialLinks = document.querySelectorAll('.social-links a');
    socialLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
        });
    });
});
