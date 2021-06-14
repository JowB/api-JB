package com.jb.apijb.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public Menu getInformationsMenuPage() {
        long id = 4;
        Optional<Menu> menuResponse = menuRepository.findById(id);

        return menuResponse.get();
    }

    public void createInformationsMenuPage(Menu menu) {
        menuRepository.save(new Menu(menu.getTitle(), menu.getNavItem1(), menu.getNavItem2(), menu.getNavItem3(), menu.getNavItem4(), menu.getNavItem5(), menu.getLinkedinUrl(), menu.getGithubUrl()));
    }
}
