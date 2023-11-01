package com.example.socialmediajpaimplementation.repository;

import com.example.socialmediajpaimplementation.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
}
