document.addEventListener("DOMContentLoaded", function () {
    // 내비게이션 링크 핸들링
    const navLinks = document.querySelectorAll('.nav-links a');
    navLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
            window.location.href = link.href;
        });
    });

    // 회원 정보 링크 핸들링
    const memberInfoLink = document.querySelector('.member-section .full-width-link');
    if (memberInfoLink) {
        memberInfoLink.addEventListener('click', (e) => {
            e.preventDefault();
            window.location.href = "/admin/memberlist";
        });
    }

    // 예약 관련 링크 핸들링
    const reservationLinks = document.querySelectorAll('.reservation-links a');
    reservationLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
            window.location.href = link.href;
        });
    });

    // 숙소 관리 링크 핸들링
    const accommodationLinks = document.querySelectorAll('.accommodation-links a');
    accommodationLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
            const action = link.textContent.trim();
            switch(action) {
                case '숙소 정보 관리 >':
                    window.location.href = "/admin/acm/list";
                    break;
                case '숙소 등록 >':
                    window.location.href = "/admin/acm/register";
                    break;
                case '숙소 후기 삭제 >':
                    window.location.href = "/review/admin/review/list";
                    break;
            }
        });
    });

    // 로그아웃 핸들링
    const logoutLink = document.querySelector('.logout');
    if (logoutLink) {
        logoutLink.addEventListener('click', (e) => {
            e.preventDefault();
            if (confirm('로그아웃 하시겠습니까?')) {
                fetch('/auth/logout', { method: 'POST' })
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

    // 소셜 미디어 링크 핸들링
    const socialLinks = document.querySelectorAll('.social-links a');
    socialLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
            window.open(link.href, "_blank");
        });
    });

    // 후기 삭제 링크 핸들링
    const reviewDeleteLink = document.querySelector('a[href="/review/admin/review/list"]');
    if (reviewDeleteLink) {
        reviewDeleteLink.addEventListener('click', function(e) {
            if (!confirm('후기 삭제 페이지로 이동하시겠습니까?')) {
                e.preventDefault();
            }
        });
    }
});
