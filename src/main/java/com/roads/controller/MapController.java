package com.roads.controller;

import com.roads.models.City;
import com.roads.models.Road;
import com.roads.service.MapService;
import com.roads.service.VisualizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MapController {
    @Autowired
    private MapService mapService;

    @Autowired
    private VisualizationService visualizationService;

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return mapService.getAllCities();
    }

    @GetMapping("/roads")
    public List<Road> getAllRoads() {
        return mapService.getAllRoads();
    }

    @GetMapping("/visualize")
    public String visualizeMap() {
        List<City> cities = mapService.getAllCities();
        List<Road> roads = mapService.getAllRoads();
        visualizationService.visualizeMap(cities, roads);
        return "Visualization started";
    }
}
