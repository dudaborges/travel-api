package com.example.travel_api.service;

import com.example.travel_api.model.Destination;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DestinationService {
    private List<Destination> destinations = new ArrayList<>();

    public List<Destination> getAllDestinations() {
        return destinations;
    }

    public Destination getDestinationById(Long id) {
        return destinations.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Destination> searchDestinations(String query) {
        List<Destination> result = new ArrayList<>();
        for (Destination d : destinations) {
            if (d.getName().contains(query) || d.getLocation().contains(query)) {
                result.add(d);
            }
        }
        return result;
    }

    public Destination addDestination(Destination destination) {
        destination.setId((long) (destinations.size() + 1));
        destinations.add(destination);
        return destination;
    }

    public boolean deleteDestination(Long id) {
        return destinations.removeIf(d -> d.getId().equals(id));
    }

    public Destination updateDestination(Long id, Destination destination) {
        Destination existingDestination = getDestinationById(id);
        if (existingDestination != null) {
            existingDestination.setName(destination.getName());
            existingDestination.setLocation(destination.getLocation());
            existingDestination.setDescription(destination.getDescription());
            existingDestination.setRating(destination.getRating());
        }
        return existingDestination;
    }

    public double updateRating(Long id, double newRating) {
        Destination destination = getDestinationById(id);
        if (destination != null) {
            double updatedRating = (destination.getRating() + newRating) / 2;
            destination.setRating(updatedRating);
            return updatedRating;
        }
        return 0;
    }
}
