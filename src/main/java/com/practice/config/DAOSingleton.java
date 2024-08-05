package com.practice.config;

import com.practice.dao.ContactDao;
import com.practice.dao.UserDao;

public class DAOSingleton {
	private DAOSingleton() {

	}
	private static UserDao userDao;
	private static ContactDao contactDao;

	public static synchronized UserDao getuserDao() {
		if(userDao == null)
			userDao = new UserDao();
		return userDao;
	}

	public static synchronized ContactDao getContactDao() {
		if(contactDao == null)
			contactDao = new ContactDao();
		return contactDao;
	}
}
