package com.example.javafx.dal;

public class DAOFactory {

    private static DAOFactory instance;

    private TourDao tourDao;

    public DAOFactory() {
        this.tourDao = new DBTourDao();
    }

    public static DAOFactory Instance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public TourDao getTourDao() {
        return tourDao;
    }
}
