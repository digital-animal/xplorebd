package com.zahid.tour.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zahid.auth.model.Account;
import com.zahid.auth.service.AccountService;
import com.zahid.home.controller.HomeController;
import com.zahid.tour.model.Tour;
import com.zahid.tour.service.TourService;

@RestController
@Controller
public class TourController {
    
    private final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    @Autowired
    private TourService tourService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/tours")
    public ModelAndView getAllTours() {
        logger.debug("request to GET tour list");
        ModelAndView modelAndView = new ModelAndView("tours");
        
        modelAndView.addObject("tours", tourService.getAllTours());
        
        return modelAndView;
    }

    @GetMapping("/tours/{id}")
    public ModelAndView getTour(@PathVariable Long id) {
        logger.debug("request to GET a tour");
        ModelAndView modelAndView = new ModelAndView("tour");
        modelAndView.addObject("tour", tourService.getTour(id));
        return modelAndView;
    }
    
    @GetMapping("/tours/new")
    public ModelAndView tourCreationForm() {
        logger.debug("request to GET a new tour creation form");
        Tour tour = new Tour();
        ModelAndView modelAndView = new ModelAndView("tour-add");
        modelAndView.addObject("tour", tour);
        return modelAndView;
    }

    @PostMapping("/tours/new")
    public ModelAndView addTour(@ModelAttribute Tour tour) {
        tourService.addTour(tour);
        logger.info("Tour Created");
        ModelAndView modelAndView = new ModelAndView("tour-add-success");

        return modelAndView;
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
    
    @GetMapping("tours/{id}/enroll")
    public ModelAndView enroll(@PathVariable String id) {
        logger.debug("request to GET a new tour enroll");

        Tour tour = tourService.getTour(Long.parseLong(id));

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        // username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        Account account = accountService.getAccountByEmail(username);

        logger.info("Username : ", username);

        tour.getAccounts().add(account);
        tourService.updateTour(tour, tour.getId());

        ModelAndView modelAndView = new ModelAndView("tour");
        modelAndView.addObject("tour", tour);
        return modelAndView;
    }

}
