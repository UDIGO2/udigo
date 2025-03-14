// src/main/java/com/udigo/hotel/board/model/service/BoardService.java
package com.udigo.hotel.board.model.service;

import com.udigo.hotel.board.model.dao.BoardPostMapper;
import com.udigo.hotel.board.model.dao.BoardCommentMapper;
import com.udigo.hotel.board.model.dto.BoardPostDTO;
import com.udigo.hotel.board.model.dto.BoardCommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardPostMapper boardPostMapper;

    @Autowired
    private BoardCommentMapper boardCommentMapper;

    public List<BoardPostDTO> getPostsByType(int boardType, int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        return boardPostMapper.findByBoardTypeWithPagination(boardType, offset, pageSize);
    }

    public int countPostsByType(int boardType) {
        return boardPostMapper.countByBoardType(boardType);
    }

    public void addPost(BoardPostDTO post) {
        boardPostMapper.insertPost(post);
    }

    public void updatePost(BoardPostDTO post) {
        boardPostMapper.updatePost(post);
    }

    public void deletePost(int postId) {
        boardPostMapper.deletePost(postId);
    }

    public void addComment(BoardCommentDTO comment) {
        boardCommentMapper.insertComment(comment);
    }

    public List<BoardCommentDTO> getCommentsByPostId(int postId) {
        return boardCommentMapper.findByPostId(postId);
    }
}