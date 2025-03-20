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
/*
 * 게시판 관련 비즈니스 로직을 처리하는 서비스 클래스
 * 게시글 및 댓글의 조회, 추가, 수정, 삭제 기능 제공
 */
@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    /*
     * 게시판 유형별 게시글 목록을 페이지네이션하여 조회
     *
     * @param boardType 게시판 유형 (1: 공지사항, 2: FAQ, 3: 1:1문의)
     * @param page 현재 페이지 번호
     * @param pageSize 페이지당 게시글 수
     * @return 게시글 목록
     */
    public List<BoardPostDTO> getPostsByType(int boardType, int page, int pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("boardType", boardType);
        params.put("offset", (page - 1) * pageSize);
        params.put("pageSize", pageSize);
        return boardMapper.getPostsByType(params);
    }


    /*
     * 특정 회원의 1:1 문의 게시글과 그에 대한 답변을 함께 조회
     *
     * @param boardType 게시판 유형 (주로 3: 1:1문의)
     * @param memberCode 회원 코드
     * @param offset 시작 위치
     * @param pageSize 조회할 게시글 수
     * @return 게시글과 답변이 함께 포함된 목록
     */
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

    /*
     * 게시판 유형별 게시글을 작성자 정보와 함께 조회 (관리자용)
     *
     * @param boardType 게시판 유형
     * @param page 현재 페이지
     * @param pageSize 페이지당 게시글 수
     * @return 작성자 정보가 포함된 게시글 목록
     */
    public List<BoardPostDTO> getPostsByTypeWithMember(int boardType, int page, int pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("boardType", boardType);
        params.put("offset", (page - 1) * pageSize);
        params.put("pageSize", pageSize);
        return boardMapper.getPostsByTypeWithMember(params);
    }
    /*
     * 게시판 유형별 전체 게시글 수 조회
     *
     * @param boardType 게시판 유형
     * @return 게시글 수
     */
    public int countPostsByType(int boardType) {
        return boardMapper.countPostsByType(boardType);
    }
    /*
     * 게시판 유형별 전체 게시글 수 조회
     *
     * @param boardType 게시판 유형
     * @return 게시글 수
     */
    public int countPostsByTypeAndMember(int boardType, int memberCode) {
        Map<String, Object> params = new HashMap<>();
        params.put("boardType", boardType);
        params.put("memberCode", memberCode);
        return boardMapper.countPostsByTypeAndMember(params);
    }
    /*
     * 새 게시글 추가
     *
     * @param post 추가할 게시글 정보
     */
    @Transactional
    public void addPost(BoardPostDTO post) {
        boardMapper.addPost(post);
    }
    /*
     * 게시글 ID로 게시글 조회
     *
     * @param postId 게시글 ID
     * @return 게시글 정보
     */
    public BoardPostDTO getPostById(int postId) {
        return boardMapper.getPostById(postId);
    }
    /*
     * 게시글 정보 수정
     *
     * @param post 수정할 게시글 정보
     */
    @Transactional
    public void updatePost(BoardPostDTO post) {
        boardMapper.updatePost(post);
    }
    /*
     * 게시글 삭제 (연관된 댓글도 함께 삭제)
     *
     * @param postId 삭제할 게시글 ID
     */
    @Transactional
    public void deletePost(int postId) {
        // 게시글 삭제 전 관련 댓글 삭제
        boardMapper.deleteCommentsByPostId(postId);
        boardMapper.deletePost(postId);
    }
    /*
     * 게시글에 달린 댓글 목록 조회
     *
     * @param postId 게시글 ID
     * @return 댓글 목록
     */
    public List<BoardCommentDTO> getCommentsByPostId(int postId) {
        return boardMapper.getCommentsByPostId(postId);
    }
    /*
     * 댓글 추가 (1:1 문의 답변용)
     *
     * @param comment 추가할 댓글 정보
     */
    @Transactional
    public void addComment(BoardCommentDTO comment) {
        boardMapper.addComment(comment);
    }

}