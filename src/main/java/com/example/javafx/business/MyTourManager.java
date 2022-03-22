package com.example.javafx.business;

import com.example.javafx.dal.DAOFactory;
import com.example.javafx.dal.TourDao;
import com.example.javafx.model.Tour;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyTourManager implements TourManager {

    private List<TourListener> listeners;
    private TourDao tourDao;

    public MyTourManager() {
        this.listeners = new ArrayList<>();
        this.tourDao = DAOFactory.Instance().getTourDao();
    }

    public void addTour(String name, String description) {
        tourDao.save(new Tour(name, description));
        fireToursChanged();
    }

    public List<String> getTours() {
        return tourDao.findAll().stream().map(t -> t.getName()).collect(Collectors.toList());
    }

    public void addTourListener(TourListener listener) {
        listeners.add(listener);
    }

    private void fireToursChanged() {
        listeners.forEach(l->l.listChanged());
    }
}
