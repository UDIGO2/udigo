package com.udigo.hotel.board.model.dao;

import com.udigo.hotel.board.model.dto.BoardCommentDTO;
import com.udigo.hotel.board.model.dto.BoardPostDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {
    // 게시글 조회 관련
    List<BoardPostDTO> getPostsByType(Map<String, Object> params);
    List<BoardPostDTO> getPostsByTypeWithMember(Map<String, Object> params);
    List<BoardPostDTO> getPostsWithComments(Map<String, Object> params);
    BoardPostDTO getPostById(int postId);

    // 게시글 수 카운트
    int countPostsByType(int boardType);
    int countPostsByTypeAndMember(Map<String, Object> params);

    // 게시글 CRUD
    void addPost(BoardPostDTO post);
    void updatePost(BoardPostDTO post);
    void deletePost(int postId);

    // 댓글 관련
    List<BoardCommentDTO> getCommentsByPostId(int postId);
    void addComment(BoardCommentDTO comment);
    void updateComment(BoardCommentDTO comment);
    void deleteComment(int commentId);
    void deleteCommentsByPostId(int postId);
}