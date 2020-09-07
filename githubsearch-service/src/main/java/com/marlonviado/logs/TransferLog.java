package com.marlonviado.logs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.marlonviado.dto.LogDTO;
import com.marlonviado.dto.OwnerDTO;

public class TransferLog {
	
	private Iterator<String> iter;
	private List<LogDTO> logDTOList;
	
	public TransferLog(Iterator<String> iter) {
		this.iter=iter;
		logDTOList = new ArrayList<>();
	}
	
	public void processTransfer() {
		
		Gson gson = new Gson();

		Supplier<LogDTO> logDTOSupplier = LogDTO::new;
		
		while(this.iter.hasNext()) {
			
			String str = (String)this.iter.next();
			
			if(str==null) {
				break;
			}
			
			JsonElement jsonelement = new JsonParser().parse(str);
				
			JsonArray jsonArray = jsonelement.getAsJsonArray();

			OwnerDTO ownerDTO = new OwnerDTO();

			for (int i = 0; i < jsonArray.size(); i++) {

				JsonObject jsonObject = (JsonObject) jsonArray.get(i);

				Integer id = jsonObject.get("id").getAsInt();
				String node_id = jsonObject.get("node_id").toString();
				String name = jsonObject.get("name").toString();
				String full_name = jsonObject.get("full_name").toString();
				String owner = jsonObject.get("owner").toString();
				String html_url = jsonObject.get("html_url").toString();
				String description = jsonObject.get("description").toString();
				boolean fork = jsonObject.get("fork").getAsBoolean();
				String url = jsonObject.get("url").toString();
				String forks_url = jsonObject.get("forks_url").toString();
				String keys_url = jsonObject.get("keys_url").toString();
				String collaborators_url = jsonObject.get("collaborators_url").toString();
				String teams_url = jsonObject.get("teams_url").toString();
				String hooks_url = jsonObject.get("hooks_url").toString();
				String issue_events_url = jsonObject.get("issue_events_url").toString();
				String events_url = jsonObject.get("events_url").toString();
				String assignees_url = jsonObject.get("assignees_url").toString();
				String branches_url = jsonObject.get("branches_url").toString();
				String tags_url = jsonObject.get("tags_url").toString();
				String commits_url = jsonObject.get("commits_url").toString();
				String archive_url = jsonObject.get("archive_url").toString();
				String blobs_url = jsonObject.get("blobs_url").toString();					
				String comments_url = jsonObject.get("comments_url").toString();
				String compare_url = jsonObject.get("compare_url").toString();
				String contents_url = jsonObject.get("contents_url").toString();
				String contributors_url = jsonObject.get("contributors_url").toString();
				String deployments_url = jsonObject.get("deployments_url").toString();					
				String downloads_url = jsonObject.get("downloads_url").toString();					
				String git_commits_url = jsonObject.get("git_commits_url").toString();
				String git_refs_url = jsonObject.get("git_refs_url").toString();
				String git_tags_url = jsonObject.get("git_tags_url").toString();					
				String issue_comment_url = jsonObject.get("issue_comment_url").toString();					
				String issues_url = jsonObject.get("issues_url").toString();					
				String labels_url = jsonObject.get("labels_url").toString();
				String languages_url = jsonObject.get("languages_url").toString();
				String merges_url = jsonObject.get("merges_url").toString();
				String milestones_url = jsonObject.get("milestones_url").toString();
				String notifications_url = jsonObject.get("notifications_url").toString();
				String pulls_url = jsonObject.get("pulls_url").toString();
				String releases_url = jsonObject.get("releases_url").toString();
				String stargazers_url = jsonObject.get("stargazers_url").toString();
				String statuses_url = jsonObject.get("statuses_url").toString();
				String subscribers_url = jsonObject.get("subscribers_url").toString();
				String subscription_url = jsonObject.get("subscription_url").toString();
				String trees_url = jsonObject.get("trees_url").toString();
					
					
				LogDTO logDTO = logDTOSupplier.get();
					
				logDTO.setArchive_url(archive_url);
				logDTO.setAssignees_url(assignees_url);
				logDTO.setBlobs_url(blobs_url);
				logDTO.setBranches_url(branches_url);
				logDTO.setCollaborators_url(collaborators_url);
				logDTO.setComments_url(comments_url);
				logDTO.setCommits_url(commits_url);
				logDTO.setCompare_url(compare_url);
				logDTO.setContents_url(contents_url);
				logDTO.setContributors_url(contributors_url);
				logDTO.setDeployments_url(deployments_url);
				logDTO.setDescription(description);
				logDTO.setDownloads_url(downloads_url);
				logDTO.setEvents_url(events_url);
				logDTO.setFork(fork);
				logDTO.setForks_url(forks_url);
				logDTO.setFull_name(full_name);
				logDTO.setGit_commits_url(git_commits_url);
				logDTO.setGit_refs_url(git_refs_url);
				logDTO.setGit_tags_url(git_tags_url);
				logDTO.setHooks_url(hooks_url);
				logDTO.setHtml_url(html_url);
				logDTO.setId(id);
				logDTO.setIssue_comment_url(issue_comment_url);
				logDTO.setIssue_events_url(issue_events_url);
				logDTO.setIssues_url(issues_url);
				logDTO.setKeys_url(keys_url);
				logDTO.setLabels_url(labels_url);
				logDTO.setLanguages_url(languages_url);
				logDTO.setMerges_url(merges_url);
				logDTO.setMilestones_url(milestones_url);
				logDTO.setName(name);
				logDTO.setNode_id(node_id);
				logDTO.setNotifications_url(notifications_url);			
				ownerDTO = gson.fromJson(owner, OwnerDTO.class);
				logDTO.setOwner(ownerDTO);
				logDTO.setPulls_url(pulls_url);
				logDTO.setReleases_url(releases_url);
				logDTO.setStargazers_url(stargazers_url);
				logDTO.setStatuses_url(statuses_url);
				logDTO.setSubscribers_url(subscribers_url);
				logDTO.setSubscription_url(subscription_url);
				logDTO.setTags_url(tags_url);
				logDTO.setTeams_url(teams_url);
				logDTO.setTrees_url(trees_url);
				logDTO.setUrl(url);
				
				logDTOList.add(logDTO);
			}

		}

	}
	
	public List<LogDTO> logDTO() {
		return logDTOList;
	}

}
