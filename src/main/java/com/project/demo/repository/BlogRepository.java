package com.project.demo.repository;

import com.project.demo.entites.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository  extends CrudRepository<Blog,Integer>{
}
