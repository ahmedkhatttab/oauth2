package com.example.resource_server.security;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.jwt.Jwt;

import java.util.*;
import java.util.stream.Collectors;

//@Configuration
public class KeycloakRoleConverter
//        implements Converter<Jwt, Collection<GrantedAuthority>>
{
//    @Bean
//    public KeycloakConfigResolver keycloakConfigResolver() {
//        return new KeycloakSpringBootConfigResolver();
//    }
//    @Override
//    public Collection<GrantedAuthority> convert(Jwt jwt) {
//
//        Collection<GrantedAuthority> authorities = null;
//
//        Map<String, Object> realm_access = (Map<String, Object>) jwt.getClaims().get("realm_access");
//
//        if(realm_access == null || realm_access.isEmpty()) {
//            authorities = new ArrayList<>();
//        }
//        else {
//            authorities =
//                    ((List<String>) realm_access.get("roles"))
//                            .stream()
//                            .map(roleName -> "ROLE_" + roleName)
//                            .map(SimpleGrantedAuthority::new)
//                            .collect(Collectors.toList());
//        }
//
//        String scopes =(String) jwt.getClaims().get("scope");
//
//        if(Optional.ofNullable(scopes).isPresent()){
//            authorities.addAll
//            (
//                Arrays.stream(scopes.split(" "))
//                    .map(scope-> "SCOPE_"+scope)
//                    .map(SimpleGrantedAuthority::new).collect(Collectors.toList())
//            );
//        }
//
//        return authorities;
//    }
}
