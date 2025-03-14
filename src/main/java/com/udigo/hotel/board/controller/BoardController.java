// src/main/java/com/udigo/hotel/board/controller/BoardController.java
package com.udigo.hotel.board.controller;

import com.udigo.hotel.board.model.dto.BoardCommentDTO;
import com.udigo.hotel.board.model.dto.BoardPostDTO;
import com.udigo.hotel.board.model.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return "board/FAQ";
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

    // 관리자 공지사항 페이지
    @GetMapping("/admin/notice")
    public String getAdminNoticePage(@RequestParam(defaultValue = "1") int page, Model model) {
        // 관리자 권한 체크 로직 추가 필요
        int pageSize = 10;
        List<BoardPostDTO> posts = boardService.getPostsByType(1, page, pageSize);
        int totalPosts = boardService.countPostsByType(1);
        int totalPages = (int) Math.ceil((double) totalPosts / pageSize);

        model.addAttribute("posts", posts);
        model.addAttribute("totalPages", totalPages);
        return "board/admin/notice";
    }

    // 관리자 FAQ 페이지
    @GetMapping("/admin/FAQ")
    public String getAdminFAQPage(@RequestParam(defaultValue = "1") int page, Model model) {
        // 관리자 권한 체크 로직 추가 필요
        int pageSize = 10;
        List<BoardPostDTO> posts = boardService.getPostsByType(2, page, pageSize);
        int totalPosts = boardService.countPostsByType(2);
        int totalPages = (int) Math.ceil((double) totalPosts / pageSize);

        model.addAttribute("posts", posts);
        model.addAttribute("totalPages", totalPages);
        return "board/admin/FAQ";
    }

    // 게시글 추가 페이지
    @GetMapping("/admin/post/add")
    public String getAddPostPage(Model model) {
        model.addAttribute("post", new BoardPostDTO());
        return "board/admin/post/addPost";
    }

    // 게시글 추가 처리
    @PostMapping("/admin/post/add")
    public String addPost(@ModelAttribute BoardPostDTO post) {
        post.setMemberCode(1); // 관리자 코드 설정
        post.setCreatedAt(LocalDateTime.now());
        boardService.addPost(post);
        
        // 게시글 타입에 따라 리다이렉트 페이지 결정
        if (post.getBoardType() == 1) {
            return "redirect:/board/admin/notice";
        } else {
            return "redirect:/board/admin/FAQ";
        }
    }

    // 게시글 수정 페이지
    @GetMapping("/admin/post/edit/{postId}")
    public String getEditPostPage(@PathVariable int postId, Model model) {
        BoardPostDTO post = boardService.getPostById(postId);
        model.addAttribute("post", post);
        return "board/admin/post/editPost";
    }

    // 게시글 수정 처리
    // 게시글 수정 처리
    @PostMapping("/admin/post/edit")
    public String editPost(@RequestParam int postId,
                           @RequestParam int memberCode,
                           @RequestParam String createdAt,
                           @RequestParam int boardType,
                           @RequestParam String title,
                           @RequestParam String content) {

        BoardPostDTO post = new BoardPostDTO();
        post.setPostId(postId);
        post.setMemberCode(memberCode);
        post.setCreatedAt(LocalDateTime.parse(createdAt));
        post.setBoardType(boardType);
        post.setTitle(title);
        post.setContent(content);
        post.setUpdatedAt(LocalDateTime.now());

        boardService.updatePost(post);

        // 게시글 타입에 따라 리다이렉트 페이지 결정
        if (boardType == 1) {
            return "redirect:/board/admin/notice";
        } else {
            return "redirect:/board/admin/FAQ";
        }
    }

    // 게시글 삭제 처리
    @PostMapping("/admin/post/delete")
    public String deletePost(@RequestParam int postId, @RequestParam int boardType) {
        boardService.deletePost(postId);
        
        // 게시글 타입에 따라 리다이렉트 페이지 결정
        if (boardType == 1) {
            return "redirect:/board/admin/notice";
        } else if (boardType == 2) {
            return "redirect:/board/admin/FAQ";
        } else {
            return "redirect:/board/admin/ask";
        }

    }


    // 관리자 1대1 문의 페이지
    @GetMapping("/admin/ask")
    public String getAdminAskPage(@RequestParam(defaultValue = "1") int page, Model model) {
        // 관리자 권한 체크 로직 추가 필요
        int pageSize = 10;
        List<BoardPostDTO> posts = boardService.getPostsByTypeWithMember(3, page, pageSize);
        int totalPosts = boardService.countPostsByType(3);
        int totalPages = (int) Math.ceil((double) totalPosts / pageSize);

        // 각 게시글에 대한 댓글(답변) 여부 확인 및 댓글 목록 준비
        Map<Integer, Boolean> hasCommentMap = new HashMap<>();
        Map<Integer, List<BoardCommentDTO>> commentsMap = new HashMap<>();

        for (BoardPostDTO post : posts) {
            List<BoardCommentDTO> comments = boardService.getCommentsByPostId(post.getPostId());
            hasCommentMap.put(post.getPostId(), !comments.isEmpty());
            commentsMap.put(post.getPostId(), comments);
        }

        model.addAttribute("posts", posts);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("hasCommentMap", hasCommentMap);
        model.addAttribute("commentsMap", commentsMap);
        return "board/admin/ask";
    }

    // 답변 작성 페이지
    @GetMapping("/admin/comment/add/{postId}")
    public String getAddCommentPage(@PathVariable int postId, Model model) {
        BoardPostDTO post = boardService.getPostById(postId);
        BoardCommentDTO comment = new BoardCommentDTO();
        comment.setPostId(postId);

        model.addAttribute("post", post);
        model.addAttribute("comment", comment);
        return "board/admin/post/addComment";
    }

    // 답변 작성 처리
    @PostMapping("/admin/comment/add")
    public String addComment(@ModelAttribute BoardCommentDTO comment) {
        comment.setCreatedAt(LocalDateTime.now());
        boardService.addComment(comment);
        return "redirect:/board/admin/ask";
    }
}