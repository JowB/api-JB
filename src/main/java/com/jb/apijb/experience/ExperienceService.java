package com.jb.apijb.experience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    // Récupère la liste des experiences
    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    // Création d'une experience
    public void createExperience(Experience experience) {
        experienceRepository.save(new Experience(experience.getCompany(), experience.getJob(), experience.getDescription(), experience.getYearStart(), experience.getYearEnd(), experience.getLanguages()));
    }
}
