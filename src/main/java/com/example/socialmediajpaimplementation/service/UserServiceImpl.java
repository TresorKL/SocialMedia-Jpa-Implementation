package com.example.socialmediajpaimplementation.service;

import com.example.socialmediajpaimplementation.dto.NewUserDTO;
import com.example.socialmediajpaimplementation.entities.Follow;
import com.example.socialmediajpaimplementation.entities.UserApp;
import com.example.socialmediajpaimplementation.repository.FollowRepo;
import com.example.socialmediajpaimplementation.repository.UserAppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInterface{

    @Autowired
    UserAppRepo userAppRepo;

    @Autowired
    FollowRepo followRepo;

    @Override
    public UserApp addUser(NewUserDTO newUserDTO) {

        UserApp user = new UserApp();
        user.setEmail(newUserDTO.getEmail());
        user.setUsername(newUserDTO.getUsername());
        return userAppRepo.save(user);

    }

    @Override
    public UserApp getUser(String username) {
        return userAppRepo.findUserAppByUsername(username);
    }

    @Override
    public UserApp setFriendsFollowersFollowing(UserApp userApp) {

        List<Follow> followList= followRepo.findAll();




        return null;
    }

    @Override
    public UserApp setNumOfFriendsFollowersFollowing(UserApp userApp) {
        return null;
    }
}
