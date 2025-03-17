// src/main/resources/static/js/header.js
document.addEventListener("DOMContentLoaded", function () {
    const navBar = document.querySelector(".h_navbar");
    const subMenus = document.querySelectorAll(".h_nav-links ul");
    const content = document.querySelector(".content");

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

        // 메뉴가 열릴 때 content 아래로 밀기
        content.style.transition = "margin-top 0.3s ease"; // 애니메이션 추가
        // content.style.marginTop = dropdownBackground.offsetHeight + 'px';
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

                // 메뉴가 닫힐 때 content 원래 위치로
                content.style.marginTop = '0';
            }
        }, 300);
    });
});