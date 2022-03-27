package com.example.javafx.dal.memory;

import com.example.javafx.dal.Database;
import com.example.javafx.model.Tour;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase implements Database {
    private List<Tour> tours = new ArrayList<>();


}
