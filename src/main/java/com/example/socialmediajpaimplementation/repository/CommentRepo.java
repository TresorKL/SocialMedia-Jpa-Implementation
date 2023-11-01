package com.example.socialmediajpaimplementation.repository;

import com.example.socialmediajpaimplementation.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Long> {
}
