package com.project.demo.controllers;

import com.project.demo.entites.Blog;
import com.project.demo.entites.User;
import com.project.demo.services.BlogServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogServiceImplementation blogService;

    // Create a Blog
    @PostMapping("/createBlog/{userId}")
    public void createBlog(@PathVariable Long userId, @RequestBody Blog theBlog) {
        theBlog.setUser(new User(userId, "", "", "", ""));
        theBlog.setPublishedStatus(true);
        theBlog.setTimestamp(new Timestamp(System.currentTimeMillis()));
        blogService.createBlogService(theBlog);
    }

    // Create a Draft
    @PostMapping("/createDraft/{userId}")
    public void createDraft(@PathVariable Long userId, @RequestBody Blog theBlog) {
        theBlog.setUser(new User(userId, "", "", "", ""));
        theBlog.setPublishedStatus(false);
        theBlog.setTimestamp(new Timestamp(System.currentTimeMillis()));
        blogService.createBlogService(theBlog);
    }

    // Get Blog by blogId
    @GetMapping("/getBlogByBlogId/{blogId}")
    public Optional<Blog> getBlogByBlogId(@PathVariable Long blogId) {
        return blogService.getBlogByBlogIdService(blogId);
    }

    // Get Draft by blogId
    @GetMapping("/getDraftByBlogId/{blogId}")
    public Optional<Blog> getDraftByBlogId(@PathVariable Long blogId) {
        return blogService.getBlogByBlogIdService(blogId);
    }

    // Get Blogs by userId
    @GetMapping("/getBlogByUserId/{userId}")
    public List<Blog> getBlogByUserId(@PathVariable Long userId) {
        return blogService.getBlogByUserIdService(userId);
    }

    // Get Drafts by userId
    @GetMapping("/getDraftByUserId/{userId}")
    public List<Blog> getDraftByUserId(@PathVariable Long userId) {
        return blogService.getDraftByUserIdService(userId);
    }

    //Update Blog by userId
    @PutMapping("updateBlog/{userId}")
    public void updateBlogContent(@PathVariable Long userId, @RequestBody Blog theBlog) {
        theBlog.setUser(new User(userId, "", "", "", ""));
        theBlog.setPublishedStatus(true);
        theBlog.setTimestamp(new Timestamp(System.currentTimeMillis()));
        blogService.updateBlogService(theBlog);
    }

    //Update Draft by userId
    @PutMapping("updateDraft/{userId}")
    public void updateDraftContent(@PathVariable Long userId, @RequestBody Blog theBlog) {
        theBlog.setUser(new User(userId, "", "", "", ""));
        theBlog.setPublishedStatus(false);
        theBlog.setTimestamp(new Timestamp(System.currentTimeMillis()));
        blogService.updateBlogService(theBlog);
    }

    //Delete Blog by BlogId
    @DeleteMapping("deleteBlog/{blogId}")
    public void deleteBlog(@PathVariable Long blogId) {
        blogService.deleteBlogService(blogId);
    }

    //Blog To Draft
    @PutMapping("blogToDraft/{userId}")
    public void blogToDraft(@PathVariable Long userId, @RequestBody Blog theBlog) {
        theBlog.setUser(new User(userId, "", "", "", ""));
        theBlog.setPublishedStatus(false);
        theBlog.setTimestamp(new Timestamp(System.currentTimeMillis()));
        blogService.updateBlogService(theBlog);
    }

    // Draft To Blog
    @PutMapping("draftToBlog/{userId}")
    public void draftToBlog(@PathVariable Long userId, @RequestBody Blog theBlog) {
        theBlog.setUser(new User(userId, "", "", "", ""));
        theBlog.setPublishedStatus(true);
        theBlog.setTimestamp(new Timestamp(System.currentTimeMillis()));
        blogService.updateBlogService(theBlog);
    }

    //Get top 5 recent Blogs
    @GetMapping("/recentBlogs")
    public List<Blog> getRecentBlogs() {
        return blogService.getRecentBlogsService();
    }

    //Get top 5 recent Drafts
    @GetMapping("/recentDrafts")
    public List<Blog> getRecentDrafts() {
        return blogService.getRecentDraftsService();
    }

    //likes on particular Blog
    @GetMapping("/getLikes/{blogId}")
    public Integer getLikesByBlogId(@PathVariable Long blogId){
        return blogService.getLikesByBlogIdService(blogId);
    }

    //Dislikes on particular Blog
    @GetMapping("/getDislikes/{blogId}")
    public Integer getDislikesByBlogId(@PathVariable Long blogId){
        return blogService.getDislikesByBlogIdService(blogId);
    }

    //Total likes on all Blogs
//
//    @GetMapping("/totalLikes/{userId}")
//    public Integer totalLikesForUser(@PathVariable Long userId){
//        return blogService.totalLikesForUserService(userId);
//    }
    //Total Dislikes on all Blogs



}
