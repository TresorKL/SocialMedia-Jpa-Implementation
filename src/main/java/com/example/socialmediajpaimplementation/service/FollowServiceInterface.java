package com.example.socialmediajpaimplementation.service;

import com.example.socialmediajpaimplementation.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FollowServiceInterface {

    public List<UserDTO> getFriends(String username);
    public List<UserDTO> getFollowings(String username);
    public List<UserDTO> getFollowers(String username);

    public Object follow(String followerUsername, String followingUsername);
    public Object Unfollow(String followerUsername, String followingUsername);


}
