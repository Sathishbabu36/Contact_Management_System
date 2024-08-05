package com.practice.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.practice.config.EMFSingleton;
import com.practice.entity.User;

public class UserDao {
	public boolean saveUser(User user) {
		EntityManager manager = EMFSingleton.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(user);
			transaction.commit();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			manager.close();
		}
	}

	public boolean updateUser(User user) {
		EntityManager manager = EMFSingleton.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(user);
			transaction.commit();
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		finally {
			manager.close();
		}
	}

	public boolean deleteUser(int userId) {
		EntityManager manager = EMFSingleton.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			User user = manager.find(User.class, userId);
			manager.remove(user);
			transaction.commit();
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		finally {
			manager.close();
		}
	}
	
	public User findUserByEmailAndPassword(String email, String password) {
		EntityManager manager = EMFSingleton.getFactory().createEntityManager();
		User user = null;
		try {
			TypedQuery<User> query = manager.createQuery("from User where email= :email and password= :password", User.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			user  = query.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			manager.close();
		}
		return user;
	}
}
