package com.example.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.common.Url;

@Controller
public class MainController {
	
	@GetMapping(value = {Url.MAIN.MAIN})
	public String index() {
		
		return Url.MAIN.MAIN_JSP;
	}
	
	@PostMapping(value = {Url.POSTMAN.PARAM})
	public void test(@RequestBody HashMap<String, Object> param) {
		
		System.out.println(param);
		
	}
}
