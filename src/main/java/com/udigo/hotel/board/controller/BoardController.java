// src/main/java/com/udigo/hotel/board/controller/BoardController.java
package com.udigo.hotel.board.controller;

import com.udigo.hotel.board.model.dto.BoardPostDTO;
import com.udigo.hotel.board.model.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/notice")
    public String getNoticePage(@RequestParam(defaultValue = "1") int page, Model model) {
        int pageSize = 10;
        List<BoardPostDTO> posts = boardService.getPostsByType(1, page, pageSize);
        int totalPosts = boardService.countPostsByType(1);
        int totalPages = (int) Math.ceil((double) totalPosts / pageSize);

        model.addAttribute("posts", posts);
        model.addAttribute("totalPages", totalPages);
        return "board/notice";
    }

    @GetMapping("/FAQ")
    public String getFAQPage(@RequestParam(defaultValue = "1") int page, Model model) {
        int pageSize = 10;
        List<BoardPostDTO> posts = boardService.getPostsByType(2, page, pageSize);
        int totalPosts = boardService.countPostsByType(2);
        int totalPages = (int) Math.ceil((double) totalPosts / pageSize);

        model.addAttribute("posts", posts);
        model.addAttribute("totalPages", totalPages);
        return "board/faq";
    }

    @GetMapping("/ask")
    public String getAskPage(@RequestParam(defaultValue = "1") int page, Model model) {
        int pageSize = 10;
        List<BoardPostDTO> posts = boardService.getPostsByType(3, page, pageSize);
        int totalPosts = boardService.countPostsByType(3);
        int totalPages = (int) Math.ceil((double) totalPosts / pageSize);

        model.addAttribute("posts", posts);
        model.addAttribute("totalPages", totalPages);
        return "board/ask";
    }
}