document.addEventListener("DOMContentLoaded", function () {
    console.log("DOM 로드 완료! (header.js)");

    const navBar = document.querySelector(".h_navbar");
    const subMenus = document.querySelectorAll(".h_nav-links ul");
    const content = document.querySelector(".content");

    if (!navBar) {
        console.error("네비게이션 바(.h_navbar)를 찾을 수 없습니다.");
        return;
    }

    if (subMenus.length === 0) {
        console.warn("서브메뉴(.h_nav-links ul)가 없습니다.");
    }

    const dropdownBackground = document.createElement("div");
    dropdownBackground.classList.add("h_dropdown-background");
    document.body.appendChild(dropdownBackground);

    navBar.addEventListener("mouseenter", function () {
        dropdownBackground.style.display = "block";
        setTimeout(() => {
            dropdownBackground.classList.add("active");
        }, 50);

        subMenus.forEach(menu => {
            menu.style.display = "block";
            setTimeout(() => {
                menu.classList.add("active");
            }, 50);
        });

        if (content) {
            content.style.transition = "margin-top 0.3s ease"; // 애니메이션 추가
            content.style.marginTop = dropdownBackground.offsetHeight + 'px';
        }
    });

    navBar.addEventListener("mouseleave", function () {
        dropdownBackground.classList.remove("active");
        subMenus.forEach(menu => {
            menu.classList.remove("active");
        });

        setTimeout(() => {
            if (!navBar.matches(":hover")) {
                dropdownBackground.style.display = "none";
                subMenus.forEach(menu => {
                    menu.style.display = "none";
                });

                if (content) {
                    content.style.marginTop = '0';
                }
            }
        }, 300);
    });
});
