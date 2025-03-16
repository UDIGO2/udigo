package com.udigo.hotel.board.model.service;

import com.udigo.hotel.board.model.dao.BoardMapper;
import com.udigo.hotel.board.model.dto.BoardPostDTO;
import com.udigo.hotel.board.model.dto.BoardCommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    public List<BoardPostDTO> getPostsByType(int boardType, int page, int pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("boardType", boardType);
        params.put("offset", (page - 1) * pageSize);
        params.put("pageSize", pageSize);
        return boardMapper.getPostsByType(params);
    }

    public List<BoardPostDTO> getPostsWithComments(int boardType, int memberCode, int offset, int pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("boardType", boardType);
        params.put("memberCode", memberCode);
        params.put("offset", offset);
        params.put("pageSize", pageSize);

        List<BoardPostDTO> posts = boardMapper.getPostsWithComments(params);

        if (posts != null) {
            for (BoardPostDTO post : posts) {
                if (post.getComment() != null && post.getComment().getCommentId() == 0) {
                    post.setComment(null);
                }
            }
        }

        return posts;
    }

    public List<BoardPostDTO> getPostsByTypeWithMember(int boardType, int page, int pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("boardType", boardType);
        params.put("offset", (page - 1) * pageSize);
        params.put("pageSize", pageSize);
        return boardMapper.getPostsByTypeWithMember(params);
    }

    public int countPostsByType(int boardType) {
        return boardMapper.countPostsByType(boardType);
    }

    public int countPostsByTypeAndMember(int boardType, int memberCode) {
        Map<String, Object> params = new HashMap<>();
        params.put("boardType", boardType);
        params.put("memberCode", memberCode);
        return boardMapper.countPostsByTypeAndMember(params);
    }

    @Transactional
    public void addPost(BoardPostDTO post) {
        boardMapper.addPost(post);
    }

    public BoardPostDTO getPostById(int postId) {
        return boardMapper.getPostById(postId);
    }

    @Transactional
    public void updatePost(BoardPostDTO post) {
        boardMapper.updatePost(post);
    }

    @Transactional
    public void deletePost(int postId) {
        // 게시글 삭제 전 관련 댓글 삭제
        boardMapper.deleteCommentsByPostId(postId);
        boardMapper.deletePost(postId);
    }

    public List<BoardCommentDTO> getCommentsByPostId(int postId) {
        return boardMapper.getCommentsByPostId(postId);
    }

    @Transactional
    public void addComment(BoardCommentDTO comment) {
        boardMapper.addComment(comment);
    }

    @Transactional
    public void updateComment(BoardCommentDTO comment) {
        boardMapper.updateComment(comment);
    }

    @Transactional
    public void deleteComment(int commentId) {
        boardMapper.deleteComment(commentId);
    }
}