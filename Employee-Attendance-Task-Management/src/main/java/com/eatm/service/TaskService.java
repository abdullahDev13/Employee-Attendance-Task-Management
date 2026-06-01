package com.eatm.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.eatm.dao.EmployeeDao;
import com.eatm.dao.TaskDao;
import com.eatm.dto.TaskDto;
import com.eatm.entity.Employee;
import com.eatm.entity.Status;
import com.eatm.entity.Task;

import jakarta.servlet.http.HttpSession;

@Service
public class TaskService {
	
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	TaskDao taskdao;
	@Autowired
	EmployeeDao employeedao;
	
	public String addTask(TaskDto taskdto)
	{
	  Task task= modelMapper.map(taskdto, Task.class);
	  
	  task.setStatus(Status.CREATED);
	  
	  taskdao.saveTask(task);
	  
	  return "success.jsp";
	}

	public String assignTask(int taskId, int employeeId) 
	{
		Task dbtask= taskdao.findTaskById(taskId);
		Employee dbemployee= employeedao.findEmployeeById(employeeId);
		
		List<Task> taskList= dbemployee.getTaskList();
		
		if(taskList==null)
		{
			taskList= new ArrayList<Task>();
		}
		
		dbtask.setStatus(Status.ASSIGNED);
		taskdao.updateTask(dbtask);
		
		taskList.add(dbtask);
		
		dbemployee.setTaskList(taskList);
		
		employeedao.updateEmployee(dbemployee);
		
		return "success.jsp";
	}

	public Employee viewTask(HttpSession session) 
	{
		int employeeId= (int) session.getAttribute("employeeId");
		return employeedao.findEmployeeById(employeeId);
	}

	public String changeTaskStatus(int taskId) 
	{
		Task dbTask= taskdao.findTaskById(taskId);
		dbTask.setStatus(Status.COMPLETED);
		taskdao.updateTask(dbTask);
		return "success.jsp";
	}

}
