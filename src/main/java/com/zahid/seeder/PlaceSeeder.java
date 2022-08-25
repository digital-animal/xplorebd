package com.zahid.seeder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.zahid.models.Place;
import com.zahid.repositories.PlaceRepository;

@Component
public class PlaceSeeder implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(PlaceSeeder.class);

    @Autowired
    PlaceRepository placeRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

	private void loadSeedData() {
        logger.info("Getting seeded data for Place model");

        if(placeRepository.count() == 0) {
            Place p1 = new Place("Inani Sea Beach", "Sea Beach", "Cox's Bazar");
            Place p2 = new Place("Nilgiri", "Hill Station", "Bandarban");
            Place p3 = new Place("Kaptai Lake", "Lake", "Rangamati");
            Place p4 = new Place("Sajek", "Hill Station", "Rangamati");
            Place p5 = new Place("Tea Garden", "Hill Station", "Sylhet");
            Place p6 = new Place("Sundarban", "Forest", "Bagerhat");
            Place p7 = new Place("Patenga", "Sea Beach", "Chittagong");
            Place p8 = new Place("Keokradong", "Mountain", "Bandarban");

            placeRepository.save(p1);
            placeRepository.save(p2);
            placeRepository.save(p3);
            placeRepository.save(p4);
            placeRepository.save(p5);
            placeRepository.save(p6);
            placeRepository.save(p7);
            placeRepository.save(p8);
      
        }
	}
    
}