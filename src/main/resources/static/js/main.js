document.addEventListener("DOMContentLoaded", function () {
    const navBar = document.querySelector(".nav-links");
    const subMenus = document.querySelectorAll(".nav-links ul");

    // 배경이 전체 너비로 확장될 컨테이너 생성
    const dropdownBackground = document.createElement("div");
    dropdownBackground.classList.add("dropdown-background");

    // 네비게이션 바 바로 아래에 배경 추가
    navBar.appendChild(dropdownBackground);

    navBar.addEventListener("mouseenter", function () {
        dropdownBackground.style.display = "block";
        subMenus.forEach(menu => {
            menu.style.display = "block";
        });
    });

    navBar.addEventListener("mouseleave", function () {
        dropdownBackground.style.display = "none";
        subMenus.forEach(menu => {
            menu.style.display = "none";
        });
    });
});
