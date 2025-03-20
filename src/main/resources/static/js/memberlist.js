document.addEventListener("DOMContentLoaded", function () {
    fetch('/admin/api/members')
        .then(response => {
            if (!response.ok) {
                throw new Error("서버 응답이 실패했습니다.");
            }
            return response.json();
        })
        .then(data => {
            populateMemberTable(data);
        })
        .catch(error => {
            console.error("회원 목록을 불러오는 중 오류 발생:", error);
        });
});

/**
 * 회원 목록을 테이블에 추가하는 함수
 * @param {Array} members - 회원 목록 데이터
 */
function populateMemberTable(members) {
    const tableBody = document.querySelector("#memberTable tbody");
    tableBody.innerHTML = "";

    members.forEach((member, index) => {
        const row = document.createElement("tr");

        row.innerHTML = `
            <td>${index + 1}</td>
            <td>${member.memberId}</td>
            <td>${member.memberName}</td>
            <td>${member.joinDate}</td>
            <td>
                <a href="/member/admin/detail/${member.memberId}" class="btn-detail">상세조회</a>
            </td>
        `;

        tableBody.appendChild(row);
    });
}
