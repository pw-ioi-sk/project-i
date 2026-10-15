package org.example.dao;

import org.example.modal.Employee;
import org.example.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.table.TableRowSorter;
import java.util.List;

public class EmployeeDAO {
    public List<Employee> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Employee order by id",
                    Employee.class)
                    .list();
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public Employee findById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Employee.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public void save(Employee employee) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                if (employee == null) return;
                session.persist(employee);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public void delete(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                Employee employee = session.find(Employee.class, id);
                if (employee == null) return;
                session.remove(employee);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw e;
            }

        } catch (RuntimeException e) {
            throw e;
        }
    }

    public void update(Employee employee) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                if (employee == null) return;
                session.merge(employee);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw e;
            }

        } catch (RuntimeException e) {
            throw e;
        }
    }
}
