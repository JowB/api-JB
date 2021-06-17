package com.jb.apijb.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/home")
    public ResponseEntity<Home> getInformationsHomePage() {
        try {
            Home home = homeService.getInformationsHomePage();

            if (home == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(home, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/home")
    public ResponseEntity<Home> createInformationsHomePage(@RequestBody Home home) {
        try {
            homeService.createInformationsHomePage(home);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/home/{id}")
    public ResponseEntity<Home> updateHome(@PathVariable("id") long id, @RequestBody Home home) {
        try {
            Optional<Home> homeOptional = homeService.findHome(id);

            if (homeOptional.isPresent()) {
                Home _home = homeOptional.get();
                _home.setActualJob(home.getActualJob());
                _home.setJob(home.getJob());
                _home.setName(home.getName());

                Home updatedHome = homeService.updateHome(_home);

                return new ResponseEntity<>(updatedHome, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/home/{id}")
    public ResponseEntity<HttpStatus> deleteHome(@PathVariable("id") long id) {
        try {
            homeService.deleteHome(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
