package com.example.resource_server.security;


//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
//@EnableWebSecurity
public class WebSecurity
//        extends WebSecurityConfigurerAdapter
{

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
//        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());
//
//        http
//            .authorizeHttpRequests()
//                .antMatchers("/users/status/check").hasAuthority("SCOPE_profile")
////                .antMatchers("/users/token").hasAuthority("ROLE_developer")
//                .antMatchers("/users/token").hasRole("developer")
//            .anyRequest()
//                .authenticated()
//            .and()
//               use oauth2 it will also create bearer token authentication filter to intercept http requests
//               to extract token from authorization header
//                .oauth2ResourceServer()
//               use jwt token instead of opaqueToken token
//                .jwt()
//               register converter class to extract roles from token
//                .jwtAuthenticationConverter(jwtAuthenticationConverter)
//        ;
//    }
}
