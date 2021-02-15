package kotlarchik.service;

import kotlarchik.dao.DAO;
import kotlarchik.model.Manufact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceManufact implements DAO<Manufact, Integer> {
    private final SessionFactory factory;

    public ServiceManufact(SessionFactory factory){
        this.factory = factory;
    }

    public void create(Manufact manufact) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(manufact);
            session.getTransaction().commit();
        }
    }

    public Manufact read(Integer id) {
        try(Session session = factory.openSession()) {
            Manufact manufact = session.get(Manufact.class, id);
            return manufact;
        }
    }

    public List<Manufact> readAll() {
        try(Session session = factory.openSession()) {
            Query<Manufact> result = session.createQuery("FROM Manufact");
            return result.list();
        }
    }

    public void update(Manufact manufact) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(manufact);
            session.getTransaction().commit();
        }
    }

    public void delete(Manufact manufact) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(manufact);
            session.getTransaction().commit();
        }
    }
}
