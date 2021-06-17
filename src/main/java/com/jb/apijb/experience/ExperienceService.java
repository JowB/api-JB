package com.jb.apijb.experience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    public void createExperience(Experience experience) {
        experienceRepository.save(new Experience(experience.getCompany(), experience.getJob(), experience.getDescription(), experience.getYearStart(), experience.getYearEnd(), experience.getLanguages()));
    }

    public Experience updateExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    public Optional<Experience> findExperience(long id) {
        return experienceRepository.findById(id);
    }

    public void deleteExperience(long id) {
        experienceRepository.deleteById(id);
    }
}
