package com.example.resource_server.controller;

import com.example.resource_server.security.Identity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.UUID;

@RestController
public class CourseController {

	@Autowired
	private HttpServletRequest request;

//	@Autowired
//	private CourseService couseService;

	@GetMapping(value = "/courses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getCourse(@PathVariable("id") long id, Model model) throws JsonProcessingException {
		configCommonAttributes(model);
		return "Welcome in getCourse ...";
	}

	@GetMapping(value = "/courses/teacher/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getTeacherCourses(@PathVariable("id") long id, Model model) throws JsonProcessingException {
		configCommonAttributes(model);
		return "Welcome in getTeacherCourses ...";
	}
	
	@DeleteMapping("/courses/{id}")
	public String deleteStudent(@PathVariable long id) {
		return "welcome in delete student...";
	}

	@PostMapping("/courses")
	public ResponseEntity<Void> createCourse() {
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(UUID.randomUUID()).toUri();

		return ResponseEntity.created(location).build();

	}



	private void configCommonAttributes(Model model) {
//		model.addAttribute("identity", new Identity(getKeycloakSecurityContext()));
	}

	private KeycloakSecurityContext getKeycloakSecurityContext() {
		return (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
	}

}