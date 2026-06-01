package com.eatm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eatm.entity.Attendance;

@Repository
public class AttendanceDao {

	@Autowired
	EntityManager entityManager;
	@Autowired
	EntityTransaction entityTransaction;
	
	public Attendance saveAttendance(Attendance attendance) {
		entityTransaction.begin();
		entityManager.persist(attendance);
		entityTransaction.commit();
		return attendance;
	}
	
	public Attendance updateAttendance(Attendance attendance) {
		entityTransaction.begin();
		entityManager.merge(attendance);
		entityTransaction.commit();
		return attendance;
	}
	
	public Attendance findById(int id) {
		return entityManager.find(Attendance.class, id);
	}
}
