package com.zahid.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zahid.models.Tour;
import com.zahid.services.TourService;

@RestController
public class TourController {
    /*
     * for this project root_url: localhost:8080 normally
     * 
     *  GET: root_url/tours -> getting all tours
     *  GET: root_url/tours/id -> getting a particular tour by id
     *  POST: root_url/tours -> creating a new tour
     *  PUT: root_url/tours/id -> updating a tour by id
     *  DELETE: root_url/tours/id -> deleteing a tour by id
     *  DELETE: root_url/tours -> deleting all tours
     */

    @Autowired
    TourService tourService;

    @GetMapping("/tours")
    public List<Tour> getAllTours() {
        return tourService.getAllTours();
    }

    @GetMapping("/tours/{id}")
    public Tour getTour(@PathVariable Long id) {
        return tourService.getTour(id);
    }

    @PostMapping("/tours")
    public void addTour(@RequestBody Tour tour) {
        tourService.addTour(tour);
    }

    @PutMapping("tours/{id}")
    public void updateTour(@RequestBody Tour tour, @PathVariable Long id) {
        tourService.updateTour(tour, id);
    }

    @DeleteMapping("/tours/{id}")
    public void deleteTour(@PathVariable Long id) {
        tourService.deleteTour(id);
    }

    @DeleteMapping("/tours")
    public void deleteAllTours(@PathVariable Long id) {
        tourService.deleteAllTours();
    }


}
