package com.codecool.dao;

import com.codecool.HibernateUtil;
import com.codecool.entity.Marketplace;
import com.codecool.entity.PlantOrder;
import com.codecool.entity.Status;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MarketplaceDao {

    public void saveMarketplace(Marketplace marketplace) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(marketplace);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Marketplace> getMarketplaces() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Marketplace ", Marketplace.class).list();
        }
    }

    public Marketplace getMarketplaceById(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Marketplace.class, id);
        }
    }
}

