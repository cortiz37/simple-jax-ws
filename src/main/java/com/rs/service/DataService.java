package com.rs.service;

import com.rs.model.Data;
import com.rs.repository.DataRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import java.util.List;

@Dependent
public class DataService {

    @Inject
    private DataRepository dataRepository;

    public List<Data> getAll() {
        return dataRepository.getDatabase();
    }
}
