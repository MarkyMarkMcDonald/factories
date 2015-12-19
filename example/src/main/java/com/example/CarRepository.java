package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

public class CarRepository {

    private Map<String, Car> cars = new HashMap<>();

    public Car save(Car car) {
        checkPretendDatabaseConstraint(car);

        String uuid = UUID.randomUUID().toString();
        car.setId(uuid);
        cars.put(uuid, car);
        return car;
    }

    private void checkPretendDatabaseConstraint(Car car) {
        assert car.getRoofType() != null : "Cars must have a Roof Type";
    }

    public List<Car> findByColor(String color) {
        return cars.values().stream()
                .filter(car -> color.equals(car.getColor()))
                .collect(toList());
    }
}
