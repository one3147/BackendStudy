package com.mysite.sbb;

import javax.sql.DataSource;

import org.apache.catalina.User;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.List;

public class UserDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void someMethod() {
        String sql = "SELECT * FROM users WHERE name=:name";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", "John");
        List<User> users = jdbcTemplate.query(sql, params, new UserMapper());
    }
}
