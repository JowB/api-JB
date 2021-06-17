package com.jb.apijb.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProjects() {
        try {
            List<Project> projectList = projectService.getAllProjects();

            if (projectList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(projectList, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/project")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        try {
            projectService.createProject(project);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id") long id, @RequestBody Project project) {
        try {
            Optional<Project> projectOptional = projectService.findProject(id);

            if (projectOptional.isPresent()) {
                Project _project = projectOptional.get();
                _project.setMiniature(project.getMiniature());
                _project.setName(project.getName());
                _project.setDate(project.getDate());
                _project.setDescription(project.getDescription());
                _project.setPicture1(project.getPicture1());
                _project.setPicture2(project.getPicture2());
                _project.setPicture3(project.getPicture3());
                _project.setPicture4(project.getPicture4());
                _project.setTechnologies(project.getTechnologies());

                Project updatedProject = projectService.updateProject(_project);

                return new ResponseEntity<>(updatedProject, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
