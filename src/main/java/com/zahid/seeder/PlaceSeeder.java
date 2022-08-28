package com.zahid.seeder;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.zahid.models.Place;
import com.zahid.services.PlaceService;

@Component
public class PlaceSeeder implements CommandLineRunner {

    private static String DATA_URL = "https://raw.githubusercontent.com/digital-animal/xplorebd-files/main/places.csv";

    private final Logger logger = LoggerFactory.getLogger(PlaceSeeder.class);

    @Autowired
    PlaceService placeService;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

	private void loadSeedData() throws IOException, InterruptedException {
        logger.info("Getting seeded data for Place model");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(DATA_URL)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        StringReader csvBodyReader = new StringReader(response.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);

        List<Place> places = placeService.getAllPlaces();
        
        if(places.size() == 0) {
            
            for (CSVRecord record : records) {
                // Province/State,Country/Region,Lat,Long
                String name = record.get("Name");
                String type = record.get("Type");
                String location = record.get("Location");
                String image = record.get("Image");

                Place place = new Place(name, type, location);
                place.setImage(image);
                
                placeService.addPlace(place);
            }
            
      
        }
	}

}