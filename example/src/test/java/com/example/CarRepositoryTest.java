package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.example.RoofType.HARDTOP;
import static org.junit.Assert.assertEquals;

public class CarRepositoryTest {

    private CarRepository carRepository;

    @Before
    public void setUp() throws Exception {
        carRepository = new CarRepository();
    }

    @Test
    public void testFindByColor() throws Exception {
        Car redCar = new Car();
        redCar.setRoofType(HARDTOP);
        redCar.setColor("red");
        Car savedRedCar = carRepository.save(redCar);

        Car blueCar = new Car();
        blueCar.setColor("blue");
        blueCar.setRoofType(HARDTOP);
        Car savedBlueCar = carRepository.save(blueCar);

        List<Car> redCars = carRepository.findByColor("red");

        assertEquals(redCars.size(), 1);
        assertEquals(redCars.get(0).getId(), savedRedCar.getId());
    }

}