package com.example.javafx.business;

import com.example.javafx.model.Tour;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyTourManager implements TourManager {

    private List<Tour> tours;
    private List<TourListener> listeners;

    public MyTourManager() {
        this.listeners = new ArrayList<>();
        this.tours = new ArrayList<>();
    }

    public void addTour(String name, String description) {
        tours.add(new Tour(name, description));
        fireToursChanged();
    }

    public List<String> getTours() {
        return tours.stream().map(t -> t.getName()).collect(Collectors.toList());
    }

    public void addTourListener(TourListener listener) {
        listeners.add(listener);
    }

    private void fireToursChanged() {
        listeners.forEach(l->l.listChanged());
    }
}
