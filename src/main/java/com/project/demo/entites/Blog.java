package com.project.demo.entites;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bId")
    private Long blogId;

    @Length(min=10, message = "enter the blog name/title")
    @Column(name = "blogName", nullable = false, unique = true)
    private String blogName;

    @Length(min=10)
    @Column(name="blogContent", nullable = false, unique = false)
    @NotEmpty(message ="Please enter the contents")
    @Lob
    private String blogContent;

    @Column(name = "likes", nullable = true)
    private Integer blogLikes;

    @Column(name = "dislikes", nullable = true)
    private Integer blogDisLikes;

    @ManyToOne
    private User user;

    @Column(name="published_status",nullable=false,columnDefinition = "boolean default true")
    private boolean publishedStatus;   //true-published; false-draft



    public Blog(String blogName, String blogContent, Integer blogLikes, Integer blogDisLikes, Long id, boolean publishedStatus) {
        this.blogName = blogName;
        this.blogContent = blogContent;
        this.blogLikes = blogLikes;
        this.blogDisLikes = blogDisLikes;
        this.user =new User(id,"","","","");
        this.publishedStatus=publishedStatus;

    }
}
