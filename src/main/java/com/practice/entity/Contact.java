package com.practice.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;

@Entity
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contactId;
	private String contactName;
	private long contactNum;

	@ManyToOne()
	private User user;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public long getContactNum() {
		return contactNum;
	}
	public void setContactNum(long contactNum) {
		this.contactNum = contactNum;
	}

}
