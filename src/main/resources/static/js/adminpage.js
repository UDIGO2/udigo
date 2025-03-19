document.addEventListener("DOMContentLoaded", function () {
    // 로그인 상태 확인 및 관리자 정보 표시
    let memberCode = localStorage.getItem("memberCode");
    let memberId = localStorage.getItem("memberId");
    let memberName = localStorage.getItem("memberName");

    if (memberCode && memberId) {
        console.log(`✅ 현재 로그인된 관리자: ${memberId} (코드: ${memberCode})`);
        
        // 관리자 정보 표시 업데이트
        const adminInfoElement = document.querySelector('.admin-info h2');
        if (adminInfoElement) {
            adminInfoElement.textContent = `${memberId}님`;
        }
    } else {
        console.log("❌ 로그인되지 않음.");
    }

    // DOM Elements
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
                case '숙소 등록 >':
                    window.location.href = "/admin/acm/register";
                    break;
                case '숙소 후기 삭제 >':
                    window.location.href = "/review/admin/review/list";
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

    // ✅ Review delete link handling
    const reviewDeleteLink = document.querySelector('a[href="/review/admin/review/list"]');
    if (reviewDeleteLink) {
        reviewDeleteLink.addEventListener('click', function(e) {
            if (!confirm('후기 삭제 페이지로 이동하시겠습니까?')) {
                e.preventDefault();
            }
        });
    }
});
