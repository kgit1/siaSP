package com.k1.spitter.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

	@Autowired
	SessionFactory factory;

	@GetMapping("/home/list")
	public String printList(Model theModel) {
		return "pages/list";
	}
}
