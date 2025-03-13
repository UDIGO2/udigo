document.addEventListener('DOMContentLoaded', function() {
    // 좋아요 버튼 기능
    const likeBtns = document.querySelectorAll('.like-btn');
    likeBtns.forEach(btn => {
        btn.addEventListener('click', function() {
            const icon = this.querySelector('i');
            icon.classList.toggle('far');
            icon.classList.toggle('fas');
        });
    });

    // 검색 기능
    const searchBtn = document.querySelector('.search-btn');
    searchBtn.addEventListener('click', function() {
        // 검색 로직 구현
        const location = document.querySelector('.search-item:nth-child(1) input').value;
        const date = document.querySelector('.search-item:nth-child(2) input').value;
        const guests = document.querySelector('.search-item:nth-child(3) input').value;

        console.log('검색:', { location, date, guests });
    });

    // 호텔 데이터 로드 (예시)
    const hotels = [
        {
            name: '한남동 어디고호텔 HOTEL',
            image: 'hotel-room.jpg',
            capacity: '성인 기준 2인 / 최대 3인',
            bed: '디럴 럭셔리, 2층 침대 1개',
            price: '230,000'
        },
        // 추가 호텔 데이터...
    ];

    // 호텔 카드 생성
    const hotelGrid = document.querySelector('.hotel-grid');
    hotels.forEach(hotel => {
        const card = createHotelCard(hotel);
        hotelGrid.appendChild(card);
    });

    // 이미지 업로드 미리보기 기능
    function handleImageUpload(input, previewContainer) {
        input.addEventListener('change', function(e) {
            const files = e.target.files;

            // 파일 크기 체크 (5MB 제한)
            for (let file of files) {
                if (file.size > 5 * 1024 * 1024) {
                    alert('파일 크기는 5MB를 초과할 수 없습니다.');
                    input.value = '';
                    return;
                }
            }

            // 이미지 미리보기 생성
            const placeholder = input.parentElement.querySelector('.upload-placeholder');
            if (files.length > 0) {
                placeholder.innerHTML = `<i class="fas fa-check"></i><p>${files.length}개의 파일이 선택됨</p>`;
            } else {
                placeholder.innerHTML = `<i class="fas fa-plus"></i><p>이미지 추가</p>`;
            }
        });
    }

    // 메인 이미지 업로드 처리
    const mainImageInput = document.getElementById('main-image');
    if (mainImageInput) {
        handleImageUpload(mainImageInput);
    }

    // 추가 이미지 업로드 처리
    const subImagesInput = document.querySelector('.sub-images-upload input[type="file"]');
    if (subImagesInput) {
        handleImageUpload(subImagesInput);
    }

    // 폼 제출 처리
    const form = document.querySelector('.registration-form');
    if (form) {
        form.addEventListener('submit', function(e) {
            e.preventDefault();

            // 필수 필드 검증
            const requiredFields = form.querySelectorAll('[required]');
            let isValid = true;

            requiredFields.forEach(field => {
                if (!field.value.trim()) {
                    isValid = false;
                    field.classList.add('error');
                } else {
                    field.classList.remove('error');
                }
            });

            if (!isValid) {
                alert('필수 항목을 모두 입력해주세요.');
                return;
            }

            // 여기에 폼 제출 로직 추가
            const formData = new FormData(form);
            console.log('폼 데이터:', Object.fromEntries(formData));

            // API 호출 예시
            // fetch('/api/accommodations', {
            //     method: 'POST',
            //     body: formData
            // })
            // .then(response => response.json())
            // .then(data => {
            //     alert('숙소가 성공적으로 등록되었습니다.');
            //     window.location.href = '/accommodations';
            // })
            // .catch(error => {
            //     console.error('Error:', error);
            //     alert('등록 중 오류가 발생했습니다.');
            // });
        });
    }

    // 전화번호 형식 자동 포매팅
    const phoneInput = document.getElementById('phone');
    if (phoneInput) {
        phoneInput.addEventListener('input', function(e) {
            let value = e.target.value.replace(/\D/g, '');
            if (value.length > 3 && value.length <= 7) {
                value = value.slice(0,3) + '-' + value.slice(3);
            } else if (value.length > 7) {
                value = value.slice(0,3) + '-' + value.slice(3,7) + '-' + value.slice(7,11);
            }
            e.target.value = value;
        });
    }
});

function createHotelCard(hotel) {
    const card = document.createElement('div');
    card.className = 'hotel-card';
    card.innerHTML = `
        <img src="images/${hotel.image}" alt="${hotel.name}">
        <div class="hotel-info">
            <h3>${hotel.name}</h3>
            <p>${hotel.capacity}</p>
            <p>${hotel.bed}</p>
            <div class="price-like">
                <span class="price">${hotel.price} 원</span>
                <button class="like-btn"><i class="far fa-heart"></i></button>
            </div>
        </div>
    `;
    return card;
}