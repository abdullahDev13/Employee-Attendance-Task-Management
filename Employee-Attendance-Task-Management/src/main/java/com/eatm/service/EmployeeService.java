package com.eatm.service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.eatm.dao.AddressDao;
import com.eatm.dao.AttendanceDao;
import com.eatm.dao.EmployeeDao;
import com.eatm.dao.TaskDao;
import com.eatm.dto.AddressDto;
import com.eatm.dto.EmployeeDto;
import com.eatm.entity.Address;
import com.eatm.entity.Attendance;
import com.eatm.entity.Employee;
import com.eatm.entity.Task;

import jakarta.servlet.http.HttpSession;


@Service
public class EmployeeService {

	@Autowired
	ModelMapper modelMapper;
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	AddressDao addressDao;
	
	public String registerManager(EmployeeDto employeeDto,AddressDto addressDto) {
		//write logic to save address and employee in table
		
		//we need to convert all dto objects into entity object
		//also transfer data  from dto to entity
		//which obj has to be converted,into which object
		Address address=modelMapper.map(addressDto, Address.class);
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		//set address to employee
		employee.setAddress(address);
		employee.setRole("manager");
		//save both objects
		addressDao.saveAddress(address);
		employeeDao.saveEmployee(employee);
		return "success.jsp";
	}
	
	@Autowired
	Attendance attendence;
	@Autowired
	AttendanceDao attendanceDao;
	
	public String loginEmployee(String email, String password, HttpSession session)
	{
		Employee dbEmployee= employeeDao.findEmployeebyEmailAndPassword(email, password);
		if(dbEmployee != null)
		{
			//login success-create attendence
			attendanceDao.saveAttendance(attendence);
			
			//map attendence to emplopyee
			List<Attendance> attendanceList= dbEmployee.getAttendanceList();
			if(attendanceList==null)
			{
				attendanceList= new ArrayList<Attendance>();
			}
			attendanceList.add(attendence);
			dbEmployee.setAttendanceList(attendanceList);
			employeeDao.updateEmployee(dbEmployee);
			
			if(dbEmployee.getRole().equals("manager"))
			{
				return "manager.jsp";
			}
			else if(dbEmployee.getRole().equals("developer"))
			{
				int employeeId= dbEmployee.getEmployeeId();
				session.setAttribute("employeeId", employeeId);
				return "developer.jsp";
			}
			return "success.jsp";
		}
		else
		{
			//login failure
			return "login.jsp";
		}
	}
	
	public String registerDeveloper(EmployeeDto employeeDto, AddressDto addressDto)
	{
		//write logic to save address and employee in table
		
		//we need to convert all dto objects into entity object
		//also transfer data  from dto to entity
		//which obj has to be converted,into which object
		
		Address address= modelMapper.map(addressDto, Address.class);
		Employee employee= modelMapper.map(employeeDto, Employee.class);
		
		//set address to employee
		employee.setAddress(address);
		employee.setRole("developer");
		
		//save both objects
		addressDao.saveAddress(address);
		employeeDao.saveEmployee(employee);
		return "success.jsp";
		
	}
	
	public List<Employee> displayAllDevelopers() 
	{
	    return employeeDao.findAllEmployee();
	}
	
	@Autowired
	TaskDao taskDao;
	
	public String deleteDeveloper(int employeeId)
	{
        if(employeeId != 0)
        {
        	Employee dbemployee= employeeDao.findEmployeeById(employeeId);
        	employeeDao.deleteEmployee(dbemployee);
        	
        	return "success.jsp";
        }
        return "failed.jsp";
	}


	public String logout(int attendanceId) 
	{
		 Attendance dbattendance= attendanceDao.findById(attendanceId);
		 dbattendance.setLogoutTime(LocalDateTime.now());
		 attendanceDao.updateAttendance(dbattendance);
		 return "success.jsp";
	}

	public String updateDeveloper(String employeeName, String email, String phoneNumber, HttpSession session) 
	{
		int employeeId= (int) session.getAttribute("employeeId");
	
        Employee dbemployee= employeeDao.findEmployeeById(employeeId);
 		
		if(employeeName != null)
		{
 		 dbemployee.setEmployeeName(employeeName);
		}
		else if(email != null)
		{
			dbemployee.setEmail(email);
		}
		else if(phoneNumber != null)
		{
			long phonenumber= Long.parseLong(phoneNumber);
			dbemployee.setPhoneNumber(phonenumber);
		}
		
		employeeDao.updateEmployee(dbemployee);
		
		return "success.jsp";
	}

	public String updatePassword(int employeeId, String password) 
	{
		Employee dbemployee= employeeDao.findEmployeeById(employeeId);
		
		if(dbemployee != null)
		{
			dbemployee.setPassword(password);
			employeeDao.updateEmployee(dbemployee);
			return "success.jsp";
		}
		return "failed.jsp";
	}
	
	
}

