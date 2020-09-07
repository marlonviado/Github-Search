package com.marlonviado.dto;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class LogDTO {
	
	private Integer id;
	private String node_id;
	private String name;
	private String full_name;
	
	@SerializedName("private")
	private boolean privates;
	
	private OwnerDTO owner;
	private String html_url;
	private String description;
	private boolean fork;
	private String url;
	private String forks_url;
	private String keys_url;
	private String collaborators_url;
	private String teams_url;
	private String hooks_url;
	private String issue_events_url;
	private String events_url;
	private String assignees_url;
	private String branches_url;
	private String tags_url;
	private String blobs_url;
	private String git_tags_url;
	private String git_refs_url;
	private String trees_url;
	private String statuses_url;
	private String languages_url;
	private String stargazers_url;
	private String contributors_url;
	private String subscribers_url;
	private String subscription_url;
	private String commits_url;
	private String git_commits_url;
	private String comments_url;
	private String issue_comment_url;
	private String contents_url;
	private String compare_url;
	private String merges_url;
	private String archive_url;
	private String downloads_url;
	private String issues_url;
	private String pulls_url;
	private String milestones_url;
	private String notifications_url;
	private String labels_url;
	private String releases_url;
	private String deployments_url;
	
	//private LocalDateTime created_at;
	//private LocalDateTime updated_at;
	//private LocalDateTime pushed_at;
	//private String git_url;
	//private String ssh_url;
	//private String clone_url;
	//private String svn_url;
	//private String homepage;
	//private long size;
	//private long stargazers_count;
	//private long watchers_count;
	//private String language;
	
	

}
