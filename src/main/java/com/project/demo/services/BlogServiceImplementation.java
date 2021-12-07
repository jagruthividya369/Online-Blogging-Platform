package com.project.demo.services;

import com.project.demo.entites.Blog;
import com.project.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BlogServiceImplementation implements BlogServiceInterface{
    @Autowired
    BlogRepository blogRepository;

    public void createBlogService( Blog theBlog) {
        blogRepository.save(theBlog);
    }

    public List<Blog> getBlogByUserIdService(Long userId) {
        return blogRepository.findByUserId(userId).stream().filter(theBlog->theBlog.isPublishedStatus()).collect(Collectors.toList());
    }
    public List<Blog> getDraftByUserIdService(Long userId) {
        return blogRepository.findByUserId(userId).stream().filter(theBlog->!(theBlog.isPublishedStatus())).collect(Collectors.toList());
    }
    public void updateBlogService(Blog theBlog) {
        blogRepository.save(theBlog);
    }

    public void deleteBlogService(Long blogId) {
        blogRepository.deleteById(blogId);
    }

    public List<Blog> getRecentBlogsService() {
//        Return Top5 latest uploaded files(blogs+drafts included)
//        return blogRepository.findFirst5ByOrderByTimestampDesc();

        return StreamSupport
                .stream(blogRepository.findAll().spliterator(), false)
                .filter(theBlog->theBlog.isPublishedStatus())
                .sorted(Comparator.comparing(Blog::getTimestamp).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }
    public List<Blog> getRecentDraftsService() {
        return StreamSupport
                .stream(blogRepository.findAll().spliterator(), false)
                .filter(theBlog->!(theBlog.isPublishedStatus()))
                .sorted(Comparator.comparing(Blog::getTimestamp).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    public Integer getLikesByBlogIdService(Long blogId) {
        return blogRepository.findById(blogId).get().getBlogLikes();
    }

    public Integer getDislikesByBlogIdService(Long blogId) {
        return blogRepository.findById(blogId).get().getBlogDisLikes();
    }

    public Optional<Blog> getBlogByBlogIdService(Long blogId) {
        return blogRepository.findById(blogId);
    }

//
//    public Integer totalLikesForUserService(Long userId) {
//    }

}
