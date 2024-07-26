package com.roads.service;

import com.roads.models.City;
import com.roads.models.Road;
import com.roads.repository.CityRepository;
import com.roads.repository.RoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class MapService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private RoadRepository roadRepository;

    private static final int CITY_COUNT = 100;

    @PostConstruct
    public void init() {
        generateCities();
        generateRoads();
    }

    public void generateCities() {
        Random random = new Random();
        List<City> cities = new ArrayList<>();
        IntStream.range(0, CITY_COUNT).forEach(i -> {
            String name = "City" + (i + 1);
            double latitude = -90 + (90 + 90) * random.nextDouble();
            double longitude = -180 + (180 + 180) * random.nextDouble();
            cities.add(new City(name, latitude, longitude));
        });
        cityRepository.saveAll(cities);
    }

    public void generateRoads() {
        Random random = new Random();
        List<City> cities = cityRepository.findAll();
        List<Road> roads = new ArrayList<>();

        for (City city1 : cities) {
            for (City city2 : cities) {
                if (!city1.equals(city2) && random.nextBoolean()) {
                    int lanes = random.nextInt(4) + 1;
                    roads.add(new Road(city1.getName(), city2.getName(), lanes));
                }
            }
        }
        roadRepository.saveAll(roads);
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public List<Road> getAllRoads() {
        return roadRepository.findAll();
    }
}
