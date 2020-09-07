package com.marlonviado.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class GitHubConnection {
	
	private GitHubConnection() {
	}
	
	public static class GitHubConnectionHelper {
		private static GitHubConnection instance = new GitHubConnection();
	}
	
	public static GitHubConnection open() {
		return GitHubConnectionHelper.instance;
	}
	
	public HttpGet gitHubGet(String URL) {
		return new HttpGet(URL);
	}
	
	public void addHeader(HttpGet get) {
		get.addHeader("content-type", "application/json");
	}
	
	public HttpResponse execute(HttpGet get) throws IOException {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		return httpClient.execute(get);
	}

}
