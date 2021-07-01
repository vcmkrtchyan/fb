package org.example.fb.service;

import org.example.fb.model.AuthUser;
import org.example.fb.model.Post;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final JdbcTemplate jdbcTemplate;

    public PostService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Post> getAllPosts() {
        return jdbcTemplate.query("select u.username, p.content from posts p inner join users u on u.id = p.user_id",
                (resultSet, i) -> {
                    Post post = new Post();
                    post.setUser(resultSet.getString("username"));
                    post.setData(resultSet.getString("content"));
                    return post;
                });
    }

    public void addData(String data) {
        AuthUser authUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        jdbcTemplate.update(
                "insert into posts (user_id, content) values(?, ?)",
                authUser.getId(), data
        );
    }
}
