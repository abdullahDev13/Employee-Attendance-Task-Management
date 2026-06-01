package com.eatm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//1,2,3..
	private int employeeId;
	private String employeeName;
	@Column(unique = true,nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(unique = true)
	private long phoneNumber;
	private double salary;
	private String role;
	
	@OneToOne
	private Address address;
	@OneToMany
	private List<Task> taskList;
	@OneToMany
	private List<Attendance> attendanceList;
	

}
