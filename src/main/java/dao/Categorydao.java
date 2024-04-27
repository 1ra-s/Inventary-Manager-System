package dao;

import Util.HibernateUtils;
import entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class Categorydao {

    private final SessionFactory sessionFactory;

    public Categorydao() {
        sessionFactory = HibernateUtils.getSessionFactory();
    }

    public void create(Category category) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
        }
    }

    public List<Category> getCategories() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Category", Category.class).list();
        }
    }
}
