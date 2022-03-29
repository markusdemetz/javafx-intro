package com.example.javafx;

import com.example.javafx.business.TourListener;
import com.example.javafx.business.TourManager;
import com.example.javafx.model.Tour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class TourVM implements TourListener {

    private final TourManager manager;
    private ObservableList<String> listItems;
    private ObservableList<TourTableRow> tableRows;

    public TourVM(TourManager manager) {
        this.manager = manager;
        this.listItems = FXCollections.observableArrayList();
        this.tableRows = FXCollections.observableArrayList();
        this.manager.addTourListener(this);
    }

    public ObservableList<String> getListItems() {
        return listItems;
    }

    public ObservableList<TourTableRow> getTableRows() {
        return tableRows;
    }

    public void add(String name) {
        manager.addTour(name, "No Description.");
    }

    @Override
    public void listChanged() {
        // listItems.setAll(manager.getTours());
        List<Tour> tours = manager.getTours();
        List<TourTableRow> rows = tours.stream().map(t -> new TourTableRow(t)).toList();
        tableRows.setAll(rows);
    }
}
