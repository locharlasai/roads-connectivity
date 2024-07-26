package com.roads;

import com.roads.models.City;
import com.roads.models.Road;
import com.roads.service.MapService;
import com.roads.service.VisualizationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RoadsConnectivityApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoadsConnectivityApplication.class, args);
    }

    @Autowired
    private MapService mapService;
    @Autowired
    private VisualizationService visualizationService;

    @Bean
    CommandLineRunner runner() {
        return args -> {
            List<City> cities = mapService.getAllCities();
            List<Road> roads = mapService.getAllRoads();
            visualizationService.visualizeMap(cities, roads);
        };
    }
}
