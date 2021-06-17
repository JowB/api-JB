package com.jb.apijb.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    /**
     * Get all the projects
     */
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    /**
     * Create new project
     */
    public void createProject(Project project) {
        projectRepository.save(new Project(project.getMiniature(), project.getName(), project.getDate(), project.getDescription(), project.getPicture1(), project.getPicture2(), project.getPicture3(), project.getPicture4(), project.getTechnologies()));
    }

    /**
     * Update existing project
     */
    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }

    /**
     * Find project by id
     */
    public Optional<Project> findProject(long id) {
        return projectRepository.findById(id);
    }

    public void deleteProject(long id) {
        projectRepository.deleteById(id);
    }
}
