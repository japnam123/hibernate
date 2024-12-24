package com.student;

//Employee.java
public class Employee {
 private String name;
 private Address address; // Dependency (Address)

 // Getter and Setter for name and address
 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public Address getAddress() {
     return address;
 }

 public void setAddress(Address address) {
     this.address = address;
 }

 // Method to display employee details along with address
 public void displayDetails() {
     System.out.println("Employee Name: " + name);
     System.out.println("Address: " + address.getStreet() + ", " + address.getCity() + ", " + address.getState());
 }
}
