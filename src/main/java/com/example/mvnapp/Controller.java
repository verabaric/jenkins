package com.example.mvnapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/projects")
public class Controller {
    private final ProjectService projectService;

    @Autowired
    public Controller(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Map<String,String> name) {
        Project createdProject = projectService.create(name);
        return ResponseEntity.ok(createdProject);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        Project project = projectService.find(id);
        return ResponseEntity.ok(project);
    }
    /*
        0800u69788
     */
}