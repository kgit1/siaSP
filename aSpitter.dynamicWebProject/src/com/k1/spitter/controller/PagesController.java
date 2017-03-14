package com.k1.spitter.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.k1.spitter.entity.Spitter;
import com.k1.spitter.entity.Spittle;

@Controller
public class PagesController {

	@Autowired
	SessionFactory factory;

	@Transactional
	// get spitters list and send it to page by adding as attribute to model
	@GetMapping("/home/list")
	public String printList(Model theModel) {
		// get current hibernate session
		Session session = factory.getCurrentSession();

		// get spitters from db
		List<Spitter> spitters = session.createQuery("from Spitter").getResultList();

		// add spitters list to model which will go to return page
		theModel.addAttribute("spitters", spitters);
		
		List<Spittle> spittles = session.createQuery("from Spittle", Spittle.class).getResultList();
		theModel.addAttribute("spittles", spittles);
		
		// lead to list page
		return "pages/list";
	}

	@GetMapping("reg")
	public String reg(Model theModel) {
		// create new spitter
		Spitter spitter = new Spitter();
		// add spitter to model as atribute "spitter"
		theModel.addAttribute("spitter", spitter);
		// lead to reg page
		return "pages/reg";
	}

	@Transactional
	@PostMapping("/saveSpitter")
	public String saveSpitter(@Valid @ModelAttribute("spitter") Spitter spitter, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "pages/reg";
		}

		// get current hibernate session
		Session session = factory.getCurrentSession();
		// save or update
		session.saveOrUpdate(spitter);
		// redirect to list page, redirect will recreate page with new
		// independent model
		return "redirect:/home/list";
	}

	@Transactional
	@GetMapping("showFormForUpdate")
	// here we sent to method parameter id, requesting it from model by
	// @RequestParam("spitterId") int id
	public String showFormForUpdate(@RequestParam("spitterId") int id, Model theModel) {
		// get current hibernate session
		Session session = factory.getCurrentSession();

		// create spitter and transfer certain spitter from db, received by id
		Spitter spitter = session.get(Spitter.class, id);
		// set timestamp time and date in our spitter to null, because they
		// automatically created by db
		spitter.setTimestamp(null);
		spitter.setTime(null);
		spitter.setDate(null);

		// add spitter as attribute to model by addAttribute() method which
		// requests as params - objects name in model and object
		theModel.addAttribute("spitter", spitter);

		// lead us with model next to reg page
		return "pages/reg";
	}

	@Transactional
	@GetMapping("delete")
	public String deleteSpitter(@RequestParam("spitterId") int id) {
		Session session = factory.getCurrentSession();
		session.createQuery("delete from Spitter where id=" + id).executeUpdate();
		return "redirect:home/list";
	}

	@Transactional
	@GetMapping("info")
	public String fullInfoOnSpitter(@RequestParam("spitterId") int id, Model theModel) {
		Session session = factory.getCurrentSession();
		Spitter spitter = session.get(Spitter.class, id);
		for (Spittle spittle : spitter.spittles) {
			System.out.println(spittle);
		}
		theModel.addAttribute("spitter", spitter);
		theModel.addAttribute("spittles", spitter.spittles);
		return "pages/spitterFullInfo";
	}

	@Transactional
	@GetMapping("left")
	public String fullInfoOnSpitterLeft(Model theModel) {
		Session session = factory.getCurrentSession();
		List<Spittle> spittles = session.createQuery("from Spittle", Spittle.class).getResultList();
		theModel.addAttribute("spittles", spittles);
		System.out.println("LEFT");
		return "tiles/aLeft";
	}

}
