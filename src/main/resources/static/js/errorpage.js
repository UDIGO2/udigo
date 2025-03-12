document.addEventListener('DOMContentLoaded', () => {
//---------------------------------------------------------------------------------------------------------
    // 카운트다운 타이머 설정
    // 설정한 시간 이후 자동으로 메인 페이지로 넘어가게 되는데 굳이 필요 없다고 판단되시면 지우셔도 됩니당 -수민
    let countdown = 5;
    const countdownElement = document.querySelector('.countdown');

    const timer = setInterval(() => {
        countdown--;
        if (countdown > 0) {
            countdownElement.textContent = `${countdown}초 후 메인 페이지로 이동합니다`;
        } else {
            clearInterval(timer);
            window.location.href = '/';
        }
    }, 1000);
//----------------------------------------------------------------------------------------------------------

    setInterval(() => {
        rotation += 360;
        animateNumber.style.transform = `rotateY(${rotation}deg)`;
    }, 4000);

    // 링크 아이템 호버 효과
    const linkItems = document.querySelectorAll('.link-item');

    linkItems.forEach(link => {
        link.addEventListener('mouseenter', () => {
            link.style.transform = 'translateY(-2px)';
        });

        link.addEventListener('mouseleave', () => {
            link.style.transform = 'translateY(0)';
        });
    });

    // 에러 아이콘 페이드인 효과
    const errorIcon = document.querySelector('.error-icon');
    errorIcon.style.opacity = '0';

    setTimeout(() => {
        errorIcon.style.opacity = '1';
    }, 100);
});