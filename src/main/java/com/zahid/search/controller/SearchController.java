package com.zahid.search.controller;
// package com.zahid.controllers;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;

// import com.zahid.models.Place;
// import com.zahid.models.Tour;
// import com.zahid.services.PlaceService;
// import com.zahid.services.SearchService;
// import com.zahid.services.TourService;

// @Controller
// public class SearchController {
	
//     @Autowired
//     private PlaceService placeService;

//     @Autowired 
//     private TourService tourService;

// 	@Autowired
// 	private SearchService searchService;

//     @GetMapping("/search")
//     public String search(Model model, @PathVariable String keyword) {

//         if(keyword!=null) {

//             List<Place> placeList = placeService.getByKeyword(keyword);
//             List<Place> tourList = placeService.getByKeyword(keyword);
//             model.addAttribute("places", placeList);
//             model.addAttribute("tours", tourList);

//         } else {
//             List<Place> placeList = placeService.getAllPlaces();
//             List<Tour> tourList = tourService.getAllTours();
//             model.addAttribute("places", placeList);
//             model.addAttribute("tours", tourList);
//         }
        
//         return "search-result";
//     }
// }   