package com.project.demo.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq", allocationSize = 1)
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_seq_gen")
    @Column(name = "user_id")
    private Long id;

    @Length(min=5,message = "*Your username must have atleast 5 characters")
    @Column(name="user_Name",nullable = false,unique = true)
    @NotEmpty(message ="Please enter your username")
    private String userName;

    @Column(name="user_EmailId",unique = true,nullable = false)
    @NotEmpty(message = "Please enter your EmailId")
    private String userEmailId;

    @Column(name="user_Password", nullable = false)
    @NotEmpty(message="Please enter your password")
    @Length(min=8,message="Your password must have atleast 8 characters")
    @JsonIgnore // Just in case Jackson tries wants to betray us
    private String userPassword;

    @Column(name="display_Name", nullable=false)
    private String displayName;
}


