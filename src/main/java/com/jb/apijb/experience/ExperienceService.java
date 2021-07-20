package com.jb.apijb.experience;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExperienceService {

    private final ExperienceRepository experienceRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ExperienceService(final ExperienceRepository experienceRepository, final ModelMapper modelMapper) {
        this.experienceRepository = experienceRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Cette fonction permet de récupérer toutes les expériences en base de données
     *
     * @return list of experience from database {@link List<ExperienceDTO>}
     */
    public List<ExperienceDTO> getAllExperiences() {
        return this.mapListToDto(experienceRepository.findAll());
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
        return mapToDto(experienceRepository.save(mapToEntity(experienceDTO)));
    }

    public void deleteExperience(long id) {
        experienceRepository.deleteById(id);
    }

    private Experience mapToEntity(ExperienceDTO experienceDTO) {
        return modelMapper.map(experienceDTO, Experience.class);
    }

    private ExperienceDTO mapToDto(Experience experience) {
        return modelMapper.map(experience, ExperienceDTO.class);
    }

    private List<ExperienceDTO> mapListToDto(List<Experience> experienceList) {
        return experienceList
                .stream()
                .map(element -> modelMapper.map(element, ExperienceDTO.class))
                .collect(Collectors.toList());
    }
}
