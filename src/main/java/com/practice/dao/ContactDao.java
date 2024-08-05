package com.practice.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.practice.config.EMFSingleton;
import com.practice.entity.Contact;
import com.practice.entity.User;

public class ContactDao {
	public boolean saveContact(Contact contact) {
		EntityManager manager = EMFSingleton.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(contact);
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
	public List<Contact> findContactsByUser(User user){
		EntityManager manager = EMFSingleton.getFactory().createEntityManager();
		TypedQuery<Contact> query = manager.createQuery("from Contact where user= :userId", Contact.class);
		query.setParameter("userId", user);
		List<Contact> result = query.getResultList();
		return result;
	}

	public boolean updateContact(Contact contact) {
		EntityManager manager = EMFSingleton.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(contact);
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

	public Contact findContact(int contactId) {
		EntityManager manager = EMFSingleton.getFactory().createEntityManager();
		Contact contact = manager.find(Contact.class, contactId);
		return contact;
	}

	public boolean deleteContact (int customerId) {
		EntityManager manager = EMFSingleton.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Contact contact = manager.find(Contact.class, customerId);
			manager.remove(contact);
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

}
