package com.marlonviado.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CommitterDTO {

	private String name;
	private String email;
	private LocalDateTime date;
	private String message;
	
}