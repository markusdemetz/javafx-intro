package com.example.javafx;

import com.example.javafx.model.Tour;

public class TourTableRow {
    Tour tour;

    public TourTableRow(Tour tour) {
        this.tour = tour;
    }

    public Long getId() {
        return tour.getId();
    }

    public String getName() {
        return tour.getName();
    }

    public String getDescription() {
        return tour.getDescription();
    }
}
