package com.eatm.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Component
@Scope(value= "prototype") //tell spring container to create new object everytime
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "attendance_id_generator")
	@SequenceGenerator(name = "attendance_id_generator",initialValue = 201,allocationSize = 1)
	private int attendanceId;
	@CreationTimestamp          //when we create object of Attendance class automatically login time will be noted
	private LocalDateTime loginTime;    //it has to automatically noted
	private LocalDateTime logoutTime;   //we will set it later

}
