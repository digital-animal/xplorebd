package com.zahid.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zahid.models.Tour;

public interface TourRepository extends CrudRepository<Tour, Long> {
    List<Tour> findByTitle(String title);
}
