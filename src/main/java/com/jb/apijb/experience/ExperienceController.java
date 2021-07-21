package com.jb.apijb.experience;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ExperienceController {

    private final ExperienceService experienceService;

    public ExperienceController(final ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("/experiences")
    public ResponseEntity<List<ExperienceDTO>> getExperiences() {
        try {
            List<ExperienceDTO> experienceDTOList = experienceService.getAllExperiences();

            if (experienceDTOList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(experienceDTOList, HttpStatus.OK);
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
