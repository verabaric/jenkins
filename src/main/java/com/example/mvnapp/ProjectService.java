package com.example.mvnapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project create(Map<String,String> name) {
        Project project = new Project(name.get("name"));
        return projectRepository.save(project);
    }

    public Project find(Long id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return project;
    }
}