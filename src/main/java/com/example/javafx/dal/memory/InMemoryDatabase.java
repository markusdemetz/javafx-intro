package com.example.javafx.dal.memory;

import com.example.javafx.dal.Database;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryDatabase implements Database {

    private Map<Class<?>, Map<Long, Map<String, Object>>> database = new HashMap<>();
    private Map<Class<?>, Long> nextId = new HashMap<>();

    public void insert(Class<?> table, List<String> columnNames, List<Object> values) {
        if (!database.containsKey(table)) {
            database.put(table, new HashMap<>());
        }
        Long id = nextId(table);
        Map<String, Object> row = createRow(columnNames, values);
        row.put("id", id);
        database.get(table).put(id, row);
    }

    public Collection<Map<String, Object>> readAll(Class<?> table) {
        return database.get(table).values();
    }

    private Map<String, Object> createRow(List<String> columnNames, List<Object> values) {
        Map<String, Object> row = new HashMap<>();
        for (int i = 0; i < columnNames.size(); i++) {
            String key = columnNames.get(i);
            Object value = values.get(i);
            row.put(key, value);
        }
        return row;
    }


    private Long nextId(Class<?> table) {
        if (!nextId.containsKey(table)) {
            nextId.put(table, 1L);
        }
        Long id = nextId.get(table);
        nextId.put(table, id + 1);
        return id;
    }

}
