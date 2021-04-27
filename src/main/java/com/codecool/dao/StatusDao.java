package com.codecool.dao;

import com.codecool.util.HibernateUtil;
import com.codecool.entity.Status;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StatusDao {

    public void saveStatus(Status status) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(status);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Status> getStatus() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Status ", Status.class).list();
        }
    }

    public static Status getStatusById(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Status.class, id);
        }
    }
}

