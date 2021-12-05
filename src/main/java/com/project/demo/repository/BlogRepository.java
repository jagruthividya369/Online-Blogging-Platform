package com.project.demo.repository;

import com.project.demo.entites.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository  extends CrudRepository<Blog,Long>{
    List<Blog> findByUserId(Long userId);
}
