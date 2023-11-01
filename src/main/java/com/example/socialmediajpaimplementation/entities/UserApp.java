package com.example.socialmediajpaimplementation.entities;

import com.example.socialmediajpaimplementation.dto.UserDTO;
import com.example.socialmediajpaimplementation.repository.FollowRepo;
import com.example.socialmediajpaimplementation.repository.UserAppRepo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String email;
    private String username;

    @OneToMany
    List<Post>posts;


    @Transient
    private int numOfFollowers;
    @Transient
    private int numOfFriends;
    @Transient
    private int numOfFollowing;

    @Transient
    List<UserDTO>followers;

    @Transient
    List<UserDTO>following;

    @Transient
    List<UserDTO>friends;





}
