package com.example.demo.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class empdata {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String city;
	private int salary;
	private String fname;

	public empdata() {
		super();
		// TODO Auto-generated constructor stub
	}

	public empdata(int id, String name, String city, int salary, String fname) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.salary = salary;
		this.fname = fname;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	@Override
	public String toString() {
		return "empdata [id=" + id + ", name=" + name + ", city=" + city + ", salary=" + salary + ", fname=" + fname
				+ "]";
	}

}
