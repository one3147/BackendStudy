package com.example.board;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @PostMapping("/login")
    public String loginCheck(@RequestParam String username, @RequestParam String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try {
            User user = jdbcTemplate.queryForObject(sql, new Object[] {username, password}, new BeanPropertyRowMapper<>(User.class));
            return "main";
        } catch (EmptyResultDataAccessException e) {
            return "index";
        }
    }
    @GetMapping("/perfect")
    public String login(@RequestParam String name)
    {
        if (name.equals("admin"))
        {
            return "<h1>Success</h1>";
        }
        return "<h1>Failed..</h1>";

    }
}
