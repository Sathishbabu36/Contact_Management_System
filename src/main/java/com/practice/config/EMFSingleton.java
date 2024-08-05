package com.practice.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFSingleton {
	private EMFSingleton() {

	}
	static EntityManagerFactory factory;

	public static synchronized EntityManagerFactory getFactory() {
		if(factory == null)
			factory = Persistence.createEntityManagerFactory("abc");
		return factory;
	}
}
