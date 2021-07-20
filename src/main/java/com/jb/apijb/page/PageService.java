package com.jb.apijb.page;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PageService {

    private final PageRepository pageRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PageService(final PageRepository pageRepository, final ModelMapper modelMapper) {
        this.pageRepository = pageRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Retourne la liste de toutes les pages.
     *
     * @return list pageDto
     */
    public List<PageDTO> getAllPages() {
        return this.mapListToDto(pageRepository.findAll());
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
                PageDTO pageDTO = this.mapToDto(optionalPage.get());

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
        return this.mapToDto(pageRepository.save(this.mapToEntity(pageDTO)));
    }

    /**
     * Cette fonction permet de supprimer une page en base de donnée.
     *
     * @param id page id
     */
    public void deletePage(long id) {
        pageRepository.deleteById(id);
    }

    private Page mapToEntity(PageDTO pageDTO) {
        return modelMapper.map(pageDTO, Page.class);
    }

    private PageDTO mapToDto(Page page) {
        return modelMapper.map(page, PageDTO.class);
    }

    private List<PageDTO> mapListToDto(List<Page> pageList) {
        return pageList
                .stream()
                .map(element -> modelMapper.map(element, PageDTO.class))
                .collect(Collectors.toList());
    }
}
