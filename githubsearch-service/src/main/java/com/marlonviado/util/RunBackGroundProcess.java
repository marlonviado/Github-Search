package com.marlonviado.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

public class RunBackGroundProcess implements Runnable {
	
	private Integer noDays;
	
	public RunBackGroundProcess(Integer noDays) {
		this.noDays=noDays;
		System.out.println("this.noDays : " + this.noDays);
	}
	@Override
	public void run() {

		// remove existing file
		FileUtil fileUtil = 
				FileUtil.open();
		
		// location of log file
		String fileLoc = 
				fileUtil.logFileLocation();
		
		try {
			fileUtil.deleteFile(fileLoc.substring(1, fileLoc.length()) + "log.json");
			
			/*
			 * Write to log.json file
			 * This will be used in search
			 */
			File f = fileUtil.createFile("log.json", "");
			FileWriter ff = new FileWriter(f);

			for (int i = 0; i < this.noDays;) {
				//String s = getRequest("",i);
				//ff.write(s.toString()+"\n");
				i = i + 200;
			}
			System.out.println("Processing Done!");
			ff.close();
			
		}
		catch(IOException exception) {
			System.out.println(exception.getMessage());
		}
		
	}
	
	public static String getRequest(String user, int pageCount) {
		
		//String URL = "https://api.github.com/repositories?since=" + since + "&access_token=9079ed1d27a6532ed05c87ef7f9e614949efa416";
		String URL = "https://api.github.com/users/" + user +"/repos?per_page=100&page="+ pageCount;

		String json="";
		
		try {
			
			GitHubConnection connection = 
					GitHubConnection.open();
			
			HttpGet request = 
					connection.gitHubGet(URL);
			
			connection.addHeader(request);
			
			HttpResponse response = 
					connection.execute(request);
			
			json = 
					EntityUtils.toString(response.getEntity(), "UTF-8");
			
		} catch (IOException ex) {
			System.out.println(ex.getStackTrace());
		}
		
		return json;
	}


}
