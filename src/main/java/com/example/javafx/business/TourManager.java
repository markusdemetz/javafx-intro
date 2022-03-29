package com.example.javafx.business;

import com.example.javafx.model.Tour;

import java.util.List;

public interface TourManager {

    void addTourListener(TourListener listener);
    void addTour(String name, String description);
    List<Tour> getTours();


}
