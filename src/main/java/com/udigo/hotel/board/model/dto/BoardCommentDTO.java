// src/main/java/com/udigo/hotel/board/model/dto/BoardCommentDTO.java
package com.udigo.hotel.board.model.dto;

import java.time.LocalDateTime;

public class BoardCommentDTO {
    private int commentId;
    private int postId;
    private String content;
    private LocalDateTime createdAt;

    public BoardCommentDTO() {
    }

    public BoardCommentDTO(int commentId, int postId, String content, LocalDateTime createdAt) {
        this.commentId = commentId;
        this.postId = postId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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

    @Override
    public String toString() {
        return "BoardCommentDTO{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}