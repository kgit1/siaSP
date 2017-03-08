package com.k1.spitter.checkdb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.k1.spitter.entity.Spitter;

//hibernate criteria (to read)https://www.tutorialspoint.com/hibernate/hibernate_criteria_queries.htm
public class DbTestHibernateDelete {

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

	

		factory.close();

	}
}