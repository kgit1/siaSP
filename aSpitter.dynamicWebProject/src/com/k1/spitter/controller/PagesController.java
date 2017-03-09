package com.k1.spitter.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		List<Spitter> spitters = session.createQuery("from Spitter").getResultList();
		// for(Spitter spitter: spitters){
		// System.out.println(spitter);
		// }
		theModel.addAttribute("spitters", spitters);
		return "pages/list";
	}

	@GetMapping("reg")
	public String reg(Model theModel) {
		Spitter spitter = new Spitter();
		theModel.addAttribute("spitter",spitter);
		return "pages/reg";
	}
}
