document.addEventListener("DOMContentLoaded", function () {
    const navBar = document.querySelector(".navbar");
    const subMenus = document.querySelectorAll(".nav-links ul");

    const dropdownBackground = document.createElement("div");
    dropdownBackground.classList.add("dropdown-background");

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
            }
        }, 300); // 애니메이션 지속 시간과 동일하게 설정함.
    });
});
// 헤더 여기까지

