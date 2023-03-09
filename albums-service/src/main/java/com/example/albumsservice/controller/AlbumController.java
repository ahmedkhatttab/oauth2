package com.example.albumsservice.controller;

import com.example.albumsservice.dto.Album;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/albums")
@RequiredArgsConstructor
@Slf4j
public class AlbumController {

    @GetMapping
    public ResponseEntity<List<Album>> getAlbumsList(@AuthenticationPrincipal Jwt jwt){

      log.info("*****************************************");
      log.info("{}", jwt.getTokenValue());
      log.info("*****************************************");

        List<Album> albumsList = List.of(
            new Album(1L, "Album One", Year.of(2012)),
            new Album(1L, "Album Two", Year.of(2015)),
            new Album(1L, "Album Three", Year.of(2017))
        );

        return ResponseEntity.ok(albumsList);
    }


}
