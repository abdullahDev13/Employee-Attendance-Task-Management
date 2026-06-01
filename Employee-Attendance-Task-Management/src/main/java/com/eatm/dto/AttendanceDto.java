package com.eatm.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttendanceDto {
	
	private int attendanceId;
	private LocalDateTime loginTime;
	private LocalDateTime logoutTime;

}
