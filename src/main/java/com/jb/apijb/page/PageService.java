package com.jb.apijb.page;

import com.jb.apijb.generic.GenericMappingService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PageService extends GenericMappingService<PageDTO, Page> {

    private final PageRepository pageRepository;

    public PageService(final PageRepository pageRepository, final ModelMapper modelMapper) {
        super(modelMapper);
        this.pageRepository = pageRepository;
    }

    /**
     * Retourne la liste de toutes les pages.
     *
     * @return list pageDto
     */
    public List<PageDTO> getAllPages() {
        return this.mapListToDto(pageRepository.findAll(), PageDTO.class);
    }

    /**
     * Retourne une page en fonction de son id.
     *
     * @param id page id
     * @return ResponseEntity
     */
    public ResponseEntity<PageDTO> getPageById(Long id) {
        try {
            Optional<Page> optionalPage = pageRepository.findById(id);

            if (optionalPage.isPresent()) {
                PageDTO pageDTO = this.mapToDto(optionalPage.get(), PageDTO.class);

                return new ResponseEntity<>(pageDTO, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Cette fonction permet de faire aussi bien l'insert que l'update en base de données.
     *
     * @param pageDTO {@link PageDTO}
     * @return pageDTO
     */
    public PageDTO upsertPage(PageDTO pageDTO) {
        return this.mapToDto(pageRepository.save(this.mapToEntity(pageDTO, Page.class)), PageDTO.class);
    }

    /**
     * Cette fonction permet de supprimer une page en base de donnée.
     *
     * @param id page id
     */
    public void deletePage(long id) {
        pageRepository.deleteById(id);
    }

}
