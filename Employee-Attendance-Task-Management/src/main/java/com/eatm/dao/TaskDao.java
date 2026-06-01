package com.eatm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eatm.entity.Task;

@Repository
public class TaskDao {
	
	@Autowired
	EntityManager entityManager;
	@Autowired
	EntityTransaction entityTransaction;
	
	public Task saveTask(Task task) {
		entityTransaction.begin();
		entityManager.persist(task);
		entityTransaction.commit();
		return task;
	}
	
	public Task updateTask(Task task) {
		entityTransaction.begin();
		entityManager.merge(task);
		entityTransaction.commit();
		return task;
	}
	
	public Task deleteTask(Task task) {
		entityTransaction.begin();
		entityManager.remove(task);
		entityTransaction.commit();
		return task;
	}
	
	public Task findTaskById(int taskId) {
		return entityManager.find(Task.class, taskId);
	}

}
