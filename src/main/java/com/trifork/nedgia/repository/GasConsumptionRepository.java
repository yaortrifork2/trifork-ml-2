package com.trifork.nedgia.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

@Repository
public class GasConsumptionRepository {

    private final HashMap<Long, Optional<Double>> database;

    public GasConsumptionRepository() {
        this.database = new HashMap<>();
    }

    public void save(Long time, Double predicted){
        this.database.put(time, of(predicted));
    }

    public Optional<Double> get(Long time){
        return this.database.getOrDefault(time, empty());
    }
}
