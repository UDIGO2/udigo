document.addEventListener("DOMContentLoaded", function () {
    console.log("📌 DOM 로드 완료! (header.js)");

    // 회원 데이터를 localStorage에 저장
    var memberDataElement = document.getElementById("memberData");
    if (memberDataElement) {
        var memberCode = memberDataElement.getAttribute("data-member-code");
        var memberId = memberDataElement.getAttribute("data-member-id");
        var memberName = memberDataElement.getAttribute("data-member-name");

        if (memberCode) {
            localStorage.setItem("memberCode", memberCode);
            localStorage.setItem("memberId", memberId);
            localStorage.setItem("memberName", memberName);
            console.log("✅ localStorage에 회원 정보 저장됨:", { memberCode, memberId, memberName });
        } else {
            console.warn("⚠️ memberCode가 존재하지 않음. localStorage에 저장되지 않음.");
        }
    } else {
        console.warn("⚠️ memberCode가 존재하지 않음. localStorage에 저장되지 않음.");
    }

    const navBar = document.querySelector(".h_navbar");
    const subMenus = document.querySelectorAll(".h_nav-links ul");
    const content = document.querySelector(".content");

    if (!navBar) {
        console.error("❌ 네비게이션 바(.h_navbar)를 찾을 수 없습니다.");
        return;
    }

    if (subMenus.length === 0) {
        console.warn("⚠️ 서브메뉴(.h_nav-links ul)가 없습니다.");
    }

    if (!content) {
        console.warn("⚠️ 콘텐츠 영역(.content)이 없습니다. margin-top 조정을 생략합니다.");
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
