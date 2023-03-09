package com.example.clientapp.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class WebClientConfig {


    @Bean
    public WebClient webClient(ClientRegistrationRepository clientRegistrationRepository,
                               OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository){

        ServletOAuth2AuthorizedClientExchangeFilterFunction oauth =
                new ServletOAuth2AuthorizedClientExchangeFilterFunction(clientRegistrationRepository,
                        oAuth2AuthorizedClientRepository);

        oauth.setDefaultOAuth2AuthorizedClient(true);

        return WebClient.builder()
                .apply(oauth.oauth2Configuration())
                .build();
    }

//    @Bean
//    public WebClient webClient(ReactiveOAuth2AuthorizedClientManager authorizedClientManager){
//
//        ServerOAuth2AuthorizedClientExchangeFilterFunction oauth = new ServerOAuth2AuthorizedClientExchangeFilterFunction(
//                authorizedClientManager);
//
//        oauth.setDefaultOAuth2AuthorizedClient(true);
//
//        return WebClient.builder()
//                        .filter(oauth)
//                        .filter(logRequest())
//                        .build();
//    }
//
//
//    @Bean
//    ReactiveOAuth2AuthorizedClientManager authorizedClientManager(
//            ReactiveClientRegistrationRepository clientRegistrationRepository,
//            ServerOAuth2AuthorizedClientRepository authorizedClientRepository) {
//
//        // @formatter:off
//        ReactiveOAuth2AuthorizedClientProvider authorizedClientProvider =
//                ReactiveOAuth2AuthorizedClientProviderBuilder.builder()
//                        .authorizationCode()
//                        .refreshToken()
//                        .clientCredentials()
//                        .password()
//                        .build();
//
//        DefaultReactiveOAuth2AuthorizedClientManager authorizedClientManager = new DefaultReactiveOAuth2AuthorizedClientManager(
//                clientRegistrationRepository, authorizedClientRepository);
//        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
//
//        return authorizedClientManager;
//    }



//    @Bean
//    public WebClient webClient(
//            ReactiveClientRegistrationRepository clientRegistrationRepository,
//            ReactiveOAuth2AuthorizedClientService authorizedClientService
//    ) {
//        var oauth = new ServerOAuth2AuthorizedClientExchangeFilterFunction(
//                new AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager(
//                        clientRegistrationRepository, authorizedClientService
//                )
//        );
//
//        oauth.setDefaultClientRegistrationId("albums-app");
//
//        return WebClient.builder()
//                .filter(oauth)
//                .filter(logRequest())
//                .build();
//    }

//    private ExchangeFilterFunction logRequest() {
//        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
//            log.info("======================================================");
//            log.info("Request: [{}] {}", clientRequest.method(), clientRequest.url());
//            log.debug("Payload: {}", clientRequest.body());
//            log.info("======================================================");
//            return Mono.just(clientRequest);
//        });
//    }

}
