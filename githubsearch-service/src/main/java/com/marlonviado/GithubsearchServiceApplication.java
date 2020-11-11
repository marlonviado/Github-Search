package com.marlonviado;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import com.marlonviado.config.GitHubSearchCircuitBreakerConfiguration;
import com.marlonviado.config.GitHubSearchEurekaClientConfiguration;
import com.marlonviado.config.GitHubSearchHystrixDashboardConfiguration;
import com.marlonviado.config.GitHubSearchJpaRepositoryConfiguration;

@SpringBootApplication
@Import({GitHubSearchEurekaClientConfiguration.class,
		 GitHubSearchJpaRepositoryConfiguration.class,
		 GitHubSearchHystrixDashboardConfiguration.class,
		 GitHubSearchCircuitBreakerConfiguration.class})
public class GithubsearchServiceApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(GithubsearchServiceApplication.class, args);

		System.out.println("TESTING FOR COMMIT!");

		System.out.println("TESTING FOR COMMIT IN DEV ENVIRONMENT!");


		/*
		 * This will search the actual API of GitHub
		 * This will be used in search
		 */
		/*
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
					functionalLogs.apply("mojombo", j);

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
		*/

		/*
		 * This code is used to search
		 * username of github user
		 */
		/*
		Iterator<String> iterLog = collect.
									returnCollectedLogs().
									iterator();

		Supplier<TransferLog> logSupplier =
				() -> new TransferLog(iterLog);

		TransferLog transfer = logSupplier.get();

		transfer.processTransfer();
		*/

		/*
		 * Remove Repository Duplication ....Just in case
		 */
		/*
		Function<TransferLog,RepositoryCommitter> repCommFunction =
				RepositoryCommitter::new;

		RepositoryCommitter repCom =
				repCommFunction.apply(transfer);
		*/

		/*
		 * List all Repository and Committer for specific user.
		 * Extract key and value and store to map
		 */
		/*
		Function<RepositoryCommitter,CommitterLink> committerLinkFunction =
				CommitterLink::new;

		CommitterLink committer =
				committerLinkFunction.apply(repCom);

		Map<String,String> map = committer.extractRepositoryCommitter();
		for(Map.Entry<String,String> keyValue : map.entrySet()) {
			System.out.println("Key: " + keyValue.getKey() + " " + "Value: " + keyValue.getValue());
		}

		System.out.println("================COMMITTER LINK================");

		String committerLink = committer.requestCommitterLinkForRepository(map, "god");

		System.out.println("COMMITTER LINK : " + committerLink);

		System.out.println("================REPOSITORY LIST PER USER================");
		List<String> repositoryList = committer.requestAllRepositoryPerUser(map);
		Iterator<String> iter = repositoryList.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		*/

	}



}
