package com.project.demo.repository;

import com.project.demo.entites.Blog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository  extends CrudRepository<Blog,Long>{
    List<Blog> findByUserId(Long userId);
    List<Blog> findFirst5ByOrderByTimestampDesc();
//    @Query(select sum(likes))
//    Integer getTotalLikes();

//    @Query("select * from blog order by published_on desc limit 2;")
//    List<Blog> getTop5timeStamps();
}
