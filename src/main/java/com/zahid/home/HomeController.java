package com.zahid.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zahid.tour.TourService;

@Controller
public class HomeController {
    
    private final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    @Autowired
    TourService tourService;
    
    @GetMapping("/") 
    public ModelAndView home() {
        logger.debug("request to GET index");
        ModelAndView modelAndView = new ModelAndView("index");
        
        modelAndView.addObject("tours", tourService.getAllTours());
        
        return modelAndView;
    }
    
    // @GetMapping("/")
    // public String home(Model model) {
    //     return "index";
    // }
}
