package com.k1.spitter.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class SpitterListController {

	@Autowired
	SessionFactory factory;

	// @Transactional
	// // get spitters list and send it to page by adding as attribute to model
	// @GetMapping("home/list")
	// public String spittersList(Model theModel) {
	// // get current hibernate session
	// Session session = factory.getCurrentSession();
	//
	// // get spitters from db
	// List<Spitter> spitters = session.createQuery("from
	// Spitter").getResultList();
	//
	// // add spitters list to model which will go to return page
	// theModel.addAttribute("spitters", spitters);
	//
	// // spitters and spittless lists for left panel
	// theModel.addAttribute("spittersLeft", listSpitters());
	// theModel.addAttribute("spittlesLeft", listSpittles());
	//
	// // lead to list page
	// return "pages/list";
	// }

	//////////////// SORT BY ID /////////////////////
	@Transactional
	@GetMapping("spittersByIdAsc")
	public String spitterByIdAsc(Model theModel) {
		// get current hibernate session
		Session session = factory.getCurrentSession();

		System.out.println("\nSPITTERS ASC\n");

		// create list of spitters and fill it with result of query to database
		List<Spitter> spitters = session.createQuery("from Spitter s order by s.id asc").getResultList();
		theModel.addAttribute("spitters", spitters);

		// spitters and spittless lists for left panel
		theModel.addAttribute("spittersLeft", listSpitters());
		theModel.addAttribute("spittlesLeft", listSpittles());

		// lead to pages/list page
		return "pages/list";
	}

	@Transactional
	@GetMapping("spittersByIdDesc")
	public String spitterByIdDesc(Model theModel) {
		// get current hibernate session
		Session session = factory.getCurrentSession();

		System.out.println("\nSPITTERS DESC\n");

		// create list of spitters and fill it with result of query to database
		List<Spitter> spitters = session.createQuery("from Spitter s order by s.id desc").getResultList();
		theModel.addAttribute("spitters", spitters);

		// spitters and spittless lists for left panel
		theModel.addAttribute("spittersLeft", listSpitters());
		theModel.addAttribute("spittlesLeft", listSpittles());

		// lead to pages/list page
		return "pages/list";
	}

	//////////////// SORT BY USERNAME /////////////////////
	@Transactional
	@GetMapping("spittersByUserAsc")
	public String spitterByUserAsc(Model theModel) {
		// get current hibernate session
		Session session = factory.getCurrentSession();

		System.out.println("\nSPITTERS ASC NAME\n");

		// create list of spitters and fill it with result of query to database
		List<Spitter> spitters = session.createQuery("from Spitter s order by s.userName asc").getResultList();
		theModel.addAttribute("spitters", spitters);

		// spitters and spittless lists for left panel
		theModel.addAttribute("spittersLeft", listSpitters());
		theModel.addAttribute("spittlesLeft", listSpittles());

		// lead to pages/list page
		return "pages/list";
	}

	@Transactional
	@GetMapping("spittersByUserDesc")
	public String spitterByUserDesc(Model theModel) {
		// get current hibernate session
		Session session = factory.getCurrentSession();

		System.out.println("\nSPITTERS DESC NAME\n");

		// create list of spitters and fill it with result of query to database
		List<Spitter> spitters = session.createQuery("from Spitter s order by s.userName desc").getResultList();
		theModel.addAttribute("spitters", spitters);

		// spitters and spittless lists for left panel
		theModel.addAttribute("spittersLeft", listSpitters());
		theModel.addAttribute("spittlesLeft", listSpittles());

		// lead to pages/list page
		return "pages/list";
	}

	//////////////// SORT BY FULLNAME /////////////////////
	@Transactional
	@GetMapping("spittersByFullnameAsc")
	public String spitterByFullnameAsc(Model theModel) {
		// get current hibernate session
		Session session = factory.getCurrentSession();

		System.out.println("\nSPITTERS ASC FULLNAME\n");

		// create list of spitters and fill it with result of query to database
		List<Spitter> spitters = session.createQuery("from Spitter s order by s.fullName asc").getResultList();
		theModel.addAttribute("spitters", spitters);

		// spitters and spittless lists for left panel
		theModel.addAttribute("spittersLeft", listSpitters());
		theModel.addAttribute("spittlesLeft", listSpittles());

		// lead to pages/list page
		return "pages/list";
	}

	@Transactional
	@GetMapping("spittersByFullnameDesc")
	public String spitterByFullnameDesc(Model theModel) {
		// get current hibernate session
		Session session = factory.getCurrentSession();

		System.out.println("\nSPITTERS DESC FULLNAME\n");

		// create list of spitters and fill it with result of query to database
		List<Spitter> spitters = session.createQuery("from Spitter s order by s.fullName desc").getResultList();
		theModel.addAttribute("spitters", spitters);

		// spitters and spittless lists for left panel
		theModel.addAttribute("spittersLeft", listSpitters());
		theModel.addAttribute("spittlesLeft", listSpittles());

		// lead to pages/list page
		return "pages/list";
	}

	//////////////// SORT BY AGE /////////////////////
	/////////////////////////////////////////////////
	@Transactional
	@GetMapping("spittersByAgeAsc")
	public String spitterByAgeAsc(Model theModel) {
		// get current hibernate session
		Session session = factory.getCurrentSession();

		System.out.println("\nSPITTERS ASC AGE\n");

		// create list of spitters and fill it with result of query to database
		List<Spitter> spitters = session.createQuery("from Spitter s order by s.age asc").getResultList();
		theModel.addAttribute("spitters", spitters);

		// spitters and spittless lists for left panel
		theModel.addAttribute("spittersLeft", listSpitters());
		theModel.addAttribute("spittlesLeft", listSpittles());

		// lead to pages/list page
		return "pages/list";
	}

	@Transactional
	@GetMapping("spittersByAgeDesc")
	public String spitterByAgeDesc(Model theModel) {
		// get current hibernate session
		Session session = factory.getCurrentSession();

		System.out.println("\nSPITTERS DESC AGE\n");

		// create list of spitters and fill it with result of query to database
		List<Spitter> spitters = session.createQuery("from Spitter s order by s.age desc").getResultList();
		theModel.addAttribute("spitters", spitters);

		// spitters and spittless lists for left panel
		theModel.addAttribute("spittersLeft", listSpitters());
		theModel.addAttribute("spittlesLeft", listSpittles());

		// lead to pages/list page
		return "pages/list";
	}

	public List<Spitter> listSpitters() {
		// get current hibernate session
		Session session = factory.getCurrentSession();

		// create list of spitters and fill it with result of query to database
		List<Spitter> spitters = session.createQuery("from Spitter").getResultList();
		return spitters;
	}

	public List<Spittle> listSpittles() {
		// get current hibernate session
		Session session = factory.getCurrentSession();

		// create list of spittles and fill it with result of query to database
		List<Spittle> spittles = session.createQuery("from Spittle s order by s.id desc").setMaxResults(15)
				.getResultList();
		return spittles;
	}

	// @Transactional
	// @GetMapping("left")
	// public String fullInfoOnSpitterLeft(Model theModel) {
	// Session session = factory.getCurrentSession();
	// List<Spittle> spittles = session.createQuery("from Spittle",
	// Spittle.class).getResultList();
	// theModel.addAttribute("spittles", spittles);
	// System.out.println("LEFT");
	// return "tiles/aLeft";
	// }

}
