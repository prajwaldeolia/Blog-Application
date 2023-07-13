package com.nagarro.BlogManagementSystem.controller;

import com.nagarro.BlogManagementSystem.model.Comment;
import com.nagarro.BlogManagementSystem.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public String getAllComments(Model model) {
        model.addAttribute("comments", commentService.getAllComments());
        return "comment/view-all";
    }

    @GetMapping("/{id}")
    public String getCommentById(@PathVariable Long id, Model model) {
        Comment comment = commentService.getCommentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid comment ID: " + id));
        model.addAttribute("comment", comment);
        return "comment/view";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("comment", new Comment());
        return "comment/create";
    }

    @PostMapping("/create")
    public String createComment(@ModelAttribute("comment") Comment comment) {
        commentService.saveComment(comment);
        return "redirect:/comments";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Comment comment = commentService.getCommentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid comment ID: " + id));
        model.addAttribute("comment", comment);
        return "comment/edit";
    }

    @PostMapping("/{id}/edit")
    public String updateComment(@PathVariable Long id, @ModelAttribute("comment") Comment updatedComment) {
        Comment comment = commentService.getCommentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid comment ID: " + id));
        comment.setContent(updatedComment.getContent());
        commentService.saveComment(comment);
        return "redirect:/comments";
    }

    @PostMapping("/{id}/delete")
    public String deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return "redirect:/comments";
    }
}
