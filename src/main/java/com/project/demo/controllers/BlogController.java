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
        blogService.createBlogService(theBlog);
    }

    // Get Blogs by userId
    @GetMapping("/getBlogByUserId/{userId}")
    public List<Blog> getBlogByUserId(@PathVariable Long userId){

        return blogService.getBlogByUserIdService(userId);
    }

    //Update Blog by userId
    @PutMapping("updateBlog/{userId}")
    public void updateBlogContent(@PathVariable Long userId, @RequestBody Blog theBlog) {
        theBlog.setUser(new User(userId,"","","",""));
        blogService.updateBlogService(theBlog);
    }

    //Delete Blog by BlogId
    @DeleteMapping("deleteBlog/{blogId}")
    public void deleteBlog(@PathVariable Long blogId) {
        blogService.deleteBlogService(blogId);
    }

    // Delete All Blogs by UserId
    // Save Blog as draft
    // Publish draft as a blog
    // Add

}
