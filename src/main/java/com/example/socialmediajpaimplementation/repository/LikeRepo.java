package com.example.socialmediajpaimplementation.repository;

import com.example.socialmediajpaimplementation.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepo extends JpaRepository<Like,Long> {
}
