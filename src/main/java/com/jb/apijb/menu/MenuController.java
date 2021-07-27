package com.jb.apijb.menu;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200", "https://backoffice-jb.netlify.app/"})
@RestController
public class MenuController {

    private final MenuService menuService;

    public MenuController(final MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menu")
    public ResponseEntity<List<MenuDTO>> getAllItemsFromMenu() {
        try {
            List<MenuDTO> menuDTOList = menuService.getAll();

            if (menuDTOList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(menuDTOList, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/menu/{id}")
    public ResponseEntity<Menu> getItemFromMenuById(@PathVariable("id") long id) {
        try {
            Optional<Menu> menuOptional = menuService.getElementOfMenuById(id);

            return menuOptional.map(item -> new ResponseEntity<>(item, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/menu")
    public ResponseEntity<MenuDTO> upsertItemForMenu(@RequestBody MenuDTO menuDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(menuService.upsertMenu(menuDTO));
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
