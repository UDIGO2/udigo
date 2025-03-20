/*
 * 게시판 관련 요청을 처리하는 컨트롤러
 * 공지사항, FAQ, 1:1 문의 게시판 기능과 관리자용 게시판 관리 기능 제공
 */
package com.udigo.hotel.board.controller;

import com.udigo.hotel.board.model.dto.BoardCommentDTO;
import com.udigo.hotel.board.model.dto.BoardPostDTO;
import com.udigo.hotel.board.model.service.BoardService;
import com.udigo.hotel.member.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    /*
     * 현재 로그인한 사용자가 관리자인지 확인
     *
     * @return 관리자면 true, 아니면 false
     */
    private boolean isAdmin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            return "ADMIN".equals(userDetails.getRole());
        }
        return false;
    }

    /*
     * 공지사항 페이지 요청 처리
     * 관리자인 경우 관리자용 공지사항 페이지로 리다이렉트
     *
     * @param page 페이지 번호
     * @param model 뷰에 전달할 데이터
     * @return 뷰 이름
     */
    @GetMapping("/notice")
    public String getNoticePage(@RequestParam(defaultValue = "1") int page, Model model) {
        if (isAdmin()) {
            return "redirect:/board/admin/notice";
        }

        int pageSize = 10;
        List<BoardPostDTO> posts = boardService.getPostsByType(1, page, pageSize);
        int totalPosts = boardService.countPostsByType(1);
        int totalPages = (int) Math.ceil((double) totalPosts / pageSize);

        model.addAttribute("posts", posts);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);
        return "board/notice";
    }

    /*
     * FAQ 페이지 요청 처리
     * 관리자인 경우 관리자용 FAQ 페이지로 리다이렉트
     *
     * @param page 페이지 번호
     * @param model 뷰에 전달할 데이터
     * @return 뷰 이름
     */
    @GetMapping("/FAQ")
    public String getFAQPage(@RequestParam(defaultValue = "1") int page, Model model) {
        if (isAdmin()) {
            return "redirect:/board/admin/FAQ";
        }

        int pageSize = 10;
        List<BoardPostDTO> posts = boardService.getPostsByType(2, page, pageSize);
        int totalPosts = boardService.countPostsByType(2);
        int totalPages = (int) Math.ceil((double) totalPosts / pageSize);

        model.addAttribute("posts", posts);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);
        return "board/FAQ";
    }

    /*
     * 1:1 문의 페이지 요청 처리
     * 로그인한 사용자의 문의 내역과 답변을 함께 표시
     * 관리자인 경우 관리자용 문의 관리 페이지로 리다이렉트
     *
     * @param page 페이지 번호
     * @param model 뷰에 전달할 데이터
     * @return 뷰 이름
     */
    @GetMapping("/ask")
    public String getAskPage(@RequestParam(defaultValue = "1") int page, Model model) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (!(auth.getPrincipal() instanceof CustomUserDetails)) {
                return "redirect:/auth/login";
            }

            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();

            if ("ADMIN".equals(userDetails.getRole())) {
                return "redirect:/board/admin/ask";
            }

            int memberCode = userDetails.getMemberCode();
            int pageSize = 10;

            int totalPosts = boardService.countPostsByTypeAndMember(3, memberCode);
            int totalPages = totalPosts == 0 ? 1 : (int) Math.ceil((double) totalPosts / pageSize);

            if (page > totalPages) {
                page = totalPages;
            }

            List<BoardPostDTO> posts = boardService.getPostsWithComments(3, memberCode, (page - 1) * pageSize, pageSize);

            model.addAttribute("posts", posts);
            model.addAttribute("totalPages", totalPages);
            model.addAttribute("currentPage", page);
            model.addAttribute("hasInquiries", !posts.isEmpty());

            return "board/ask";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/auth/login";
        }
    }

    /*
     * 1:1 문의 작성 페이지 요청 처리
     *
     * @param model 뷰에 전달할 데이터
     * @return 뷰 이름
     */
    @GetMapping("/ask/write")
    public String getWriteInquiryPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth.getPrincipal() instanceof CustomUserDetails)) {
            return "redirect:/auth/login";
        }

        model.addAttribute("post", new BoardPostDTO());
        return "board/ask/write";
    }

    /*
     * 1:1 문의 작성 처리
     *
     * @param post 작성할 문의 정보
     * @return 리다이렉트 경로
     */
    @PostMapping("/ask/write")
    public String writeInquiry(@ModelAttribute BoardPostDTO post) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (!(auth.getPrincipal() instanceof CustomUserDetails)) {
                return "redirect:/auth/login";
            }

            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            post.setMemberCode(userDetails.getMemberCode());
            post.setBoardType(3); // 1:1 문의
            post.setCreatedAt(LocalDateTime.now());

            boardService.addPost(post);

            return "redirect:/board/ask";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/board/ask";
        }
    }

    /*
     * 관리자용 공지사항 관리 페이지 요청 처리
     * 관리자만 접근 가능
     *
     * @param page 페이지 번호
     * @param model 뷰에 전달할 데이터
     * @return 뷰 이름
     */
    @GetMapping("/admin/notice")
    public String getAdminNoticePage(@RequestParam(defaultValue = "1") int page, Model model) {
        if (!isAdmin()) {
            return "redirect:/board/notice";
        }

        int pageSize = 10;
        List<BoardPostDTO> posts = boardService.getPostsByType(1, page, pageSize);
        int totalPosts = boardService.countPostsByType(1);
        int totalPages = (int) Math.ceil((double) totalPosts / pageSize);

        model.addAttribute("posts", posts);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);
        return "board/admin/notice";
    }

    /*
     * 관리자용 FAQ 관리 페이지 요청 처리
     * 관리자만 접근 가능
     *
     * @param page 페이지 번호
     * @param model 뷰에 전달할 데이터
     * @return 뷰 이름
     */
    @GetMapping("/admin/FAQ")
    public String getAdminFAQPage(@RequestParam(defaultValue = "1") int page, Model model) {
        if (!isAdmin()) {
            return "redirect:/board/FAQ";
        }

        int pageSize = 10;
        List<BoardPostDTO> posts = boardService.getPostsByType(2, page, pageSize);
        int totalPosts = boardService.countPostsByType(2);
        int totalPages = (int) Math.ceil((double) totalPosts / pageSize);

        model.addAttribute("posts", posts);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);
        return "board/admin/FAQ";
    }

    /*
     * 관리자용 1:1 문의 관리 페이지 요청 처리
     * 모든 회원의 문의와 답변 상태를 표시
     * 관리자만 접근 가능
     *
     * @param page 페이지 번호
     * @param model 뷰에 전달할 데이터
     * @return 뷰 이름
     */
    @GetMapping("/admin/ask")
    public String getAdminAskPage(@RequestParam(defaultValue = "1") int page, Model model) {
        if (!isAdmin()) {
            return "redirect:/board/ask";
        }

        int pageSize = 10;
        List<BoardPostDTO> posts = boardService.getPostsByTypeWithMember(3, page, pageSize);
        int totalPosts = boardService.countPostsByType(3);
        int totalPages = (int) Math.ceil((double) totalPosts / pageSize);

        // 각 게시글의 댓글 정보 확인
        Map<Integer, Boolean> hasCommentMap = new HashMap<>();
        Map<Integer, List<BoardCommentDTO>> commentsMap = new HashMap<>();

        for (BoardPostDTO post : posts) {
            List<BoardCommentDTO> comments = boardService.getCommentsByPostId(post.getPostId());
            hasCommentMap.put(post.getPostId(), !comments.isEmpty());
            commentsMap.put(post.getPostId(), comments);
        }

        model.addAttribute("posts", posts);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);
        model.addAttribute("hasCommentMap", hasCommentMap);
        model.addAttribute("commentsMap", commentsMap);

        return "board/admin/ask";
    }

    /*
     * 관리자용 게시글 추가 페이지 요청 처리
     *
     * @param model 뷰에 전달할 데이터
     * @return 뷰 이름
     */
    @GetMapping("/admin/post/add")
    public String getAddPostPage(Model model) {
        if (!isAdmin()) {
            return "redirect:/board/notice";
        }

        model.addAttribute("post", new BoardPostDTO());
        return "board/admin/post/addPost";
    }

    /*
     * 관리자용 게시글 추가 처리
     *
     * @param post 추가할 게시글 정보
     * @return 리다이렉트 경로
     */
    @PostMapping("/admin/post/add")
    public String addPost(@ModelAttribute BoardPostDTO post) {
        if (!isAdmin()) {
            return "redirect:/board/notice";
        }

        post.setMemberCode(1); // 관리자 코드
        post.setCreatedAt(LocalDateTime.now());
        boardService.addPost(post);

        return "redirect:/board/admin/" + (post.getBoardType() == 1 ? "notice" : "FAQ");
    }

    /*
     * 관리자용 게시글 수정 페이지 요청 처리
     *
     * @param postId 수정할 게시글 ID
     * @param model 뷰에 전달할 데이터
     * @return 뷰 이름
     */
    @GetMapping("/admin/post/edit/{postId}")
    public String getEditPostPage(@PathVariable int postId, Model model) {
        if (!isAdmin()) {
            return "redirect:/board/notice";
        }

        BoardPostDTO post = boardService.getPostById(postId);
        model.addAttribute("post", post);
        return "board/admin/post/editPost";
    }

    /*
     * 관리자용 게시글 수정 처리
     *
     * @param post 수정할 게시글 정보
     * @return 리다이렉트 경로
     */
    @PostMapping("/admin/post/edit")
    public String editPost(@ModelAttribute BoardPostDTO post) {
        if (!isAdmin()) {
            return "redirect:/board/notice";
        }

        post.setUpdatedAt(LocalDateTime.now());
        boardService.updatePost(post);

        return "redirect:/board/admin/" + (post.getBoardType() == 1 ? "notice" : "FAQ");
    }

    /*
     * 관리자용 게시글 삭제 처리
     *
     * @param postId 삭제할 게시글 ID
     * @param boardType 게시판 유형
     * @return 리다이렉트 경로
     */
    @PostMapping("/admin/post/delete")
    public String deletePost(@RequestParam int postId, @RequestParam int boardType) {
        if (!isAdmin()) {
            return "redirect:/board/notice";
        }

        boardService.deletePost(postId);

        if (boardType == 1) return "redirect:/board/admin/notice";
        else if (boardType == 2) return "redirect:/board/admin/FAQ";
        else return "redirect:/board/admin/ask";
    }

    /*
     * 관리자용 댓글(답변) 추가 페이지 요청 처리
     * 1:1 문의에 답변을 작성하기 위한 페이지
     *
     * @param postId 답변을 추가할 게시글 ID
     * @param model 뷰에 전달할 데이터
     * @return 뷰 이름
     */
    @GetMapping("/admin/comment/add/{postId}")
    public String getAddCommentPage(@PathVariable int postId, Model model) {
        if (!isAdmin()) {
            return "redirect:/board/ask";
        }

        BoardPostDTO post = boardService.getPostById(postId);
        BoardCommentDTO comment = new BoardCommentDTO();
        comment.setPostId(postId);

        model.addAttribute("post", post);
        model.addAttribute("comment", comment);
        return "board/admin/post/addComment";
    }

    /*
     * 관리자용 댓글(답변) 추가 처리
     *
     * @param comment 추가할 댓글 정보
     * @return 리다이렉트 경로
     */
    @PostMapping("/admin/comment/add")
    public String addComment(@ModelAttribute BoardCommentDTO comment) {
        if (!isAdmin()) {
            return "redirect:/board/ask";
        }

        comment.setCreatedAt(LocalDateTime.now());
        boardService.addComment(comment);
        return "redirect:/board/admin/ask";
    }
}