package com.mazecode.web.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.mazecode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Controller
@EnableWebMvc
@RequestMapping(value = "/api")
public class ApiController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/all")
	public List all() {
		return userService.all();
	}
	
	@ResponseStatus(value= HttpStatus.OK)
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces={"application/json"})
	public @ResponseBody List list() {
		return userService.all();
	}
	
}
