package com.zahid.tour.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zahid.tour.model.Tour;

public interface TourRepository extends CrudRepository<Tour, Long> {
    List<Tour> findByTitle(String title);
}
