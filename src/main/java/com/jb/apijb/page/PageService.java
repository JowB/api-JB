package com.jb.apijb.page;

import com.jb.apijb.project.Project;
import com.jb.apijb.project.ProjectDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
     * @return list page
     */
    public List<Page> getAllPages() {
        return pageRepository.findAll();
    }

    /**
     * Retourne une page en fonction de son id.
     *
     * @param id page id
     * @return optional Page
     */
    public Optional<Page> getPageById(Long id) {
        return pageRepository.findById(id);
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
}
