package com.example.clientapp.controller;


import com.example.clientapp.dto.Album;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Year;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AlbumsController {

    private final WebClient webClient;


    @GetMapping("/albums")
    public String getAlbumsList(Model model, @AuthenticationPrincipal OidcUser oidc){

        log.info("________________________________________________");
        log.info("{}", oidc.getIdToken().getTokenValue());
        log.info("________________________________________________");

        List<Album> albumsList = webClient.get().uri("http://localhost:8080/albums-service/albums")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Album>>() {
                }).block();

        model.addAttribute("albums", albumsList);

        return "albums";
    }
}
