package com.zahid.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zahid.models.Place;

public interface PlaceRepository extends CrudRepository<Place, Long> {
    List<Place> findByName(String name);
}
