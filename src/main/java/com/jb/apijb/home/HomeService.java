package com.jb.apijb.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HomeService {

    @Autowired
    private HomeRepository homeRepository;

    public Home getInformationsHomePage() {
        long id = 6;
        Optional<Home> homeResponse = homeRepository.findById(id);

        return homeResponse.get();
    }

    public void createInformationsHomePage(Home home) {
        homeRepository.save(new Home(home.getName(), home.getJob(), home.getActualJob()));
    }
}
