package com.marlonviado.logs;

import java.io.IOException;
import java.util.Optional;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import com.marlonviado.util.GitHubConnection;

/**
 * This is the actual request happen
 * @author marlon_viado
 *
 */
public class ActualLogs {
	
	private String username;
	private Integer pageNo;
	
	public ActualLogs() {		
	}
	
	public ActualLogs(String username,Integer pageNo) {
		this.username=username;
		this.pageNo=pageNo;
	}
	
	public String request() {
		Optional<String> optionalLogs = 
				getRequest(this.username,this.pageNo);
		return optionalLogs.get();
	}
	
	public Optional<String> getRequest(String login, int pageCount) {
		
		String URL = "https://api.github.com/users/" + login +"/repos?per_page=100&page="+ pageCount;

		Optional<String> json;
		
		try {
			
			GitHubConnection connection = 
					GitHubConnection.open();
			
			HttpGet request = 
					connection.gitHubGet(URL);
			
			connection.addHeader(request);
			
			HttpResponse response = 
					connection.execute(request);
			
			String responseFromHttpGet = 
					EntityUtils.toString(response.getEntity(), "UTF-8");
			
			json = Optional.ofNullable(responseFromHttpGet);
			
			return json;
			
		} catch (IOException ex) {
			System.out.println(ex.getStackTrace());
		}
		
		return null;
	}


}
