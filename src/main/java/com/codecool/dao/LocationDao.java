package com.codecool.dao;

import com.codecool.util.HibernateUtil;
import com.codecool.entity.Location;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class LocationDao {
    public void saveLocation(Location location) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(location);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List< Location > getLocation() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Location ", Location.class).list();
        }
    }
}
