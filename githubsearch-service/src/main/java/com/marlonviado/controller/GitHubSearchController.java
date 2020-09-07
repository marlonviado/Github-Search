package com.marlonviado.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.marlonviado.helper.Response;
import com.marlonviado.service.GitHubSearchService;

@RestController
public class GitHubSearchController {
	
	@Autowired
	GitHubSearchService searchService;
	
	@GetMapping("/{username}")
	public ResponseEntity<List<String>> getUsername(@PathVariable String username) {
		List<String> repositoryList = searchService.getAllRepositoryPerUser(username);
		return Response.returned(repositoryList);
	}
	
	//@GetMapping("/{repository}")
	//public ResponseEntity<String> getCommitterLink(@PathVariable String repository) {
	//	String committerLink = "";
	//	return Response.returned(committerLink);
	//}

}
