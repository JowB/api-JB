package com.jb.apijb.controller;

import com.jb.apijb.model.Menu;
import com.jb.apijb.repository.MenuRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    final MenuRepository menuRepository;

    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping("/menu")
    public ResponseEntity<List<Menu>> getInformationsMenu() {
        try {
            List<Menu> menu = menuRepository.findAll();

            if (menu.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(menu, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/menu")
    public ResponseEntity<Menu> createInformationsMenu(@RequestBody Menu menu) {
        try {
            Menu newMenu = menuRepository.save(new Menu(menu.getTitle(), menu.getNavItem1(), menu.getNavItem2(), menu.getNavItem3(), menu.getNavItem4(), menu.getNavItem5(), menu.getLinkedinUrl(), menu.getGithubUrl()));
            return new ResponseEntity<>(newMenu, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
