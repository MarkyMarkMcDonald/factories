package com.example;

import org.junit.Before;
import org.junit.Test;

public class CarRepositoryTest {

    private CarRepository carRepository;

    @Before
    public void setUp() throws Exception {
        carRepository = new CarRepository();
    }

    @Test
    public void testFindByColor() throws Exception {
        Car redCar = new Car();
        redCar.setColor("red");
        Car savedRedCar = carRepository.save(redCar);
    }

}