package com.kodnest.MavenProject.HiberateFirst;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Student {
	@Column
	@Id
	int id;
	@Column
	int pwd;
	@Column
	String name;
	@Column
	int age;
	public Student(int id, int pwd, String name, int age) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
	};

}
