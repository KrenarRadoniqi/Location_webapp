package com.example.locationsweb.controller;

import com.example.locationsweb.model.Location;
import com.example.locationsweb.repositories.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {
    @Autowired
    LocationsRepository locationsRepository;
    @GetMapping
    public List<Location> getLocations(){
        return locationsRepository.findAll();
    }
    @PostMapping
    public Location createLocation(@RequestBody Location location){
        return locationsRepository.save(location);
    }
    @PutMapping
    public Location updateLocation(@RequestBody Location location){
        return locationsRepository.save(location);
    }
    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable("id") int id){
        Location location=locationsRepository.findById(id).get();
        locationsRepository.delete(location);
    }
}
