package com.marlonviado.dto;

import lombok.Data;

@Data
public class CommitDTO {
	
	private AuthorDTO authorDTO;
	private CommitterDTO committerDTO;
	private String message;

}
