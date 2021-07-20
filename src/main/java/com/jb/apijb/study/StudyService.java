package com.jb.apijb.study;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudyService {

    private final StudyRepository studyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public StudyService(final StudyRepository studyRepository, final ModelMapper modelMapper) {
        this.studyRepository = studyRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Récupère la liste de toutes les études
     *
     * @return List de StudyDTO {@link StudyDTO}
     */
    public List<StudyDTO> getAllStudies() {
        return this.mapListToDto(studyRepository.findAll());
    }

    /**
     * Récupère une étude en fonction de son id
     *
     * @param id de Study
     * @return optional study {@link Study}
     */
    public Optional<Study> getStudyById(Long id) {
        return studyRepository.findById(id);
    }

    /**
     * Cette fonction permet de faire aussi bien l'insert que l'update en base de données
     *
     * @param studyDTO {@link StudyDTO}
     * @return studyDTO from database {@link StudyDTO}
     */
    public StudyDTO upsertStudy(StudyDTO studyDTO) {
        return this.mapToDto(studyRepository.save(this.mapToEntity(studyDTO)));
    }

    /**
     * Supprime une étude en fonction de son id
     *
     * @param id de Study
     */
    public void deleteStudy(long id) {
        studyRepository.deleteById(id);
    }

    private Study mapToEntity(StudyDTO studyDTO) {
        return modelMapper.map(studyDTO, Study.class);
    }

    private StudyDTO mapToDto(Study study) {
        return modelMapper.map(study, StudyDTO.class);
    }

    private List<StudyDTO> mapListToDto(List<Study> studyList) {
        return studyList
                .stream()
                .map(element -> modelMapper.map(element, StudyDTO.class))
                .collect(Collectors.toList());
    }
}
