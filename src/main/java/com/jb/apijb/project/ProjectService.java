package com.jb.apijb.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public void createProject(Project project) {
        projectRepository.save(new Project(project.getMiniature(), project.getName(), project.getDate(), project.getDescription(), project.getPicture1(), project.getPicture2(), project.getPicture3(), project.getPicture4(), project.getTechnologies()));
    }
}
