package com.example.locationsweb.services;

import com.example.locationsweb.model.Location;
import com.example.locationsweb.repositories.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationsRepository locationsRepository;

    @Override
    public Location saveLocation(Location location) {
        return locationsRepository.save(location);
    }

    @Override
    public Location updateLocation(Location location) {
        return locationsRepository.save(location);
    }

    @Override
    public void deleteLocation(Location location) {
        locationsRepository.delete(location);
    }

    @Override
    public Location getLocationById(int id) {
        return locationsRepository.findById(id).get();
    }

    @Override
    public List<Location> getLocations() {
        return locationsRepository.findAll();
    }
}
