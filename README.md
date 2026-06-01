# Employee Attendance & Task Management System

A web-based Employee Attendance and Task Management System developed using Java, Spring MVC, Hibernate, JSP, and PostgreSQL. The application helps organizations manage employees, track attendance, assign tasks, and monitor task completion through role-based access control.

## Features

### Manager Module
- Manager Registration and Login
- Add Developer Accounts
- View All Developers
- Assign Tasks to Developers
- Delete Developer Records
- Monitor Assigned Tasks

### Developer Module
- Secure Login
- View Assigned Tasks
- Update Task Status
- Update Personal Details
- Change Password
- Logout with Attendance Tracking

### Attendance Management
- Automatic attendance creation on login
- Logout time recording
- Attendance history maintenance

### Task Management
- Create Tasks
- Assign Tasks to Developers
- Track Task Status
- Mark Tasks as Completed

## Technology Stack

### Backend
- Java
- Spring MVC
- Hibernate (JPA)
- Maven

### Frontend
- JSP
- HTML
- CSS

### Database
- PostgreSQL

### Tools
- Eclipse IDE
- Apache Tomcat

## Project Architecture

The project follows a layered architecture:

```
Controller Layer
       ↓
Service Layer
       ↓
DAO Layer
       ↓
Database
```

### Packages Structure

```
com.eatm.controller
├── EmployeeController
└── TaskController

com.eatm.service
├── EmployeeService
└── TaskService

com.eatm.dao
├── EmployeeDao
├── AttendanceDao
├── AddressDao
└── TaskDao

com.eatm.entity
├── Employee
├── Attendance
├── Address
├── Task
└── Status

com.eatm.dto
├── EmployeeDto
├── AttendanceDto
├── AddressDto
└── TaskDto
```

## Database Entities

### Employee
- Employee ID
- Employee Name
- Email
- Password
- Phone Number
- Role

### Address
- City
- State
- Country
- Pincode

### Attendance
- Attendance ID
- Login Time
- Logout Time

### Task
- Task ID
- Task Name
- Description
- Status

## Task Status Flow

```
CREATED
   ↓
ASSIGNED
   ↓
COMPLETED
```

## Screenshots

### Manager Dashboard
- Add Developer
- Create Task
- Assign Task
- View Developers

### Developer Dashboard
- View Assigned Tasks
- Update Task Status
- Update Profile
- Change Password

*(Add screenshots here after uploading images.)*

## Installation & Setup

### Prerequisites

- JDK 8 or above
- Maven
- PostgreSQL Server
- Apache Tomcat
- Eclipse IDE

### Clone Repository

```bash
git clone https://github.com/abdullahDev13/Employee-Attendance-Task-Management.git
```

## Key Learning Outcomes

- Spring MVC Architecture
- Hibernate ORM and JPA Mappings
- Session Management
- Role-Based Authentication
- CRUD Operations
- DTO to Entity Mapping using ModelMapper
- One-to-One and One-to-Many Relationships
- Task Lifecycle Management

## Future Enhancements

- Spring Boot Migration
- REST API Integration
- Email Notifications
- Dashboard Analytics
- JWT Authentication
- Role-Based Security using Spring Security

## Author

**Abdullah Ansari**

- B.Tech CSE (AI/ML)
- Java Full Stack Developer
