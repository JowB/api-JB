package com.jb.apijb.menu;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MenuService(final MenuRepository menuRepository, final ModelMapper modelMapper) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Récupère la liste de tout les items
     *
     * @return list menuDTO
     */
    public List<MenuDTO> getAll() {
        return this.mapListToDto(menuRepository.findAll());
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
        return this.mapToDto(menuRepository.save(this.mapToEntity(menuDTO)));
    }

    /**
     * Supprime un élément du menu en fonction de son id
     *
     * @param id menu id
     */
    public void deleteMenu(long id) {
        menuRepository.deleteById(id);
    }

    private Menu mapToEntity(MenuDTO menuDTO) {
        return modelMapper.map(menuDTO, Menu.class);
    }

    private MenuDTO mapToDto(Menu menu) {
        return modelMapper.map(menu, MenuDTO.class);
    }

    private List<MenuDTO> mapListToDto(List<Menu> menuList) {
        return menuList
                .stream()
                .map(element -> modelMapper.map(element, MenuDTO.class))
                .collect(Collectors.toList());
    }
}
