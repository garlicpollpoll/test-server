package com.hello.capston.controller.like;

import com.hello.capston.dto.dto.like.LookUpLikeDto;
import com.hello.capston.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LikeListController {

    private final LikeService likeService;

    /**
     * 좋아요 목록 조회
     * @param session
     * @param model
     * @return
     */
    @GetMapping("/like_list")
    public String likeList(HttpSession session, Model model) {
        String userEmail = (String) session.getAttribute("userEmail");
        String loginId = (String) session.getAttribute("loginId");

        LookUpLikeDto dto = likeService.lookUpLikeList(loginId, userEmail);

        model.addAttribute("myLikes", dto.getFindLikes());
        model.addAttribute("status", dto.getRole());

        return "like_list";
    }
}
