package com.addworld.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.addworld.data.entities.AddworldProject;

@Repository
public interface AddworldProjectRepository extends JpaRepository<AddworldProject, Integer> {

		public List<AddworldProject> findByName(String name);
		
		public List<AddworldProject> findByTeamId(Integer teamId);
}
