package com.proyecto.springboot.form.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	
	
	@RequestMapping(value = "/holamundo", method = RequestMethod.GET)
	public  @ResponseBody String holamundo() {
				
		return "hola mundo";
	}
	
	
}
