package org.example.dao;

import org.example.model.Employee;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDao {
    // READ
    public List<Employee> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Employee order by id",
                    Employee.class)
                    .list();
        } catch (RuntimeException e) {
            throw e;
        }
    }

    // READ
    public Employee findById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Employee.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    //CREATE
    public void save(Employee employee) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                if (employee == null) return;
                session.persist(employee);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            }
        } catch (RuntimeException e) {
            throw e;
        }
    }

    // DELETE
    public void delete(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Employee employee = session.find(Employee.class, id);
                if (employee == null) return;
                session.remove(employee);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            }
        } catch (RuntimeException e) {
            throw e;
        }
    }

    // UPDATE
    public void update(Employee employee) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                if (employee == null) return;
                session.merge(employee);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            }
        } catch (RuntimeException e) {
            throw e;
        }

    }
}
