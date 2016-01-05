package com.example;

import com.factories.Builder;

public class CarBuilder implements Builder<Car> {

    private final Car car;

    public CarBuilder() {
        this.car = new Car();
    }

    public CarBuilder id(String id) {
        car.setId(id);
        return this;
    }

    public CarBuilder modelYear(Integer modelYear) {
        car.setModelYear(modelYear);
        return this;
    }

    public CarBuilder color(String color) {
        car.setColor(color);
        return this;
    }

    public CarBuilder brand(String brand) {
        car.setBrand(brand);
        return this;
    }

    public CarBuilder roofType(RoofType roofType) {
        car.setRoofType(roofType);
        return this;
    }

    public Car build() {
        return car;
    }

}
