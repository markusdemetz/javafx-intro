package com.example.javafx.dal;

import com.example.javafx.dal.memory.InMemoryDatabase;
import com.example.javafx.model.Tour;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DBTourDao implements TourDao {

    private final InMemoryDatabase database;

    public DBTourDao() {
        this.database = new InMemoryDatabase();
    }

    @Override
    public List<Tour> findAll() {
        Collection<Map<String, Object>> rows = database.readAll(Tour.class);
        List<Tour> tours = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            tours.add(populate(row));
        }
        return tours;
    }

    private Tour populate(Map<String, Object> row) {
        Tour tour = new Tour();
        tour.setId((Long)row.get("id"));
        tour.setName((String)row.get("name"));
        tour.setDescription((String)row.get("description"));
        return tour;
    }

    @Override
    public Tour findById(Long id) {
        throw new UnsupportedOperationException("To implement!");
    }

    @Override
    public void update(Tour tour) {
        throw new UnsupportedOperationException("To implement!");
    }

    @Override
    public void save(Tour tour) {
        List<String> columnNames = List.of("name", "description");
        List<Object> values = List.of(tour.getName(), tour.getDescription());
        database.insert(Tour.class, columnNames, values);
    }

    @Override
    public void delete(Tour tour) {
        throw new UnsupportedOperationException("To implement!");
    }
}
