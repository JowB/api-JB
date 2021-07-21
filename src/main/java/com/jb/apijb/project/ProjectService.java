package com.jb.apijb.project;

import com.jb.apijb.generic.GenericMappingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService extends GenericMappingService<ProjectDTO, Project> {

    private final ProjectRepository projectRepository;

    public ProjectService(final ProjectRepository projectRepository, final ModelMapper modelMapper) {
        super(modelMapper);
        this.projectRepository = projectRepository;
    }

    /**
     * Récupère la liste des projets
     *
     * @return list projectDto
     */
    public List<ProjectDTO> getAllProjects() {
        return this.mapListToDto(projectRepository.findAll(), ProjectDTO.class);
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
        return this.mapToDto(projectRepository.save(this.mapToEntity(projectDTO, Project.class)), ProjectDTO.class);
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
}
