package com.example.socialmediajpaimplementation.service;

import com.example.socialmediajpaimplementation.dto.UserDTO;
import com.example.socialmediajpaimplementation.entities.Follow;
import com.example.socialmediajpaimplementation.entities.UserApp;
import com.example.socialmediajpaimplementation.repository.FollowRepo;
import com.example.socialmediajpaimplementation.repository.UserAppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FollowServiceImpl implements FollowServiceInterface{

    @Autowired
    UserAppRepo userAppRepo;
    @Autowired
    FollowRepo followRepo;

    @Override
    public List<UserDTO> getFollowers(String username) {

        UserApp user = userAppRepo.findUserAppByUsername(username);
        List<Follow>followList = followRepo.findAll();

        List<UserDTO> followers = new ArrayList<>();

        for (Follow follow: followList) {

            if (Objects.equals(follow.getFollowingId(), user.getId())){

                UserApp follower = userAppRepo.findById(follow.getFollowerId()).get();
                UserDTO followerDTO =new UserDTO();
                followerDTO.setUsername(follower.getUsername());
                followerDTO.setEmail(follower.getEmail());

                followers.add(followerDTO);

            }
        }
        return followers;
    }

    @Override
    public List<UserDTO> getFollowings(String username) {
        UserApp user = userAppRepo.findUserAppByUsername(username);
        List<Follow>followList = followRepo.findAll();

        List<UserDTO> followings = new ArrayList<>();

        for (Follow follow: followList) {
            if (Objects.equals(follow.getFollowerId(), user.getId())){
                UserApp following = userAppRepo.findById(follow.getFollowingId()).get();

                UserDTO followingDTO =new UserDTO();
                followingDTO.setUsername(following.getUsername());
                followingDTO.setEmail(following.getEmail());

                followings.add(followingDTO);
            }
        }

        return followings;
    }

    @Override
    public List<UserDTO> getFriends(String username) {
        UserApp user = userAppRepo.findUserAppByUsername(username);
        List<Follow>followList = followRepo.findAll();

        List<UserDTO> friends = new ArrayList<>();

        for (int i =0;i<followList.size();i++){

            if (Objects.equals(user.getId(), followList.get(i).getFollowingId())){

                for (Follow follow : followList) {

                    if (Objects.equals(followList.get(i).getFollowerId(), follow.getFollowingId()) && Objects.equals(user.getId(), follow.getFollowerId())) {

                        UserApp friend = userAppRepo.findById(follow.getFollowingId()).get();

                        UserDTO friendDTO = new UserDTO();
                        friendDTO.setEmail(friend.getEmail());
                        friendDTO.setUsername(friend.getUsername());

                        friends.add(friendDTO);

                    }

                }
            }
        }

        return friends;
    }

    @Override
    public Object follow(String followerUsername, String followingUsername) {

        UserApp follower = userAppRepo.findUserAppByUsername(followerUsername);
        UserApp following =userAppRepo.findUserAppByUsername(followingUsername);

        Follow follow = new Follow();
        follow.setFollowerId(follower.getId());
        follow.setFollowingId(following.getId());

        return followRepo.save(follow);

    }

    @Override
    public Object Unfollow(String followerUsername, String followingUsername) {

        UserApp follower = userAppRepo.findUserAppByUsername(followerUsername);
        UserApp following =userAppRepo.findUserAppByUsername(followingUsername);

        Follow follow = followRepo.findFollowByFollowerIdAndFollowingId(follower.getId(),following.getId());
        if (follow!=null) {
            followRepo.delete(follow);
            return "Successful";
        }else{
            return null;
        }

    }
}
