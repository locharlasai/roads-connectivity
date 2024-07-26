# roads-connectivity

This application is for managing the library

- City:

Attributes: name (String), latitude (double), longitude (double).
Road:

- Attributes: city1 (City), city2 (City), lanes.
Lane types:
4 lanes: National Highways
3 lanes: Inter-State Highways
2 lanes: Highways
1 lane: Main Roads
Map:

- SubTasks:
Generate 100 random city names with random latitude and longitude values.
Print the list of cities with their names and coordinates.
Ensure the output varies with each run using randomization.
Road Connections:

- Establish connections between cities:
Max of 4 National Highways (4 lanes).
Inter-State Highways (3 lanes) can connect to National Highways.
Highways (2 lanes) can connect to Inter-State Highways.
Main Roads (1 lane) can connect to Highways.
Ensure each city is connected to at least one other city.
Graph Visualization:

 -Use GraphStream (https://graphstream-project.org/) to display the map:
Cities as nodes.
Roads as edges, with visual differentiation based on the number of lanes.



