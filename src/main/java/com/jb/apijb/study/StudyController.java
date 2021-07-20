package com.jb.apijb.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudyController {

    private final StudyService studyService;

    @Autowired
    public StudyController(final StudyService studyService) {
        this.studyService = studyService;
    }

    @GetMapping("/studies")
    public ResponseEntity<List<StudyDTO>> getAllStudies() {
        try {
            List<StudyDTO> studyDTOList = studyService.getAllStudies();

            if (studyDTOList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(studyDTOList, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/studies/{id}")
    public ResponseEntity<Study> getStudyById(@PathVariable("id") long id) {
        try {
            Optional<Study> optionalStudy = studyService.getStudyById(id);

            return optionalStudy.map(study -> new ResponseEntity<>(study, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/studies")
    public ResponseEntity<StudyDTO> upsertStudy(@RequestBody StudyDTO studyDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studyService.upsertStudy(studyDTO));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/studies/{id}")
    public ResponseEntity<HttpStatus> deleteStudy(@PathVariable("id") long id) {
        try {
            studyService.deleteStudy(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
