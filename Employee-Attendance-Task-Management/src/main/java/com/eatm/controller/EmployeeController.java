package com.eatm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eatm.dao.EmployeeDao;
import com.eatm.dto.AddressDto;
import com.eatm.dto.EmployeeDto;
import com.eatm.dto.TaskDto;
import com.eatm.entity.Employee;
import com.eatm.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/registerManager")
	public String registerManager(@ModelAttribute EmployeeDto employeeDto, @ModelAttribute AddressDto addressDto) 
	{
		return employeeService.registerManager(employeeDto, addressDto);
	}
	
	@RequestMapping("/login")
	public String loginEmployee(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session)
	{
		return employeeService.loginEmployee(email, password, session);
	}
	
	@RequestMapping("/registerDeveloper")
	public String registerDeveloper(@ModelAttribute EmployeeDto employeeDto,                         @ModelAttribute AddressDto addressDto)
	{
		return employeeService.registerDeveloper(employeeDto, addressDto);
	}
	
	@RequestMapping("/displayDeveloperTasks")
	public ModelAndView displayDeveloperTasks() 
	{
	    List<Employee> developers =employeeService.displayAllDevelopers();

	    ModelAndView mav = new ModelAndView();

	    mav.addObject("developers", developers);

	    mav.setViewName("displayDeveloperTasks.jsp");

	    return mav;
	} 
	
	@RequestMapping("/deleteDeveloper")
	public String deleteDeveloper(@RequestParam("employeeId") int employeeId)
	{
		return employeeService.deleteDeveloper(employeeId);
	}
	
	@RequestMapping("/logout")
	public String logout(@RequestParam("attendanceId") int attendanceId)
	{
		return employeeService.logout(attendanceId);
	}
	
	@RequestMapping("/update")
	public String updateDeveloper(@RequestParam(value= "employeeName", required = false) String employeeName, @RequestParam(value= "email", required = false) String email , @RequestParam(value= "phoneNumber", required = false) String phoneNumber, HttpSession session)
	{
		return employeeService.updateDeveloper(employeeName, email, phoneNumber, session);
	}
	
	@RequestMapping("/updatePassword")
	public String updatePassword(@RequestParam("employeeId") int employeeId, @RequestParam("password") String password)
	{
		return employeeService.updatePassword(employeeId, password);
	}
	
	
}
