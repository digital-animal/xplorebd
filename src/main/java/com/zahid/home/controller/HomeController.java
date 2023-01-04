package com.zahid.home.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.zahid.place.model.Place;
import com.zahid.place.service.PlaceService;
import com.zahid.tour.model.Tour;
import com.zahid.tour.service.TourService;

@Controller
public class HomeController {
    
    private final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    @Autowired
    TourService tourService;

    @Autowired
    PlaceService placeService;
    
    @GetMapping("/") 
    public ModelAndView home() {
        logger.debug("request to GET index");
        ModelAndView modelAndView = new ModelAndView("index");
        
        modelAndView.addObject("tours", tourService.getAllTours());
        modelAndView.addObject("places", placeService.getAllPlaces());
        
        return modelAndView;
    }
    
    @GetMapping("/tours/list") 
    public ModelAndView index() {
        logger.debug("request to GET list");
        ModelAndView modelAndView = new ModelAndView("tours");
        
        modelAndView.addObject("tours", tourService.getAllTours());
        
        return modelAndView;
    }

    @GetMapping("/search")
    public String search(Model model, @PathVariable String keyword) {

        if(keyword != null) {

            List<Place> placeList = placeService.getByKeyword(keyword);
            List<Tour> tourList = tourService.getByKeyword(keyword);
            model.addAttribute("places", placeList);
            model.addAttribute("tours", tourList);

        } else {
            List<Place> placeList = placeService.getAllPlaces();
            List<Tour> tourList = tourService.getAllTours();
            model.addAttribute("places", placeList);
            model.addAttribute("tours", tourList);
        }
        
        return "serch-result";
    }
        
    @GetMapping("/user")
    public String user(Model model) {
        return "user";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }
}
