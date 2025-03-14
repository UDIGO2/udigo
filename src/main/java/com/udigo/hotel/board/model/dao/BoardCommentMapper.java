// src/main/java/com/udigo/hotel/board/model/dao/BoardCommentMapper.java
package com.udigo.hotel.board.model.dao;

import com.udigo.hotel.board.model.dto.BoardCommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardCommentMapper {
    void insertComment(BoardCommentDTO comment);
    List<BoardCommentDTO> findByPostId(int postId);
}