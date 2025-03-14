// src/main/java/com/udigo/hotel/board/model/dto/BoardPostDTO.java
package com.udigo.hotel.board.model.dto;

import java.time.LocalDateTime;

public class BoardPostDTO {
    private int postId;
    private int memberCode;
    private int boardType;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BoardPostDTO() {
    }

    public BoardPostDTO(int postId, int memberCode, int boardType, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.postId = postId;
        this.memberCode = memberCode;
        this.boardType = boardType;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;

    }

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

    @Override
    public String toString() {
        return "BoardPostDTO{" +
                "postId=" + postId +
                ", memberCode=" + memberCode +
                ", boardType=" + boardType +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}