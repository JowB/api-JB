package com.jb.apijb.experience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @GetMapping("/experiences")
    public ResponseEntity<List<Experience>> getExperiences() {
        try {
            List<Experience> experienceList = experienceService.getAllExperiences();

            if (experienceList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(experienceList, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/experiences")
    public ResponseEntity<Experience> createExperience(@RequestBody Experience experience) {
        try {
            experienceService.createExperience(experience);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/experiences/{id}")
    public ResponseEntity<Experience> updateExperience(@PathVariable("id") long id, @RequestBody Experience experience) {
        try {
            Optional<Experience> experienceOptional = experienceService.findExperience(id);

            if (experienceOptional.isPresent()) {
                Experience _experience = experienceOptional.get();
                _experience.setJob(experience.getJob());
                _experience.setCompany(experience.getCompany());
                _experience.setYearStart(experience.getYearStart());
                _experience.setYearEnd(experience.getYearEnd());
                _experience.setLanguages(experience.getLanguages());
                _experience.setDescription(experience.getDescription());

                Experience updatedExperience = experienceService.updateExperience(_experience);

                return new ResponseEntity<>(updatedExperience, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/experiences/{id}")
    public ResponseEntity<HttpStatus> deleteExperience(@PathVariable("id") long id) {
        try {
            experienceService.deleteExperience(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
