package com.project.demo.services;

import com.project.demo.entites.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogServiceInterface {
    void createBlogService( Blog theBlog);
    List<Blog> getBlogByUserIdService(Long userId);
    List<Blog> getDraftByUserIdService(Long userId);
    void updateBlogService(Blog theBlog);
    void deleteBlogService(Long blogId);
    
    List<Blog> getRecentBlogsService();
    
    Integer getLikesByBlogIdService(Long blogId);
    Integer getDislikesByBlogIdService(Long blogId);

    Optional<Blog> getBlogByBlogIdService(Long blogId);

//    Integer totalLikesForUserService(Long userId);
}
