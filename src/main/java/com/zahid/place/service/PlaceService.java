package com.zahid.place.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zahid.place.model.Place;
import com.zahid.place.repository.PlaceRepository;

@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository; // handle for performing crud   

    public List<Place> getAllPlaces() {
        List<Place> placeList = new ArrayList<>();
        placeRepository.findAll().forEach(placeList::add);
        return placeList;
    }

    public List<Place> getByKeyword(String keyword) {
        List<Place> placeList = new ArrayList<>();
        placeRepository.findByName(keyword).forEach(placeList::add);
        return placeList;
    }

	public Place getPlace(Long id) {
		return placeRepository.findById(id).get();
	}

    public void addPlace(Place place) {
        placeRepository.save(place);
    }

	public void deletePlace(Long id) {
        placeRepository.deleteById(id);
	}

    public void updatePlace(Place updatedPlace, Long id) {
        Place place = placeRepository.findById(id).get();
        place = updatedPlace; // changing reference to new place
        placeRepository.save(place);
    }

	public void deleteAllPlaces() {
        placeRepository.deleteAll();
	}

}
