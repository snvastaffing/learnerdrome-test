package com.snva.learnerdromeappw.learnerdrome.controllers;


import com.google.gson.Gson;
import com.snva.learnerdromeappw.learnerdrome.model.dbmodel.Role;
import com.snva.learnerdromeappw.learnerdrome.model.dbmodel.User;
import org.bson.json.JsonObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;






@RestController
public class ApiController {
    User userFromRepo = new User();

    //{/dheeraj@snva.com}
    @PostMapping(path = "/employeepath/{email}")
    @ResponseBody
    public ResponseEntity<User> getUserByEmailPath(@PathVariable String email){
        // call our service
        userFromRepo.setEmail(email);
        userFromRepo.setContact("123456789");
        userFromRepo.setFirstName("Dheeraj");
        userFromRepo.setProfilePicture("fhadjhfadjhfad");
        userFromRepo.set_id("?>43%4$534r");
        userFromRepo.setLastName("Singh");
        userFromRepo.setRoles(Arrays.asList(new Role().setRoleName("admin"),new Role().setRoleName("instructor"),new Role().setRoleName("learner")));
        return ResponseEntity.ok(userFromRepo);
    }
    //{?email=dheeraj@snva.com}
    @RequestMapping(path = "/employeerequest")
    public ResponseEntity getUserByEmail(@RequestParam String email){
        // call our service
        userFromRepo.setEmail(email);
        userFromRepo.setContact("123456789");
        userFromRepo.setFirstName("Dheeraj");
        userFromRepo.setProfilePicture("fhadjhfadjhfad");
        userFromRepo.set_id("?>43%4$534r");
        userFromRepo.setLastName("Singh");
        userFromRepo.setRoles(Arrays.asList(new Role().setRoleName("admin"),new Role().setRoleName("instructor"),new Role().setRoleName("learner")));
        HttpHeaders headers = new HttpHeaders();

        // some parser to parse the object as XML
        ResponseEntity entityModel= null;
        if (!email.contains("@")){
            entityModel = new ResponseEntity<>("email being submitted is invalid ",  headers,
                    HttpStatus.VARIANT_ALSO_NEGOTIATES);
            return entityModel;
        }
        entityModel = new ResponseEntity<>(userFromRepo,  headers,
                HttpStatus.CREATED);

    return entityModel;
    }
}
