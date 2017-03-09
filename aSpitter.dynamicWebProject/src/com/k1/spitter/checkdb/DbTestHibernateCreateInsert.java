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

		// start transaction
		session.beginTransaction();

		/////////////////////// INSERT/////////////////////////////
		// (username, password, fullname, email, update_by_email) values
		// ('habuma', 'password', 'Craig Walls', 'craig@habuma.com', false)

		// create spitters to insert to database
		Spitter spitter1 = new Spitter("paul", "qwerty", 22,"donaldson", "donaldson@yahoo.com", false);
		Spitter spitter2 = new Spitter("paul", "qwerty", 22,"benson", "benson@yahoo.com", false);
		Spitter spitter3 = new Spitter("iren", "qwerty", 22,"donaldson", "iren@yahoo.com", false);
		Spitter spitter4 = new Spitter("iren", "qwerty", 22,"donaldson", "iren@yahoo.com", false);
		Spitter spitter5 = new Spitter("habuma", "qwerty", 22,"Craig Walls", "craig@habuma.com", false);
		Spitter spitter6 = new Spitter("habuma", "qwerty1", 22,"Craig Walls", "craig@habuma.com", false);
		Spitter spitter7 = new Spitter("habuma", "qwerty11", 22,"Craig Walls", "craig@habuma.com", false);
		Spitter spitter8 = new Spitter("artnames", "qwerty", 22,"Art Names", "artnames@habuma.com", false);
		Spitter spitter9 = new Spitter("artnames", "qwerty", 22,"Art Names", "artnames@habuma.com", false);
		Spitter spitter10 = new Spitter("artnames", "qwerty", 22,"Art Names", "artnames@habuma.com", false);
		Spitter spitter11 = new Spitter("artnames", "qwerty", 22,"Art", "artnames@habuma.com", false);
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
		session.save(spitter4);
		session.save(spitter5);
		session.save(spitter6);
		session.save(spitter7);
		session.save(spitter8);
		session.save(spitter9);
		session.save(spitter10);
		session.save(spitter11);
		
		// commit saving(will close session)
		session.getTransaction().commit();

		MethodsCreateInsert.spittersInsert(factory, new Spitter("vorik", "aaaaa", 22,"grin", "gv@gmail.com", false));

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
