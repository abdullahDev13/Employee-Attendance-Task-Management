package com.eatm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eatm.dto.TaskDto;
import com.eatm.entity.Employee;
import com.eatm.entity.Task;
import com.eatm.service.TaskService;

import jakarta.servlet.http.HttpSession;

@Controller
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@RequestMapping("/addTask")
	public String addTask(@ModelAttribute TaskDto taskdto)
	{
		return taskService.addTask(taskdto);
	}
	
	@RequestMapping("/assignTask")
	public String assignTask(@RequestParam("taskId") int taskId, @RequestParam("employeeId") int employeeId)
	{
		return taskService.assignTask(taskId, employeeId);
	}
	
	@RequestMapping("/viewTask")
	public ModelAndView viewTask(HttpSession session)
	{
		Employee dbemployee= taskService.viewTask(session);
		ModelAndView mav= new ModelAndView();
		mav.addObject("dbemployee",dbemployee);
		mav.setViewName("viewTask.jsp");
		return mav;
	}
	
	@RequestMapping("/changeTaskStatus")
	public String changeTaskStatus(@RequestParam("taskId") int taskId)
	{
		return taskService.changeTaskStatus(taskId);
	}

}
