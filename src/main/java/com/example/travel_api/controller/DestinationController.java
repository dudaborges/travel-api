package com.example.travel_api.controller;

import com.example.travel_api.model.Destination;
import com.example.travel_api.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {
    @Autowired
    private DestinationService destinationService;

    @PostMapping
    public Destination addDestination(@RequestBody Destination destination) {
        return destinationService.addDestination(destination);
    }

    @GetMapping
    public List<Destination> getAllDestinations() {
        return destinationService.getAllDestinations();
    }

    @GetMapping("/search")
    public List<Destination> searchDestinations(@RequestParam String query) {
        return destinationService.searchDestinations(query);
    }

    @GetMapping("/{id}")
    public Destination getDestinationById(@PathVariable Long id) {
        return destinationService.getDestinationById(id);
    }

    @PutMapping("/{id}")
    public Destination updateDestination(@PathVariable Long id, @RequestBody Destination destination) {
        return destinationService.updateDestination(id, destination);
    }

    @PatchMapping("/{id}/rating")
    public double updateRating(@PathVariable Long id, @RequestParam double newRating) {
        return destinationService.updateRating(id, newRating);
    }

    @DeleteMapping("/{id}")
    public boolean deleteDestination(@PathVariable Long id) {
        return destinationService.deleteDestination(id);
    }
}
