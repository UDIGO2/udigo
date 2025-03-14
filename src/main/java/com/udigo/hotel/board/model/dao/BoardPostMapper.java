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
}