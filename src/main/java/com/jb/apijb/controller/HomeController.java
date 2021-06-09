package com.jb.apijb.controller;

import com.jb.apijb.model.Home;
import com.jb.apijb.repository.HomeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    final HomeRepository homeRepository;

    public HomeController(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    @GetMapping("/home")
    public ResponseEntity<List<Home>> getInformationsHomePage() {
        try {
            List<Home> home = homeRepository.findAll();

            if (home.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(home, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/home")
    public ResponseEntity<Home> createInformationsHomePage(@RequestBody Home home) {
        try {
            Home newHome = homeRepository.save(new Home(home.getName(), home.getJob(), home.getActualJob()));
            return new ResponseEntity<>(newHome, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
