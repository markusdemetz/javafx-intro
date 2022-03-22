package com.example.javafx.dal;

import com.example.javafx.model.Tour;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase implements Database {
    private List<Tour> tours = new ArrayList<>();
}
