package com.zahid.tour;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TourDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(TourDataLoader.class);

    @Autowired
    TourRepository tourRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

	private void loadSeedData() {
        if(tourRepository.count() == 0) {
            Tour t1 = new Tour("Cox's Bazar", "Cox's Bazar Tour", "2022-07-24", "2022-07-24", 12, 5500.0);
            Tour t2 = new Tour("Bandarban", "Bandarban Tour", "2022-07-25", "2022-07-25", 8, 4500.0);
            Tour t3 = new Tour("Rangamati", "Rangamati Tour", "2022-08-24", "2022-07-28", 10, 6500.0);
            Tour t4 = new Tour("Khagrachori", "Khagrachori Tour", "2022-07-24", "2022-07-26", 12, 5200.0);
            Tour t5 = new Tour("Sylhet", "Sylhet Tour", "2022-07-20", "2022-07-23", 8, 6200.0);
            Tour t6 = new Tour("Jessore", "Jessore Tour", "2022-09-24", "2022-09-28", 10, 5200.0);
            Tour t7 = new Tour("Comilla", "Comilla Day Tour", "2022-07-24", "2022-09-24", 12, 1200.0);
            Tour t8 = new Tour("Bandarban", "Bandarban Tour", "2022-10-22", "2022-10-27", 6, 7700.0);

            tourRepository.save(t1);
            tourRepository.save(t2);
            tourRepository.save(t3);
            tourRepository.save(t4);
            tourRepository.save(t5);
            tourRepository.save(t6);
            tourRepository.save(t7);
            tourRepository.save(t8);
      
        }
	}
    
}
