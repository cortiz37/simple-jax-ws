package com.rs.repository;

import com.rs.model.Data;


import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class DataRepository {

    private final static List<Data> database = new ArrayList<>();

    static {
        database.add(new Data(1, Collections.singletonMap("type", "LARGE")));
        database.add(new Data(2, Collections.singletonMap("type", "SHORT")));
        database.add(new Data(3, Collections.singletonMap("public", false)));
    }

    public List<Data> getDatabase() {
        return database;
    }
}
