package com.pickmeup.api.dao;

import java.text.Format;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pickmeup.api.model.Users;

public class UserDao {
	
	public Users registerUser()
	{
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
 
		Users user = new Users();
		user.setFirstName("Selva");
		user.setLastName("Raj");
		user.setEmail("selva@mail.com");
		user.setAddress("Hopkins");
		user.setPhoneNum(23534262);
		user.setUserId(12);
		user.setPwd("abcd1234");
		java.util.Date uDate = new java.util.Date();
		Date date = new Date(uDate.getTime());
		user.setDateOfBirth(date);
		
		try
		{
			
		
		session.save(user);
 
		session.getTransaction().commit();
		}
		catch(Exception ex)
		{
			System.out.print(ex.getMessage());
			session.getTransaction().rollback();
		}
		finally
		{
			session.close();
		}
			
		return user;
	}

}
