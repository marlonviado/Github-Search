package com.marlonviado.logs;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class LogsCollector {
	
	private String logs;
	private List<String> logsList;
	
	public LogsCollector() {
		logsList = new ArrayList<>();
	}
	
	public LogsCollector(String logs) {
		this.logs=logs;
		logsList = new ArrayList<>();
	}
	
	public void collect(String logs) {
		logsList.add(logs);
	}
	
	public List<String> returnCollectedLogs() {
		return this.logsList;
	}
	
	public Integer count() {
		return this.logsList.size();
	}

}
