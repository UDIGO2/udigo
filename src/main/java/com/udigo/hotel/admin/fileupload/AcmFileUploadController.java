package com.udigo.hotel.admin.fileupload;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

public class AcmFileUploadController {

    /**
     * 파일을 지정된 디렉토리에 저장하는 메소드
     *
     * @param fileDir 저장될 디렉토리 경로
     * @param fileName 저장될 파일 이름
     * @param file 업로드된 MultipartFile 객체
     * @return 저장된 파일 이름
     * @throws IOException 파일 저장 중 발생할 수 있는 예외 처리
     */
    public static String saveFile(String fileDir, String fileName, MultipartFile file)
            throws IOException {
        String projectPath = System.getProperty("user.dir");

        // 저장되는 경로 build 쪽의 new 폴더
        String buildPath = projectPath + "/build/resources/main/static/image/new";
        File dir = new File(buildPath);

        // 디렉토리가 존재하지 않으면 생성
        if (!dir.exists() && !dir.mkdirs()) {
            throw new IOException("디렉토리 생성 실패: " + buildPath);
        }

        // 원본 파일에서 확장자 추출
        String originFileName = file.getOriginalFilename();
        if (originFileName == null || !originFileName.contains(".")) {
            throw new IOException("잘못된 파일 형식입니다.");
        }

        String ext = originFileName.substring(originFileName.lastIndexOf("."));

        // 저장할 파일 이름 생성
        String savedFileName = fileName + ext;

        // 저장할 파일 경로
        File target = new File(dir, savedFileName);

        // 파일 저장
        file.transferTo(target);

        return savedFileName;
    }

    /**
     * 이미지 삭제 메소드
     *
     * @param fileName 삭제할 파일 이름
     * @return 삭제 성공 여부
     */
    public static boolean deleteFile(String fileName) {
        String projectPath = System.getProperty("user.dir");
        String buildPath = projectPath + "/build/resources/main/static/image/new/" + fileName;
        File file = new File(buildPath);
        return file.exists() && file.delete();
    }
} 