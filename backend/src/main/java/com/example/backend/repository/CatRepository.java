package com.example.backend.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.backend.domain.entity.Cat;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class CatRepository {

    private final SessionFactory sessionFactory;

    public CatRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveCat(Cat cat) {

//        Session session = sessionFactory.openSession();
//        Transaction transaction = null;
//
//        try {
//            transaction = session.beginTransaction();
//            session.save(cat);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }

        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(cat);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
