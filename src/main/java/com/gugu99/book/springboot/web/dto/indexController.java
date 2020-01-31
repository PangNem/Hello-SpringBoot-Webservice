package com.gugu99.book.springboot.web.dto;

import com.gugu99.book.springboot.config.auth.LoginUser;
import com.gugu99.book.springboot.config.auth.dto.*;
import com.gugu99.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class indexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index"; // 가져온 결과를 posts로 index에 전달한다.
    }
}