package com.example.resource_server.controller;


import com.example.resource_server.dto.Gender;
import com.example.resource_server.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    @GetMapping("/status/check")
    public ResponseEntity<String> checkAuthServerStatus(){
        return ResponseEntity.ok("Welcome Authenticated User ... No Permissions");
    }

    @GetMapping("/status/check2")
    public ResponseEntity<String> checkAuthServerStatus2(){
        return ResponseEntity.ok("Permissions Required ...");
    }

//    @GetMapping("/token")
//    public ResponseEntity<Map<String, Object>> getTokenDetails(@AuthenticationPrincipal Jwt jwt){
//        return ResponseEntity.ok(Collections.singletonMap("token_details", jwt));
//    }
//
//
//    @GetMapping("/token2")
//    public ResponseEntity<Map<String, Object>> getTokenDetails2(@AuthenticationPrincipal Jwt jwt){
//        return ResponseEntity.ok(Collections.singletonMap("token_details", jwt));
//    }
//
//
//    @PreAuthorize("hasAuthority('view_profile') or #userId == #jwt.subject")
//    @GetMapping("/profile/{userId}")
//    public ResponseEntity<String> viewUserProfile(@PathVariable String userId, @AuthenticationPrincipal Jwt jwt){
//        return ResponseEntity.ok("Welcome {"+userId+"} you can access profile endpoint");
//    }


    @GetMapping
    public ResponseEntity<List<User>> getUsersList(){

        List<User> usersList =
            List.of(
                new User(1L, "Ahmed Khatab", LocalDateTime.of(1984, Month.FEBRUARY, 19, 0, 0), Gender.MALE),
                new User(1L, "Marwa Abdelkhalek", LocalDateTime.of(1988, Month.OCTOBER, 15, 0, 0), Gender.FEMALE),
                new User(1L, "Mohamed Ahmed Khatab", LocalDateTime.of(2012, Month.JULY, 13, 0, 0), Gender.MALE),
                new User(1L, "Arwa Ahmed Khatab", LocalDateTime.of(2015, Month.MAY, 20, 0, 0), Gender.FEMALE),
                new User(1L, "Hala Ahmed Khatab", LocalDateTime.of(2017, Month.JUNE, 29, 0, 0), Gender.FEMALE)
            );


        return ResponseEntity.ok(usersList);

    }


}
