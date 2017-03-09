package com.k1.spitter.checkdb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.k1.spitter.entity.Spitter;

public class DbTestHibernateCreateInsert {

	public static void main(String[] args) {

		// class SessionFactory reads the hibernate config file
		// creates Session object heavy-weight object only create once in your
		// app

		// Session wraps a JDBC connection main object used to save\retrieve
		// objects
		// short-lived object retrieved from Seccion factory

		// create session factory if configure() is empty -
		// will use default "hibernate.cfg.xml" from src root
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Spitter.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

//		 start transaction
		 session.beginTransaction();

		/////////////////////// INSERT/////////////////////////////
		// (username, password, fullname, email, update_by_email) values
		// ('habuma', 'password', 'Craig Walls', 'craig@habuma.com', false)

		// create spitters to insert to database
		Spitter spitter1 = new Spitter("paul", "qwerty", "donaldson", "donaldson@yahoo.com", false);
		Spitter spitter2 = new Spitter("paul", "qwerty", "benson", "benson@yahoo.com", false);
		Spitter spitter3 = new Spitter("iren", "qwerty", "donaldson", "iren@yahoo.com", false);
		// insert spitter using available connection session
		session.save(spitter1);
		// commit saving(will close session)
		session.getTransaction().commit();
		// get new session
		session = factory.getCurrentSession();
		// begin transaction
		session.beginTransaction();
		// insert spitters
		session.save(spitter2);
		session.save(spitter3);
		// commit saving(will close session)
		session.getTransaction().commit();

		MethodsCreateInsert.spittersInsert(factory, new Spitter("vorik", "aaaaa", "grin", "gv@gmail.com", false));

		// DbTestHibernateMethods.printSpitters(DbTestHibernateMethods.spittersByName(factory,
		// "paul"));
		MethodsPrint.printSpitters(MethodsReadSelect.spittersAll(factory));

		// don't forget to close factory at the end
		// spring will take on himself handling session open and close, but when
		// we using poor hibernate
		// better way to wrap all it try{}finally{factory.close();} block
		factory.close();
	}
}
