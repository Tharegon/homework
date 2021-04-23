package com.codecool.dao;

import com.codecool.HibernateUtil;
import com.codecool.entity.PlantOrder;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class PlantOrderDao {
    public void saveOrder(PlantOrder order) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(order);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List< PlantOrder > getOrders() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from PlantOrder", PlantOrder.class).list();
        }
    }
}
