package com.k1.spitter.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.k1.spitter.entity.Spitter;

@Controller
public class PagesController {

	@Autowired
	SessionFactory factory;

	@Transactional
	// get spitters list and send it to page by adding as attribute to model
	@GetMapping("/home/list")
	public String printList(Model theModel) {
		Session session = factory.getCurrentSession();
		// session.beginTransaction();

		// get spitters from db
		List<Spitter> spitters = session.createQuery("from Spitter").getResultList();
		// for(Spitter spitter: spitters){
		// System.out.println(spitter);
		// }
		// add spitters list to model which will go to return page
		theModel.addAttribute("spitters", spitters);
		return "pages/list";
	}

	@GetMapping("reg")
	public String reg(Model theModel) {
		Spitter spitter = new Spitter();
		theModel.addAttribute("spitter", spitter);
		return "pages/reg";
	}

	@Transactional
	@PostMapping("/saveSpitter")
	public String saveSpitter(@ModelAttribute("spitter") Spitter spitter) {
		Session session = factory.getCurrentSession();
		session.save(spitter);
		return "redirect:/home/list";
	}
}
