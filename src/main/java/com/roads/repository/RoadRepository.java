package com.roads.repository;

import com.roads.models.Road;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoadRepository extends MongoRepository<Road, String> {
}