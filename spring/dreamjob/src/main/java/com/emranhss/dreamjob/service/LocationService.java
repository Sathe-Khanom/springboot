package com.emranhss.dreamjob.service;

import com.emranhss.dreamjob.dto.LocationDTO;
import com.emranhss.dreamjob.entity.Location;
import com.emranhss.dreamjob.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<LocationDTO> getAllLocations() {
        return locationRepository.findAll()
                .stream()
                .map(loc -> new LocationDTO(loc.getId(), loc.getName()))
                .collect(Collectors.toList());
    }

    public Optional<LocationDTO> getLocationById(Long id) {
        return locationRepository.findById(id)
                .map(loc -> new LocationDTO(loc.getId(), loc.getName()));
    }

    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    public Optional<Location> updateLocation(Long id, Location updatedLocation) {
        return locationRepository.findById(id).map(location -> {
            location.setName(updatedLocation.getName());
            return locationRepository.save(location);
        });
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }

}
