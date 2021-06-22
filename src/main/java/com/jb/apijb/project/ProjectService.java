package com.jb.apijb.project;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectService(final ProjectRepository projectRepository, final ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Get all the projects
     */
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    /**
     * Get one project by id
     */
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    /**
     * Cette fonction permet de faire aussi bien l'insert que l'update en base de données.
     *
     * @param projectDTO {@link ProjectDTO}
     * @return projectDTO from database {@link ProjectDTO}
     */
    public ProjectDTO upsertProject(ProjectDTO projectDTO) {
        return this.mapToDto(projectRepository.save(this.mapToEntity(projectDTO)));
    }

    /**
     * Find project by id
     */
    public ProjectDTO findProject(long id) throws ProjectException{

        Optional<Project> optionalProjet = projectRepository.findById(id);

        return this.mapToDto(optionalProjet.orElseThrow(() -> new ProjectException("Aucun projet trouvé avec l'id "+id)));
    }

    public void deleteProject(long id) {
        projectRepository.deleteById(id);
    }

    private Project mapToEntity(ProjectDTO projectDTO) {
        return modelMapper.map(projectDTO, Project.class);
    }

    private ProjectDTO mapToDto(Project project) {
        return modelMapper.map(project, ProjectDTO.class);
    }
}
