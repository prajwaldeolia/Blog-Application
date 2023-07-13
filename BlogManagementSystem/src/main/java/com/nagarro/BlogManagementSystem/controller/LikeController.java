package com.nagarro.BlogManagementSystem.controller;

import com.nagarro.BlogManagementSystem.model.Like;
import com.nagarro.BlogManagementSystem.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/likes")
public class LikeController {
    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public String getAllLikes(Model model) {
        model.addAttribute("likes", likeService.getAllLikes());
        return "like/view-all";
    }

    @GetMapping("/{id}")
    public String getLikeById(@PathVariable Long id, Model model) {
        Like like = likeService.getLikeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid like ID: " + id));
        model.addAttribute("like", like);
        return "like/view";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("like", new Like());
        return "like/create";
    }

    @PostMapping("/create")
    public String createLike(@ModelAttribute("like") Like like) {
        likeService.saveLike(like);
        return "redirect:/likes";
    }

    @PostMapping("/{id}/delete")
    public String deleteLike(@PathVariable Long id) {
        likeService.deleteLike(id);
        return "redirect:/likes";
    }
}
