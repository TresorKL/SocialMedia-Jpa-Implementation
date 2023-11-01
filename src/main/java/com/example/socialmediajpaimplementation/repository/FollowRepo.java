package com.example.socialmediajpaimplementation.repository;

import com.example.socialmediajpaimplementation.entities.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepo extends JpaRepository<Follow,Long> {

    List<Follow>findFollowByFollowerId(Long followerId);
    List<Follow>findFollowByFollowingId(Long followingId);

    Follow findFollowByFollowerIdAndFollowingId(Long followerId, Long followingId);

}

