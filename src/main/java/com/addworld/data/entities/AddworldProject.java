package com.addworld.data.entities;

public class AddworldProject {
	
	public enum Status {
		TODO,
		IN_PROGRESS,
		DONE
	}
	
	private Integer projectId;
	private String name;
	private String status;
	private Integer teamId;
	
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	
}
