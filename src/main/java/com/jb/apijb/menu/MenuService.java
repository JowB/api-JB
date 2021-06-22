package com.jb.apijb.menu;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    public MenuService(final MenuRepository menuRepository, final ModelMapper modelMapper) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }

    public Menu getInformationsMenuPage() {
        long id = 4;
        Optional<Menu> menuResponse = menuRepository.findById(id);

        return menuResponse.get();
    }

    public void createInformationsMenuPage(Menu menu) {
        menuRepository.save(new Menu(menu.getLogo(), menu.getNavItem1(), menu.getNavItem2(), menu.getNavItem3(), menu.getNavItem4(), menu.getNavItem5()));
    }

    public Menu updateMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Optional<Menu> findMenu(long id) {
        return menuRepository.findById(id);
    }

    public void deleteMenu(long id) {
        menuRepository.deleteById(id);
    }

    private Menu mapToEntity(MenuDTO menuDTO) {
        return modelMapper.map(menuDTO, Menu.class);
    }

    private MenuDTO mapToDto(Menu menu) {
        return modelMapper.map(menu, MenuDTO.class);
    }
}
