package com.marlonviado.dto;

import lombok.Data;

@Data
public class RepositoryCommitDTO {
	
	private String sha;
	private String node_id;
	private CommitDTO commitDTO;
	private String url;
	private String html_url;
	private String comments_url;
	
	

}