package com.example.javafx.dal;

import java.util.List;

public interface GenericDao<T, ID> {

    T findById(ID id);
    List<T> findAll();
    void delete(T t);
    void update(T t);
    void save(T t);

}
