package com.k1.spitter.checkdb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.k1.spitter.entity.Spitter;

public class DbTestHibernateMethods {

	public static List<Spitter> spittersAll(SessionFactory factory) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Spitter> spitters = session.createQuery("from Spitter").getResultList();
		session.close();
		return spitters;
	}

	public static List<Spitter> spittersByName(SessionFactory factory, String name) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Spitter> spitters = session.createQuery("from Spitter s where s.userName='" + name + "'").getResultList();
		session.close();
		return spitters;
	}

	public static List<Spitter> spittersByEmail(SessionFactory factory, String email) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Spitter> spitters = session.createQuery("from Spitter s where s.email='" + email + "'").getResultList();
		session.close();
		return spitters;
	}

	public static void printSpitters(List<Spitter> spitters) {
		for (Spitter spitter : spitters) {
			System.out.println(spitter);
		}
	}
}
