package com.example.socialmediajpaimplementation.repository;

import com.example.socialmediajpaimplementation.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAppRepo extends JpaRepository<UserApp,Long> {

    UserApp findUserAppByUsername(String username);

}
