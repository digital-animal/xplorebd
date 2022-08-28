package com.zahid.seeder;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.zahid.models.Place;
import com.zahid.models.Tour;
import com.zahid.services.PlaceService;
import com.zahid.services.RoleService;

@Component
public class PlaceSeeder implements CommandLineRunner{
    private static String DATA_URL = "https://raw.githubusercontent.com/digital-animal/xplorebd-files/main/places.csv";
    private List<Tour> allData = new ArrayList<>();

    private final Logger logger = LoggerFactory.getLogger(PlaceSeeder.class);
    
    @Autowired
    private PlaceService placeService;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }
    // loading seeded data from csv file hosted in github
    public void loadSeedData() throws IOException, InterruptedException {
        List<Place> newData = new ArrayList<>(); // concurrency issue resolving
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
