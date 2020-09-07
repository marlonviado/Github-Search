package com.marlonviado.logs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CommitterLink {
	
	private RepositoryCommitter repositoryCommitter;
	
	public CommitterLink() {}
	
	public CommitterLink(RepositoryCommitter repositoryCommitter) {
		this.repositoryCommitter=repositoryCommitter;
	}
	
	public Map<String,String> extractRepositoryCommitter() {
		Map<String,String> map = new HashMap<>();
		String key="";
		String value = "";
		Iterator<String> iter = this.repositoryCommitter.removeDuplicate().iterator();
		while(iter.hasNext()) {
			String iterValue = iter.next();
			int index = iterValue.indexOf('-');
			int lastIndex = iterValue.lastIndexOf('-');
			if(iterValue.substring(index, lastIndex+1)!=" ") {
				lastIndex = iterValue.lastIndexOf(' ');
				index=lastIndex;
				key = iterValue.substring(iterValue.indexOf('-')+1, index-1).trim();
				value = iterValue.substring(index+1, iterValue.length()).trim();
			}
			else {
				key = iterValue.substring(index+2, lastIndex).trim();
				value = iterValue.substring(lastIndex+2, iterValue.length()).trim();
			}
			
			map.put(key, value);
		}
		
		return map;

	}
	
	public String requestCommitterLinkForRepository(Map<String,String> map, String repository) {
		Optional<String> opt = Optional.ofNullable(repository);
		Optional<String> ret = Optional.ofNullable("");
		for(Map.Entry<String, String> keyValue : map.entrySet()) {
			if(keyValue.getKey().equalsIgnoreCase(opt.get())) {
				ret = Optional.ofNullable(keyValue.getValue());
			}
		}
		return ret.orElse("No Committer Link");
	}
	
	public List<String> requestAllRepositoryPerUser(Map<String,String> map) {
		List<String> repositoryList = new ArrayList<>();
		for(Map.Entry<String, String> m : map.entrySet()) {
			repositoryList.add(m.getKey());
		}
		return repositoryList;
	}

}
