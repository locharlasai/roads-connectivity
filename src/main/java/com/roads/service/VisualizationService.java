package com.roads.service;

import com.roads.models.City;
import com.roads.models.Road;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.springframework.stereotype.Service;

import java.awt.GraphicsEnvironment;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class VisualizationService {

    public void visualizeMap(List<City> cities, List<Road> roads) {
        Graph graph = new SingleGraph("Map");

        for (City city : cities) {
            graph.addNode(city.getName()).setAttribute("xy", city.getLongitude(), city.getLatitude());
        }

        Set<String> addedEdges = new HashSet<>();

        for (Road road : roads) {
            String edgeId = road.getCity1() + "-" + road.getCity2();
            if (!addedEdges.contains(edgeId)) {
                graph.addEdge(edgeId, road.getCity1(), road.getCity2(), true)
                        .setAttribute("ui.class", "lanes-" + road.getLanes());
                addedEdges.add(edgeId);
            }
        }

        if (!GraphicsEnvironment.isHeadless()) {
            graph.setAttribute("ui.stylesheet", "url('stylesheet.css')");
            SwingViewer viewer = new SwingViewer(graph, SwingViewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
            viewer.addDefaultView(false);
            System.out.println("Visualization should be displayed now.");
        } else {
            System.out.println("Headless environment detected. Visualization is disabled.");
        }
    }
}
