// 파일 크기 제한 (5MB)
const MAX_FILE_SIZE = 5 * 1024 * 1024;

// 파일 크기 검증
function validateFileSize(input) {
    const file = input.files[0];
    const previewId = input.id.replace('photo', 'preview');
    const preview = document.getElementById(previewId);

    // 파일이 선택되지 않은 경우
    if (!file) {
        preview.innerHTML = '<div class="upload-icon">+</div>';
        return true;
    }

    // 파일 크기 검증
    if (file.size > MAX_FILE_SIZE) {
        alert('파일 크기는 5MB를 초과할 수 없습니다.');
        input.value = '';
        preview.innerHTML = '<div class="upload-icon">+</div>';
        return false;
    }

    // 이미지 미리보기
    const reader = new FileReader();
    reader.onload = function(e) {
        preview.innerHTML = `<img src="${e.target.result}" alt="미리보기">`;
    };
    reader.readAsDataURL(file);
    return true;
}

// 폼 전체 검증
function validateForm() {
    const form = document.getElementById('acmForm');
    const requiredFields = form.querySelectorAll('[required]');
    
    // 필수 필드 검증
    for (const field of requiredFields) {
        if (!field.value) {
            alert('모든 필수 항목을 입력해주세요.');
            field.focus();
            return false;
        }
    }

    // 전화번호 형식 검증
    const phone = document.getElementById('acmPhone');
    const phoneRegex = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$/;
    if (!phoneRegex.test(phone.value)) {
        alert('올바른 전화번호 형식을 입력해주세요. (예: 02-123-4567 또는 010-1234-5678)');
        phone.focus();
        return false;
    }

    // 파일 개수 검증
    const photos = form.querySelectorAll('input[type="file"]');
    let photoCount = 0;
    for (const photo of photos) {
        if (photo.files.length > 0) {
            photoCount++;
        }
    }
    if (photoCount === 0) {
        alert('최소 1장의 사진을 업로드해주세요.');
        return false;
    }
    if (photoCount > 5) {
        alert('최대 5장의 사진만 업로드할 수 있습니다.');
        return false;
    }

    return true;
}

// 전화번호 자동 하이픈 추가
document.getElementById('acmPhone').addEventListener('input', function(e) {
    let value = e.target.value.replace(/[^0-9]/g, '');
    
    if (value.length > 11) {
        value = value.slice(0, 11);
    }
    
    if (value.length === 11) {
        value = value.replace(/(\d{3})(\d{4})(\d{4})/, '$1-$2-$3');
    } else if (value.length === 10) {
        value = value.replace(/(\d{2})(\d{4})(\d{4})/, '$1-$2-$3');
    } else if (value.length === 9) {
        value = value.replace(/(\d{2})(\d{3})(\d{4})/, '$1-$2-$3');
    }
    
    e.target.value = value;
}); 