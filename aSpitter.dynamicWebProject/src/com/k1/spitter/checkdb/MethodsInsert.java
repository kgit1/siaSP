package com.k1.spitter.checkdb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.k1.spitter.entity.Spitter;

public class MethodsInsert {

	/////////////////////// INSERT/////////////////////////////
	// (username, password, fullname, email, update_by_email) values
	// ('habuma', 'password', 'Craig Walls', 'craig@habuma.com', false)
	public static void spittersInsert(SessionFactory factory, Spitter spitter) {
		// get current session
		Session session = factory.getCurrentSession();
		// start transaction
		session.beginTransaction();
		// save spitter to database
		session.save(spitter);
		// force transaction
		session.getTransaction().commit();
	}
}
