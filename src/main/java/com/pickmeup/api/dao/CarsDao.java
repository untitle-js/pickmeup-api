package com.pickmeup.api.dao;

import com.pickmeup.api.model.Cars;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Govind on 12/22/2016.
 */
public class CarsDao {

    public Cars register(Cars car)
    {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try
        {
            session.saveOrUpdate(car);
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
        return car;
    }
}
