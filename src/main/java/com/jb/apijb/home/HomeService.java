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

    public Home updateHome(Home home) {
        return homeRepository.save(home);
    }

    public Optional<Home> findHome(long id) {
        return homeRepository.findById(id);
    }

    public void deleteHome(long id) {
        homeRepository.deleteById(id);
    }
}
