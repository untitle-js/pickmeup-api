package com.pickmeup.api.dao;

import com.pickmeup.api.model.Carpool;
import com.pickmeup.api.model.CarpoolUsers;
import com.pickmeup.api.model.CarpoolUsersDetails;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by selva on 3/6/2017.
 */
public class CarpoolDao {

    public List<Carpool> listCarpool()
    {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Date date = new Date();
        Timestamp current_timestamp =new Timestamp(date.getTime());
        System.out.println(current_timestamp);
        String hql=String.format("FROM Carpool c WHERE c.startingTime >=:current_timestamp");
        Query q =session.createQuery(hql);
        q.setParameter("current_timestamp", current_timestamp);
        List<Carpool> carsList = q.list();
        session.close();
        return carsList;
    }

    public List<String> listCarpoolUserIds(String carpoolId)
    {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql=String.format("SELECT userId " +
                "FROM CarpoolUsers c where c.carpoolId=:carpoolId");
        Query q =session.createQuery(hql);
        q.setParameter("carpoolId", carpoolId);
        List<String> carsList = q.list();
        session.close();
        return carsList;
    }

    public List<CarpoolUsersDetails> listCarpoolUsers(Map<String, String> params)
    {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String carpoolId = params.get("carpoolId");
        List<String> userIds = listCarpoolUserIds(carpoolId);
        int[] ids = new int[userIds.size()];
        for(int i=0; i< userIds.size(); i++){
            ids[i] = Integer.parseInt(userIds.get(i));
        }
        String hql=String.format("FROM Users as u where u.userId in (:userIds)");
        Query q =session.createQuery(hql);
        //q.setParameterList("userIds", ids);
        List<CarpoolUsersDetails> carsList = q.list();
        session.close();
        return carsList;
    }

    public Carpool addCarpool(Carpool carpool)
    {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try
        {
            session.saveOrUpdate(carpool);
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
        return carpool;
    }

    public CarpoolUsers addCarpoolUser(CarpoolUsers carpoolUser)
    {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try
        {
            session.saveOrUpdate(carpoolUser);
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
        return carpoolUser;
    }
}
