package com.project.demo.services;

import com.project.demo.entites.Blog;

import java.util.List;

public interface BlogServiceInterface {
    void createBlogService( Blog theBlog);
    List<Blog> getBlogByUserIdService(Long userId);
    List<Blog> getDraftByUserIdService(Long userId);
    void updateBlogService(Blog theBlog);
    void deleteBlogService(Long blogId);
}
