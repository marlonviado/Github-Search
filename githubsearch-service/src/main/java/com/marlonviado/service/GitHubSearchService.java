package com.marlonviado.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import org.springframework.stereotype.Service;
import com.marlonviado.logs.ActualLogs;
import com.marlonviado.logs.CommitterLink;
import com.marlonviado.logs.LogsCollector;
import com.marlonviado.logs.RepositoryCommitter;
import com.marlonviado.logs.TransferLog;

@Service
public class GitHubSearchService {
	
	public List<String> getAllRepositoryPerUser(String user) {
		
		/*
		 * This will search the actual GitHub API
		 * This will be used in search
		 */
		boolean finished=false;
		Integer j=1;
		BiFunction<String,Integer,ActualLogs> functionalLogs = 
				ActualLogs::new;
		
		Supplier<LogsCollector> logsSupplier = 
				LogsCollector::new;
		
		LogsCollector collect = 
				logsSupplier.get();
		
		while(!finished) {
			
			ActualLogs actualLogs = 
					functionalLogs.apply(user, j);
			
			String s = actualLogs.request();
			if(s.substring(1, 2).equalsIgnoreCase("{") || 
					s.substring(1, 2).trim()=="{") {
				collect.setLogs(s.toString());
				collect.collect(collect.getLogs());
			}
			else {
				finished=true;
				break;
			}
			if(finished==true) break;
			j++;
		}
			
		/*
		 * This code is used to search 
		 * username on github
		 */
		Iterator<String> iterLog = collect.
									returnCollectedLogs().
									iterator();
		
		Supplier<TransferLog> logSupplier = 
				() -> new TransferLog(iterLog);
				
		TransferLog transfer = logSupplier.get();
		
		transfer.processTransfer();

		/*
		 * Remove Repository Duplication ....Just in case
		 */
		Function<TransferLog,RepositoryCommitter> repCommFunction = 
				RepositoryCommitter::new;
		
		RepositoryCommitter repCom = 
				repCommFunction.apply(transfer);
		
		
		/*
		 * List all Repository and Committer for specific user.
		 * Extract key and value and store to map
		 */
		Function<RepositoryCommitter,CommitterLink> committerLinkFunction = 
				CommitterLink::new;
		
		CommitterLink committer = 
				committerLinkFunction.apply(repCom);
		
		Map<String,String> map = committer.extractRepositoryCommitter();
		//for(Map.Entry<String,String> keyValue : map.entrySet()) {
		//	System.out.println("Key: " + keyValue.getKey() + " " + "Value: " + keyValue.getValue());
		//}
		
		//System.out.println("================COMMITTER LINK================");
		
		//String committerLink = committer.requestCommitterLinkForRepository(map, "god");
		
		//System.out.println("COMMITTER LINK : " + committerLink);
		
		// repository list per user
		List<String> repositoryList = committer.requestAllRepositoryPerUser(map);

		return repositoryList;
	}
	
}
