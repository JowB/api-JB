package com.jb.apijb.menu;

import com.jb.apijb.generic.GenericMappingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService extends GenericMappingService<MenuDTO, Menu> {

    private final MenuRepository menuRepository;

    public MenuService(final MenuRepository menuRepository, final ModelMapper modelMapper) {
        super(modelMapper);
        this.menuRepository = menuRepository;
    }

    /**
     * Récupère la liste de tout les items
     *
     * @return list menuDTO
     */
    public List<MenuDTO> getAll() {
        return this.mapListToDto(menuRepository.findAll(), MenuDTO.class);
    }

    /**
     * Récupère un élément du menu en fonction de son id
     *
     * @param id menu id
     * @return optional menu
     */
    public Optional<Menu> getElementOfMenuById(long id) {
        return menuRepository.findById(id);
    }

    /**
     * Permet de faire aussi bien l'ajout que la modification en BDD
     *
     * @param menuDTO {@link MenuDTO}
     * @return menuDTO {@link MenuDTO}
     */
    public MenuDTO upsertMenu(MenuDTO menuDTO) {
        return this.mapToDto(menuRepository.save(this.mapToEntity(menuDTO, Menu.class)), MenuDTO.class);
    }

    /**
     * Supprime un élément du menu en fonction de son id
     *
     * @param id menu id
     */
    public void deleteMenu(long id) {
        menuRepository.deleteById(id);
    }
}
