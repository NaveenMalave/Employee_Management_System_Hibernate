package com.kodnest.MavenProject.EmployeeHibernateProject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class EmployeeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	String name;
	
	@Column
	int password;
	@Column
	int salary;
	@Column
	String address;
	public EmployeeDetails() {
		super();
	}
	public EmployeeDetails(String name, int password, int salary, String address) {
		super();
		this.name = name;
		this.password = password;
		this.salary = salary;
		this.address = address;
	}
public EmployeeDetails(int id, String name, int password, int salary, String address) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.salary = salary;
		this.address = address;
	}
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Password: " + password + ", Salary: " + salary + ", Address: " + address;
    }



}
