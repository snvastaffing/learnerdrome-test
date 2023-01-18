package com.snva.learnerdromeappw.learnerdrome.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.snva.learnerdromeappw.learnerdrome.model.dbmodel.Role;
import com.snva.learnerdromeappw.learnerdrome.model.dbmodel.User;
import com.snva.learnerdromeappw.learnerdrome.model.dbmodel.UserXml;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;


@RestController
@RequestMapping("/employee")
public class EmployeeController {


    ModelMapper modelMapper = new ModelMapper();
    @RequestMapping(path = "/addemployee",
            method = RequestMethod.POST,
            consumes = "application/xml")
    public ResponseEntity createUser(@RequestBody User user){
        UserXml userXml = modelMapper.map(user,UserXml.class);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(userXml,  headers,
                    HttpStatus.CREATED);
    }


    @RequestMapping(path = "/addemployee1", method = RequestMethod.POST,
            produces = "application/xml",
            consumes = "application/json")


    // @RequestParam when sending a single paramater
    // RequestBody when sending a whole JSON Payload
    public  ResponseEntity createUser1(@RequestBody User user){

        User userJson = new User();
        userJson.setEmail("email");
        userJson.setContact("123456789");
        userJson.setFirstName("Dheeraj");
        userJson.setProfilePicture("fhadjhfadjhfad");
        userJson.set_id("?>43%4$534r");
        userJson.setLastName("Singh");
        userJson.setRoles(Arrays.asList(new Role().setRoleName("admin"),new Role().setRoleName("instructor"),new Role().setRoleName("learner")));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        return  new ResponseEntity<>(userJson,  headers,
                HttpStatus.CREATED);
    }

    public static void main(String[] args) {

        User userJson = new User();
        userJson.setEmail("email");
        userJson.setContact("123456789");
        userJson.setFirstName("Dheeraj");
        userJson.setProfilePicture("fhadjhfadjhfad");
        userJson.set_id("?>43%4$534r");
        userJson.setLastName("Singh");
        System.out.println(new Gson().toJson(userJson));

//
        UserXml userXml = new UserXml();
        ResponseEntity entityModel= null;
        userXml.setEmail("email");
        userXml.setContact("123456789");
        userXml.setFirstName("Dheeraj");
        userXml.setProfilePicture("fhadjhfadjhfad");
        userXml.set_id("?>43%4$534r");
        userXml.setLastName("Singh");
        userXml.setRoles(Arrays.asList(new Role().setRoleName("admin"),new Role().setRoleName("instructor"),new Role().setRoleName("learner")));
        String xml="";
                ObjectMapper objectMapper = new ObjectMapper();
        try {
            xml=   objectMapper.writeValueAsString(userXml);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(xml);
    }
}
