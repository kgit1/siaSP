package com.k1.spitter.checkdb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.k1.spitter.entity.Spitter;

public class MethodsPrint {

	public static void printSpitters(List<Spitter> spitters) {
		for (Spitter spitter : spitters) {
			System.out.println(spitter);
		}
	}
}
