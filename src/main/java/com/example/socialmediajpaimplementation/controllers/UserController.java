package com.example.socialmediajpaimplementation.controllers;

import com.example.socialmediajpaimplementation.dto.NewUserDTO;
import com.example.socialmediajpaimplementation.dto.UserDTO;
import com.example.socialmediajpaimplementation.entities.UserApp;
import com.example.socialmediajpaimplementation.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserServiceInterface userServiceInterface;



    @PostMapping("/add")
    public ResponseEntity<Object> addUser(NewUserDTO newUserDTO){

        UserApp user = userServiceInterface.addUser(newUserDTO);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getUsername());

        return getObjectResponseEntity(userDTO,"user successfully added",200);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<Object> getUser(@PathVariable("username") String username){

        UserApp user = userServiceInterface.getUser(username);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getUsername());
        userDTO.setNumOfFollowers(user.getNumOfFollowers());
        userDTO.setNumOfFollowing(user.getNumOfFollowing());
        userDTO.setNumOfFriends(user.getNumOfFriends());


        return getObjectResponseEntity(userDTO,"user found",200);

    }






    private ResponseEntity<Object> getObjectResponseEntity(Object data,Object message, int statusCode) {
        Map<String, Object> map = new HashMap<String, Object>();

        Object status= HttpStatusCode.valueOf(statusCode).value();

        map=buildResponse( message, status,data);

        return new ResponseEntity<Object>(map, HttpStatusCode.valueOf(statusCode));
    }


    protected Map<String, Object> buildResponse(Object message, Object status, Object data){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message",message);
        map.put("status", status);
        map.put("data", data);

        return map;
    }
}
