package com.zahid.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zahid.models.Place;
import com.zahid.services.PlaceService;

@Controller
public class PlaceController {


    @Autowired
    PlaceService placeService;

    @GetMapping("/places/list") 
    public ModelAndView getPlaceList() {
        ModelAndView modelAndView = new ModelAndView("places");
        modelAndView.addObject("places", placeService.getAllPlaces());
        
        return modelAndView;
    }

    @GetMapping("/places/add") 
    public ModelAndView placeAdditionForm() {
        ModelAndView modelAndView = new ModelAndView("place-add");

        Place place = new Place();
        modelAndView.addObject("place", place);
        return modelAndView;
    }

    @PostMapping("/places/add") 
    public String addPlace(@ModelAttribute Place place) {
        placeService.addPlace(place);
        
        return "place-add-success";
    }

}
