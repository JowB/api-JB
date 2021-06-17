package com.jb.apijb.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/menu")
    public ResponseEntity<Menu> getInformationsMenu() {
        try {
            Menu menu = menuService.getInformationsMenuPage();

            if (menu == null) {
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
            menuService.createInformationsMenuPage(menu);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/menu/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable("id") long id, @RequestBody Menu menu) {
        try {
            Optional<Menu> menuOptional = menuService.findMenu(id);

            if (menuOptional.isPresent()) {
                Menu _menu = menuOptional.get();
                _menu.setLogo(menu.getLogo());
                _menu.setNavItem1(menu.getNavItem1());
                _menu.setNavItem2(menu.getNavItem2());
                _menu.setNavItem3(menu.getNavItem3());
                _menu.setNavItem4(menu.getNavItem4());
                _menu.setNavItem5(menu.getNavItem5());

                Menu updatedMenu = menuService.updateMenu(_menu);

                return new ResponseEntity<>(updatedMenu, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/menu/{id}")
    public ResponseEntity<HttpStatus> deleteMenu(@PathVariable("id") long id) {
        try {
            menuService.deleteMenu(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
