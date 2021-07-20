package com.jb.apijb.project;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
     * Récupère la liste des projets
     *
     * @return list projectDto
     */
    public List<ProjectDTO> getAllProjects() {
        return this.mapListToDto(projectRepository.findAll());
    }

    /**
     * Récupère un projet en fonction de son id
     *
     * @param id project id
     * @return optional project
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
     * Récupère un project en fonction de son id
     *
     * @param id project id
     * @return projectDto {@link ProjectDTO}
     * @throws ProjectException exception {@link ProjectException}
     */
    /**public ProjectDTO findProject(long id) throws ProjectException{

        Optional<Project> optionalProjet = projectRepository.findById(id);

        return this.mapToDto(optionalProjet.orElseThrow(() -> new ProjectException("Aucun projet trouvé avec l'id "+id)));
    }**/

    /**
     * Supprime un project en fonction de son id
     * @param id project id
     */
    public void deleteProject(long id) {
        projectRepository.deleteById(id);
    }

    private Project mapToEntity(ProjectDTO projectDTO) {
        return modelMapper.map(projectDTO, Project.class);
    }

    private ProjectDTO mapToDto(Project project) {
        return modelMapper.map(project, ProjectDTO.class);
    }

    private List<ProjectDTO> mapListToDto(List<Project> projectList) {
        return projectList
                .stream()
                .map(element -> modelMapper.map(element, ProjectDTO.class))
                .collect(Collectors.toList());
    }
}
