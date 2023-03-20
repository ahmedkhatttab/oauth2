package com.example.resource_server;

import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.representations.adapters.config.PolicyEnforcerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
// (exclude = SecurityAutoConfiguration.class)
public class ResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceServerApplication.class, args);
	}


//	@Bean
//	@Primary
//	public KeycloakSpringBootProperties properties() {
//		final KeycloakSpringBootProperties props = new KeycloakSpringBootProperties();
//		final PolicyEnforcerConfig policyEnforcerConfig = new PolicyEnforcerConfig();
////		policyEnforcerConfig.setLazyLoadPaths(true);
////		PolicyEnforcerConfig.PathConfig pathConfig = new PolicyEnforcerConfig.PathConfig();
////		pathConfig.setPath("/*");
////		policyEnforcerConfig.setPaths(List.of(pathConfig));
//		policyEnforcerConfig.setEnforcementMode(PolicyEnforcerConfig.EnforcementMode.ENFORCING);
//		policyEnforcerConfig.setUserManagedAccess(new PolicyEnforcerConfig.UserManagedAccessConfig());
//		props.setPolicyEnforcerConfig(policyEnforcerConfig);
//		return props;
//	}



}
