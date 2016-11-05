package com.pickmeup.api.dao;

import com.pickmeup.api.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.text.SimpleDateFormat;

import java.sql.Date;
import java.util.Map;

public class UserDao {
	
	public Users registerUser(Map <String,String> parm)
	{
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yy");
		Users user = new Users();
		user.setFirstName(parm.get("firstName"));
		user.setLastName(parm.get("lastName"));
		user.setEmail(parm.get("email"));
		user.setAddress(parm.get("address"));
		user.setPhoneNum(Integer.parseInt(parm.get("phoneNumber")));
		user.setUserId(Integer.parseInt(parm.get("userId")));
		user.setPwd(parm.get("password"));
		java.util.Date uDate = new java.util.Date();
  		Date date = new Date(uDate.getTime());
		user.setDateOfBirth(date);
		
		try
		{		
			session.saveOrUpdate(user);	 
			session.getTransaction().commit();
		}
		catch(Exception ex)
		{
			session.getTransaction().rollback();
			throw ex;
		}
		finally
		{
			session.close();
		}
			
		return user;
	}

}
