package com.aman.exception;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorBean {
	
	private String message;
	private LocalDateTime timestamp;
	private String details;
}
