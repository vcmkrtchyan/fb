package org.example.fb.controllers;

import org.example.fb.model.Post;
import org.example.fb.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private final PostService postService;

    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView("home");
        List<Post> allPosts = postService.getAllPosts();
        modelAndView.addObject("posts", allPosts);
        return modelAndView;
    }

    @PostMapping
    public String post(@RequestParam("data") String data) {
        postService.addData(data);
        return "redirect:/";
    }
}
