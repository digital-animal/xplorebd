package com.zahid.place.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zahid.place.model.Place;

public interface PlaceRepository extends CrudRepository<Place, Long> {
    List<Place> findByName(String name);
}
