package com.example.factories;

import com.example.Car;
import com.example.CarBuilder;
import com.example.CarRepository;
import com.example.RoofType;
import com.factories.EntityFactory;

public class CarFactory implements EntityFactory<Car, CarBuilder> {

    private CarRepository carRepository;

    public CarFactory(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Class<CarBuilder> builderClass() {
        return CarBuilder.class;
    }

    @Override
    public CarBuilder defaultBuilder() {
        return new CarBuilder().roofType(RoofType.HARDTOP);
    }
}
