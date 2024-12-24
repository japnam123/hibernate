package com.student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringDI {
    public static void main(String[] args) {
        // Load Spring configuration from XML
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Retrieve Employee bean
        Employee employee = (Employee) context.getBean("employee");

        // Display Employee details along with Address
        employee.displayDetails();
    }
}
