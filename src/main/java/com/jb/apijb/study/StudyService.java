package com.jb.apijb.study;

import com.jb.apijb.generic.GenericMappingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudyService extends GenericMappingService<StudyDTO, Study> {

    private final StudyRepository studyRepository;

    public StudyService(final StudyRepository studyRepository, final ModelMapper modelMapper) {
        super(modelMapper);
        this.studyRepository = studyRepository;
    }

    /**
     * Récupère la liste de toutes les études
     *
     * @return List de StudyDTO {@link StudyDTO}
     */
    public List<StudyDTO> getAllStudies() {
        return this.mapListToDto(studyRepository.findAll(), StudyDTO.class);
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
        return this.mapToDto(studyRepository.save(this.mapToEntity(studyDTO, Study.class)), StudyDTO.class);
    }

    /**
     * Supprime une étude en fonction de son id
     *
     * @param id de Study
     */
    public void deleteStudy(long id) {
        studyRepository.deleteById(id);
    }
}
