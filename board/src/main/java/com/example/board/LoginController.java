package com.example.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model)
    {
        // 로그인 처리
        boolean success = false;
        if (username.equals("admin") && password.equals("admin")) {
            success = true;
        }

        if (success) {
            // 로그인 성공시 메인 페이지로 이동
            return "main";
        } else {
            // 로그인 실패시 에러 메시지 표시
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

}
