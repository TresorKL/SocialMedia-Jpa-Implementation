package com.example.socialmediajpaimplementation.controllers;

import com.example.socialmediajpaimplementation.dto.UserDTO;
import com.example.socialmediajpaimplementation.service.FollowServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/follow")
public class FollowController {


    @Autowired
    FollowServiceInterface followServiceInterface;

    @GetMapping("/{username}/followers")
    public ResponseEntity<Object> getFollowers(@PathVariable("username") String username ){

        List<UserDTO>followers=followServiceInterface.getFollowers(username);

        if (followers!=null){
            return getObjectResponseEntity(followers,"Followers found:",200);
        }else {
            return getObjectResponseEntity(null,"Followers not found:",404);
        }

    }

    @GetMapping("/{username}/following")
    public ResponseEntity<Object> getFollowings(@PathVariable("username") String username ){

        List<UserDTO>following=followServiceInterface.getFollowers(username);

        if (following!=null){
            return getObjectResponseEntity(following,"Following found:",200);
        }else {
            return getObjectResponseEntity(null,"Following not found:",404);
        }
    }

    @GetMapping("/{username}/friends")
    public ResponseEntity<Object> getFriends(@PathVariable("username") String username ){

        List<UserDTO>friends=followServiceInterface.getFollowers(username);

        if (friends!=null){
            return getObjectResponseEntity(friends,"Friends found:",200);
        }else {
            return getObjectResponseEntity(null,"Friends not found:",404);
        }
    }


    public ResponseEntity<Object> follow(){


        return null;
    }

    public ResponseEntity<Object> unfollow(){
        return null;
    }


    private ResponseEntity<Object> getObjectResponseEntity(Object data,Object message, int statusCode) {

        Object status= HttpStatusCode.valueOf(statusCode).value();

        Map<String, Object> map=buildResponse( message, status,data);

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
