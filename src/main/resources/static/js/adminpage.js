// DOM Elements
document.addEventListener('DOMContentLoaded', function() {
    // ✅ Navigation handling
    const navLinks = document.querySelectorAll('.nav-links a');
    navLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
            window.location.href = link.href; // 🚀 링크 정상 동작 추가
        });
    });

    // ✅ Member information link handling
    const memberInfoLink = document.querySelector('.member-section .full-width-link');
    if (memberInfoLink) {
        memberInfoLink.addEventListener('click', (e) => {
            e.preventDefault();
            window.location.href = "/admin/memberlist"; // 🚀 내 정보 페이지 이동
        });
    }

    // ✅ Reservation links
    const reservationLinks = document.querySelectorAll('.reservation-links a');
    reservationLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
            window.location.href = link.href; // 🚀 링크 정상 동작 추가
        });
    });

    // ✅ Accommodation links
    const accommodationLinks = document.querySelectorAll('.accommodation-links a');
    accommodationLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
            const action = link.textContent.trim();
            switch(action) {
                case '숙소 정보 관리 >':
                    window.location.href = "/admin/acm/list";
                    break;
                case '숙소 정보 수정 >':
                    window.location.href = "/acm/edit";
                    break;
                case '숙소 등록 >':
                    window.location.href = "/acm/register";
                    break;
                case '숙소 정보 삭제 >':
                    if (confirm("숙소 정보를 삭제하시겠습니까?")) {
                        // 🚀 서버에 삭제 요청을 보내는 코드 필요
                        console.log("숙소 삭제 요청 보냄");
                    }
                    break;
                case '숙소 후기 삭제 >':
                    if (confirm("숙소 후기를 삭제하시겠습니까?")) {
                        // 🚀 서버에 후기 삭제 요청을 보내는 코드 필요
                        console.log("숙소 후기 삭제 요청 보냄");
                    }
                    break;
            }
        });
    });

    // ✅ Logout handling
    const logoutLink = document.querySelector('.logout');
    if (logoutLink) {
        logoutLink.addEventListener('click', (e) => {
            e.preventDefault();
            if (confirm('로그아웃 하시겠습니까?')) {
                fetch('/auth/logout', { method: 'POST' }) // 🚀 로그아웃 요청
                    .then(response => {
                        if (response.ok) {
                            window.location.href = "/";
                        } else {
                            alert("로그아웃에 실패했습니다.");
                        }
                    })
                    .catch(error => console.error("로그아웃 중 오류 발생:", error));
            }
        });
    }

    // ✅ Social media links
    const socialLinks = document.querySelectorAll('.social-links a');
    socialLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
            window.open(link.href, "_blank"); // 🚀 새 창에서 열기
        });
    });
});
