package dao;

import Util.HibernateUtils;
import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.persistence.Entity;
import java.util.List;

public class Productdao {

    private final SessionFactory sessionFactory;

    public Productdao() {
        sessionFactory = HibernateUtils.getSessionFactory();
    }

    public void create(Product product) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        }
    }

    public List<Product> getProducts() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Product", Product.class).list();
        }
    }
}
