package com.k1.spitter.checkdb;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.k1.spitter.entity.Spitter;

public class DbTestHibernateReWrite {

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
		// Session session = factory.getCurrentSession();
		Session session = factory.openSession();

		List<Spitter> spitters = session.createQuery("from Spitter").getResultList();

		//////// TRUNCATE
		// SET FOREIGN_KEY_CHECKS = 0;
		// TRUNCATE table1;
		// SET FOREIGN_KEY_CHECKS = 1;

		session.beginTransaction();
		session.createNativeQuery("SET FOREIGN_KEY_CHECKS = 0").executeUpdate();
		session.createNativeQuery("truncate table Spitter").executeUpdate();
		session.createNativeQuery("SET FOREIGN_KEY_CHECKS = 1").executeUpdate();
		session.getTransaction().commit();
		/////////////////////

		session = factory.openSession();
		session.beginTransaction();

		for (Spitter spitter : spitters) {
			spitter.setTime(null);
			spitter.setDate(null);
			spitter.setTimestamp(null);
			session.save(spitter);
		}
		session.getTransaction().commit();


		factory.close();
	}
}
