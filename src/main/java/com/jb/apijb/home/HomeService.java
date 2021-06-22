package com.jb.apijb.home;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HomeService {

    private final HomeRepository homeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeService(final HomeRepository homeRepository, final ModelMapper modelMapper) {
        this.homeRepository = homeRepository;
        this.modelMapper = modelMapper;
    }

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

    private Home mapToEntity(HomeDTO homeDTO) {
        return modelMapper.map(homeDTO, Home.class);
    }

    private HomeDTO mapToDto(Home home) {
        return modelMapper.map(home, HomeDTO.class);
    }
}
