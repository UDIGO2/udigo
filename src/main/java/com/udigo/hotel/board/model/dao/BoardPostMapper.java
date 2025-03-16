// src/main/java/com/udigo/hotel/board/model/dao/BoardPostMapper.java
package com.udigo.hotel.board.model.dao;

import com.udigo.hotel.board.model.dto.BoardPostDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardPostMapper {
    List<BoardPostDTO> findByBoardTypeWithPagination(@Param("boardType") int boardType, @Param("offset") int offset, @Param("pageSize") int pageSize);
    int countByBoardType(int boardType);
    void insertPost(BoardPostDTO post);
    void updatePost(BoardPostDTO post);
    void deletePost(int postId);
    BoardPostDTO findById(int postId);
    List<BoardPostDTO> findByBoardTypeWithMemberAndPagination(@Param("boardType") int boardType, @Param("offset") int offset, @Param("pageSize") int pageSize);

    // 특정 회원의 특정 타입 게시글 조회
    List<BoardPostDTO> findByBoardTypeAndMember(@Param("boardType") int boardType,
                                                @Param("memberCode") int memberCode,
                                                @Param("offset") int offset,
                                                @Param("pageSize") int pageSize);

    // 특정 회원의 특정 타입 게시글 수 조회
    int countByBoardTypeAndMember(@Param("boardType") int boardType,
                                  @Param("memberCode") int memberCode);

}