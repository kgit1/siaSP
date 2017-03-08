package com.k1.spitter.checkdb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.k1.spitter.entity.Spitter;

public class MethodsSelect {

	/////////////////////// SELECT/////////////////////////////
	// remember in query quotes in java - field name must equals to name in
	// entity, not table, hibernate will automatically remap field - using
	// @Column name value
	// select all from table,
	// equals SQL "select * from Spitter"
	// List<Spitter> spittersAll = session.createQuery("from
	/////////////////////// Spitter").getResultList();
	public static List<Spitter> spittersAll(SessionFactory factory) {
		// get current session
		Session session = factory.getCurrentSession();
		// start transaction
		session.beginTransaction();
		List<Spitter> spitters = session.createQuery("from Spitter").getResultList();
		session.close();
		return spitters;
	}

	// select user with id = 1
	// equals SQL "select * from spitter where id='1'"
	public static Spitter spitterById(SessionFactory factory, int id) {
		// get current session
		Session session = factory.getCurrentSession();
		// start transaction
		session.beginTransaction();
		Spitter spitter = session.get(Spitter.class, id);
		session.close();
		return spitter;
	}

	// select all with username habuma
	// equals SQL "select * from spitter where userName='habuma'"
	// List<Spitter> spittersByName = session.createQuery("from Spitter s where
	// s.userName='habuma'").getResultList();
	public static List<Spitter> spittersByName(SessionFactory factory, String name) {
		// get current session
		Session session = factory.getCurrentSession();
		// start transaction
		session.beginTransaction();
		List<Spitter> spitters = session.createQuery("from Spitter s where s.userName='" + name + "'").getResultList();
		session.close();
		return spitters;
	}

	// select all with email "artnames@habuma.com",
	// equals SQL "select * from spitter where email='artnames@habuma.com'"
	// List<Spitter> spittersByEmail = session.createQuery("from Spitter s where
	// s.email='artnames@habuma.com'")
	// .getResultList();
	public static List<Spitter> spittersByEmail(SessionFactory factory, String email) {
		// get current session
		Session session = factory.getCurrentSession();
		// start transaction
		session.beginTransaction();
		List<Spitter> spitters = session.createQuery("from Spitter s where s.email='" + email + "'").getResultList();
		session.close();
		return spitters;
	}

	// List<Spitter> spittersByNameAndEmail1 = session
	// .createQuery("from Spitter s where s.email like '%@yahoo.com' and
	// s.userName='iren'").getResultList();
	public static List<Spitter> spittersByNameAndEmailHost(SessionFactory factory, String name, String email) {
		// get current session
		Session session = factory.getCurrentSession();
		// start transaction
		session.beginTransaction();
		List<Spitter> spitters = session
				.createQuery("from Spitter s where s.userName='" + name + "' and s.email='" + email + "'")
				.getResultList();
		session.close();
		return spitters;
	}
}
