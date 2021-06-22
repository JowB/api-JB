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

    @GetMapping("/experiences/{id}")
    public ResponseEntity<Experience> getExperienceById(@PathVariable("id") long id) {
        try {
            Optional<Experience> experienceOptional = experienceService.getExperienceById(id);

            return experienceOptional.map(experience -> new ResponseEntity<>(experience, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/experiences")
    public ResponseEntity<ExperienceDTO> createExperience(@RequestBody ExperienceDTO experienceDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(experienceService.upsertExperience(experienceDTO));
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
