package com.example.socialmediajpaimplementation.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String caption;
    private String media_url;

    @OneToMany
    List<Comment> comments;

    @OneToMany
    List<Like>likes;


}
