package com.project.demo.entites;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SequenceGenerator(name = "blog_seq_gen", sequenceName = "blog_seq", allocationSize = 1)
public class Blog {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "blog_seq_gen")
    @Column(name = "bId")
    private Long blogId;

    @Length(min=10, message = "enter the blog name/title")
    @Column(name = "blogName", nullable = false, unique = true)
    private String blogName;

    @Length(min=500, message = "Enter the contents of the blog")
    @Column(name="blogContent", nullable = false, unique = false)
    @NotEmpty(message ="Please enter the contents")
    private String blogContent;

    @Column(name = "likes", nullable = true)
    private Integer blogLikes;

    @Column(name = "dislikes", nullable = true)
    private Integer blogDisLikes;

    @ManyToOne
    private User userId;

    public Blog(Long blogId, String blogName, String blogContent, Integer blogLikes, Integer blogDisLikes) {
        this.blogId = blogId;
        this.blogName = blogName;
        this.blogContent = blogContent;
        this.blogLikes = blogLikes;
        this.blogDisLikes = blogDisLikes;
    }
}
