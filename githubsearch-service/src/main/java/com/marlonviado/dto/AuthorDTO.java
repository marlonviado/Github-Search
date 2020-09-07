package com.marlonviado.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class AuthorDTO {
	
	private String name;
	private String email;
	private LocalDateTime date;

}