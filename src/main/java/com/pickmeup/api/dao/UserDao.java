package com.pickmeup.api.dao;

import com.pickmeup.api.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.util.List;
import java.util.Map;
public class UserDao {
	
	public Users register(Users user)
	{
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
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

	public Users validateUser(Map <String ,String> allRequest)
	{
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String emailId = allRequest.get("emailId");
		String hql = String.format("FROM Users u WHERE u.email = :email_id");
		Query q =session.createQuery(hql);
		q.setParameter("email_id",emailId);
		List<Users> userList = q.list();
        return userList.get(0);
	}


}
