package com.example.javafx.dal;

import com.example.javafx.config.Configuration;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DAOFactory {

    private static DAOFactory instance;
    private Database db;
    private TourDao tourDao;

    public DAOFactory() {

    }

    public static DAOFactory Instance() {
        if (instance == null) {
            instance = new DAOFactory();
            instance.init();
        }
        return instance;
    }

    private void init() {
        String dbClassName = Configuration.Instance().get("db");
        System.out.println("Using Database " + dbClassName);
        try {
            Class<Database> dbClass = (Class<Database>) Class.forName(dbClassName);
            Constructor<Database> constructor = dbClass.getConstructor();
            this.db = constructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("Database created!");
    }

    public TourDao getTourDao() {
        if (tourDao == null) {
            this.tourDao = new DBTourDao();
        }
        return tourDao;
    }
}
