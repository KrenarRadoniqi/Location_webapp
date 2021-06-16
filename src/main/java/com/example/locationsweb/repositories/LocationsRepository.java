package com.example.locationsweb.repositories;

import com.example.locationsweb.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationsRepository extends JpaRepository<Location, Integer> {
    @Query(value = "select type, count(type) from location group by type",
    nativeQuery = true)
    public List<Object[]> typeCount();
}
