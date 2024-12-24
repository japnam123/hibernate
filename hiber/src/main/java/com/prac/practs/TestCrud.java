package com.prac.practs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class TestCrud {

    public static void main(String[] args) {
        // Create SessionFactory
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Create session
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Create (Insert) Employee
            Student student = new Student("John Doe", "john.doe@example.com", 25);
            session.save(student);
            System.out.println("Employee created: " + student.getName());

            // Read (Select) Employee
            Query query = session.createQuery("FROM Employee WHERE id = :id");
            query.setParameter("id", 1);  // Assuming the student with id 1 exists
            List<Student> students = query.list();
            students.forEach(s -> System.out.println("Employee Name: " + s.getName()));

            // Update Employee
            query = session.createQuery("UPDATE Employee SET age = :age WHERE id = :id");
            query.setParameter("age", 26);
            query.setParameter("id", 1);  // Update student with id 1
            int updatedRows = query.executeUpdate();
            System.out.println("Number of records updated: " + updatedRows);

            // Commit transaction
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
