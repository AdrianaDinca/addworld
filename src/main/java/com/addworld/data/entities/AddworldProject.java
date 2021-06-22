package com.addworld.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADDWORLD_PROJECT")
public class AddworldProject {

	@Id
	@Column(name="PROJECT_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer projectId;

	@Column(name="NAME")
	private String name;

	@Column(name="STATUS")
	private String status;

	@Column(name="TEAM_ID")
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
	@Override
	public String toString() {
		return "AddworldProject [projectId=" + projectId + ", name=" + name + ", status=" + status + ", teamId="
				+ teamId + "]";
	}
	
	
}
