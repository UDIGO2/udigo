// DOM Elements
document.addEventListener('DOMContentLoaded', function() {
    // Navigation handling
    const navLinks = document.querySelectorAll('.nav-links a');
    navLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
            // Add navigation logic here
        });
    });

    // Member information link
    const memberInfoLink = document.querySelector('.member-section .full-width-link');
    if (memberInfoLink) {
        memberInfoLink.addEventListener('click', (e) => {
            e.preventDefault();
            // Add member information handling logic here
        });
    }

    // Reservation links
    const reservationLinks = document.querySelectorAll('.reservation-links a');
    reservationLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
            // Add reservation handling logic here
        });
    });

    // Accommodation links
    const accommodationLinks = document.querySelectorAll('.accommodation-links a');
    accommodationLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
            // Add accommodation handling logic here
            const action = link.textContent.trim();
            switch(action) {
                case '숙소 정보 관리 >':
                    // Handle accommodation management
                    break;
                case '숙소 정보 수정 >':
                    // Handle accommodation edit
                    break;
                case '숙소 등록 >':
                    // Handle accommodation registration
                    break;
                case '숙소 정보 삭제 >':
                    // Handle accommodation deletion
                    break;
                case '숙소 후기 삭제 >':
                    // Handle review deletion
                    break;
            }
        });
    });

    // Logout handling
    const logoutLink = document.querySelector('.logout');
    if (logoutLink) {
        logoutLink.addEventListener('click', (e) => {
            e.preventDefault();
            if (confirm('로그아웃 하시겠습니까?')) {
                // Add logout logic here
                console.log('Logging out...');
            }
        });
    }

    // Social media links
    const socialLinks = document.querySelectorAll('.social-links a');
    socialLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
            // Add social media link handling here
        });
    });
});