package com.project.demo.controllers;

import com.project.demo.entites.Blog;
import com.project.demo.entites.User;
import com.project.demo.services.BlogServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogServiceImplementation blogService;

    // Create a Blog
    @PostMapping("/createBlog/{userId}")
    public void createBlog(@PathVariable Long userId, @RequestBody Blog theBlog){
        theBlog.setUser(new User(userId,"","","",""));
        theBlog.setPublishedStatus(true);
        blogService.createBlogService(theBlog);
    }

    // Create a Draft
    @PostMapping("/createDraft/{userId}")
    public void createDraft(@PathVariable Long userId, @RequestBody Blog theBlog){
        theBlog.setUser(new User(userId,"","","",""));
        theBlog.setPublishedStatus(false);
        blogService.createBlogService(theBlog);
    }

    // Get Blogs by userId
    @GetMapping("/getBlogByUserId/{userId}")
    public List<Blog> getBlogByUserId(@PathVariable Long userId){

        return blogService.getBlogByUserIdService(userId);
    }

    // Get Drafts by userId
    @GetMapping("/getDraftByUserId/{userId}")
    public List<Blog> getDraftByUserId(@PathVariable Long userId){

        return blogService.getDraftByUserIdService(userId);
    }

    //Update Blog by userId
    @PutMapping("updateBlog/{userId}")
    public void updateBlogContent(@PathVariable Long userId, @RequestBody Blog theBlog) {
        theBlog.setUser(new User(userId,"","","",""));
        theBlog.setPublishedStatus(true);
        blogService.updateBlogService(theBlog);
    }

    //Update Draft by userId
    @PutMapping("updateDraft/{userId}")
    public void updateDraftContent(@PathVariable Long userId, @RequestBody Blog theBlog) {
        theBlog.setUser(new User(userId,"","","",""));
        theBlog.setPublishedStatus(false);
        blogService.updateBlogService(theBlog);
    }

    //Delete Blog by BlogId
    @DeleteMapping("deleteBlog/{blogId}")
    public void deleteBlog(@PathVariable Long blogId) {
        blogService.deleteBlogService(blogId);
    }

    //Blog To Draft
    @PutMapping("blogToDraft/{userId}")
    public void blogToDraft(@PathVariable Long userId, @RequestBody Blog theBlog){
        theBlog.setUser(new User(userId,"","","",""));
        theBlog.setPublishedStatus(false);
        blogService.updateBlogService(theBlog);
    }

    // Draft To Blog
    @PutMapping("draftToBlog/{userId}")
    public void draftToBlog(@PathVariable Long userId, @RequestBody Blog theBlog){
        theBlog.setUser(new User(userId,"","","",""));
        theBlog.setPublishedStatus(true);
        blogService.updateBlogService(theBlog);
    }


}
