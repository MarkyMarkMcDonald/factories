package com.example;

import com.example.factories.CarFactory;
import com.factories.Builder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class CarRepositoryTest {

    private CarRepository carRepository;
    private CarFactory carFactory;

    @Before
    public void setUp() throws Exception {
        carRepository = new CarRepository();
        carFactory = new CarFactory(carRepository);
    }

    @Test
    public void testFindByColor() throws Exception {
        Car savedRedCar = carFactory.create(carBuilder -> carBuilder.color("red"));
        Car savedBlueCar = carFactory.create(carBuilder -> carBuilder.color("blue"));

        List<Car> redCars = carRepository.findByColor("red");

        assertEquals(redCars.size(), 1);
        assertEquals(redCars.get(0).getId(), savedRedCar.getId());
    }

}