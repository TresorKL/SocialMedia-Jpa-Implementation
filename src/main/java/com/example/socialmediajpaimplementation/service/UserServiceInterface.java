package com.example.socialmediajpaimplementation.service;

import com.example.socialmediajpaimplementation.dto.NewUserDTO;
import com.example.socialmediajpaimplementation.entities.UserApp;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface UserServiceInterface {

    UserApp addUser(NewUserDTO newUserDTO);

    UserApp getUser(String username);

    UserApp setFriendsFollowersFollowing(UserApp userApp);

    UserApp setNumOfFriendsFollowersFollowing(UserApp userApp);
}
