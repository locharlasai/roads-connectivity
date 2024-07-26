package com.roads.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roads")
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor

public class Road {

    private String id;
    private String city1;
    private String city2;
    private int lanes;

    public Road(String city1, String city2, int lanes) {
        this.city1 = city1;
        this.city2 = city2;
        this.lanes = lanes;
    }
}