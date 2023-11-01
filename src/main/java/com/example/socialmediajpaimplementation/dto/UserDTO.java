package com.example.socialmediajpaimplementation.dto;

import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String email;
    private String username;

    private int numOfFollowers;
    private int numOfFriends;
    private int numOfFollowing;
}
