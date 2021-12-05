package com.project.demo.services;

import com.project.demo.entites.Blog;
import com.project.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImplementation implements BlogServiceInterface{
    @Autowired
    BlogRepository blogRepository;
    public void createBlogService( Blog theBlog) {
        blogRepository.save(theBlog);
    }

    public List<Blog> getBlogByUserIdService(Long userId) {
        return blogRepository.findByUserId(userId);

    }

    public void updateBlogService(Blog theBlog) {
        blogRepository.save(theBlog);
    }

    public void deleteBlogService(Long blogId) {
        blogRepository.deleteById(blogId);
    }

}
