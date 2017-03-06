package com.k1.spitter.checkdb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.k1.spitter.entity.Spitter;

public class DbTestHibernate {

	public static void main(String[] args) {

		// class SessionFactory
		// reads the hibernate config file
		// creates Session object
		// heavy-weight object
		// only create once in your app

		// Session
		// wraps a JDBC connection
		// main object used to save\retrieve objects
		// short-lived object
		// retrieved from Seccion factory

		// create session factory
		// if configure() is empty -
		// will use default "hibernate.cfg.xml" from src root
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Spitter.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		// start transaction
		session.beginTransaction();

		/////////////////////// SELECT/////////////////////////////
		// remember in query quotes in java - field name must equals to name in
		// entity, not table, hibernate will automatically remap field - using
		// @Column name value
		// select all from table,
		// equals SQL "select * from Spitter"
		List<Spitter> spittersAll = session.createQuery("from Spitter").getResultList();
		// select all with username "habuma",
		// equals SQL "select * from spitter where username='habuma'"
		List<Spitter> spittersByName = session.createQuery("from Spitter s where s.userName='habuma'").getResultList();
		// select all with username "habuma",
		// equals SQL "select * from spitter where email='habuma'"
		List<Spitter> spittersByEmail = session.createQuery("from Spitter s where s.email='artnames@habuma.com'")
				.getResultList();

		/////////////////////// INSERT/////////////////////////////
		// (username, password, fullname, email, update_by_email) values
		// ('habuma', 'password', 'Craig Walls', 'craig@habuma.com', false)

//		session.beginTransaction();
		Spitter spitter1 = new Spitter("paul", "qwerty", "donaldson", "donaldson@yahoo.com", false);
		Spitter spitter2 = new Spitter("paul", "qwerty", "benson", "benson@yahoo.com", false);
		Spitter spitter3 = new Spitter("iren", "qwerty", "donaldson", "iren@yahoo.com", false);
		session.save(spitter1);
		session.getTransaction().commit();
		session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(spitter2);
		session.save(spitter3);
		session.getTransaction().commit();

		// don't forget to close factory at the end
		// spring will take on himself handling session open and close, but when
		// we using poor hibernate
		// better way to wrap all it try{}finally{factory.close();} block
		factory.close();

		for (Spitter spitter : spittersAll) {
			System.out.println(spitter);
		}
		for (Spitter spitter : spittersByName) {
			System.out.println(spitter);
		}
		for (Spitter spitter : spittersByEmail) {
			System.out.println(spitter);
		}
	}

}
