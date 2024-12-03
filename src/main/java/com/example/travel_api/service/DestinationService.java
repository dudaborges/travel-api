package com.example.travel_api.service;

import com.example.travel_api.model.Destination;
import com.example.travel_api.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {
    @Autowired
    private DestinationRepository destinationRepository;

    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    public Destination getDestinationById(Long id) {
        return destinationRepository.findById(id).orElse(null);
    }

    public List<Destination> searchDestinations(String query) {
        return destinationRepository.findByNameContainingOrLocationContaining(query, query);
    }

    public Destination addDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    public boolean deleteDestination(Long id) {
        if (destinationRepository.existsById(id)) {
            destinationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Destination updateDestination(Long id, Destination destination) {
        if (destinationRepository.existsById(id)) {
            destination.setId(id);
            return destinationRepository.save(destination);
        }
        return null;
    }

    public double updateRating(Long id, double newRating) {
        Destination destination = getDestinationById(id);
        if (destination != null) {
            double updatedRating = (destination.getRating() + newRating) / 2;
            destination.setRating(updatedRating);
            destinationRepository.save(destination);
            return updatedRating;
        }
        return 0;
    }
}
