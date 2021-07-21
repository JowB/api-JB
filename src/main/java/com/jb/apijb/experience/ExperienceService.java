package com.jb.apijb.experience;

import com.jb.apijb.generic.GenericMappingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService extends GenericMappingService<ExperienceDTO, Experience> {

    private final ExperienceRepository experienceRepository;

    public ExperienceService(final ExperienceRepository experienceRepository, final ModelMapper modelMapper) {
        super(modelMapper);
        this.experienceRepository = experienceRepository;
    }

    /**
     * Cette fonction permet de récupérer toutes les expériences en base de données
     *
     * @return list of experience from database {@link List<ExperienceDTO>}
     */
    public List<ExperienceDTO> getAllExperiences() {
        return this.mapListToDto(experienceRepository.findAll(), ExperienceDTO.class);
    }

    /**
     * Cette fonction permet de récupérer une expérience en fonction de son id.
     *
     * @param id experience id
     * @return optionalExperience
     */
    public Optional<Experience> getExperienceById(Long id) {
        return experienceRepository.findById(id);
    }

    /**
     * Cette fonction permet de faire aussi bien l'insert que l'update en base de données.
     *
     * @param experienceDTO {@link ExperienceDTO}
     * @return experienceDTO from database {@link ExperienceDTO}
     */
    public ExperienceDTO upsertExperience(ExperienceDTO experienceDTO) {
        return mapToDto(experienceRepository.save(mapToEntity(experienceDTO, Experience.class)), ExperienceDTO.class);
    }

    public void deleteExperience(long id) {
        experienceRepository.deleteById(id);
    }
}
