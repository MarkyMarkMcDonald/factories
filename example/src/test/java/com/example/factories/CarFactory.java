package com.example.factories;

import com.example.Car;
import com.example.CarBuilder;
import com.example.CarRepository;
import com.example.RoofType;

import java.util.function.Function;

public class CarFactory {

    private CarRepository carRepository;

    public CarFactory(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car create(Function<? super CarBuilder, ? extends CarBuilder> overrides) {
        CarBuilder carBuilder = new CarBuilder().roofType(RoofType.HARDTOP);

        Car car = overrides.apply(carBuilder).build();

        return carRepository.save(car);
    }

    public Car create() {
        return create(overrides -> overrides);
    }
}
