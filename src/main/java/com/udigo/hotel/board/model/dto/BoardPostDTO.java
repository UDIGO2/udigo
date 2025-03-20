package com.udigo.hotel.board.model.dto;

import java.time.LocalDateTime;
/**
 * 게시글 정보를 담는 DTO 클래스
 *.
 * 필드:
 * - postId: 게시글 ID
 * - memberCode: 작성자 회원 코드
 * - boardType: 게시판 타입 (1: 공지사항, 2: FAQ, 3: 1:1 문의)
 * - title: 제목
 * - content: 내용
 * - createdAt: 작성일시
 * - updatedAt: 수정일시
 * - memberName: 작성자 이름 (JOIN 조회시 사용)
 * - comment: 답변 정보 (1:1 문의 답변)
 */
public class BoardPostDTO {
    private int postId;
    private int memberCode;
    private int boardType;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String memberName;
    private BoardCommentDTO comment;

    // Getters and Setters
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public int getBoardType() {
        return boardType;
    }

    public void setBoardType(int boardType) {
        this.boardType = boardType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public BoardCommentDTO getComment() {
        return comment;
    }

    public void setComment(BoardCommentDTO comment) {
        this.comment = comment;
    }

    // 답변 여부 확인 메소드(HTML 템플릿에서 사용)
    public boolean hasComment() {
        return comment != null;
    }
}
