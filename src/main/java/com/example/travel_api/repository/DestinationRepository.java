package com.example.travel_api.repository;

import com.example.travel_api.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    List<Destination> findByNameContainingOrLocationContaining(String name, String location);
}
