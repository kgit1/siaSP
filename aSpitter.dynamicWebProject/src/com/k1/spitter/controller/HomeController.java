package com.k1.spitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//add controller annotation to help spring find controller
@Controller
public class HomeController {

	// add requestMapping to give link for our method
	// @RequestMapping("/list") - work for all HTTP request methods

	// usual choise
	// GET method - good for debaging, bookmarks,email url
	// limitation on data lenght near 1000 signs
	// @RequestMapping(path-"/list". method=RequestMethod.GET)
	// same as
	// GetMapping("/list")

	// choise for paswords and files
	// POST method - bad for bookmarks, no limits on data length,
	// also can send binary data(like when u need to save file)
	// @RequestMapping(path-"/list". method=RequestMethod.POST)
	// same as
	// PostMapping("/list")
	
	@GetMapping("/home")
	public String home() {
		return "/WEB-INF/view/home.jsp";
	}

}
