package com.ani.testing.service;

import com.ani.testing.domain.Car;
import com.ani.testing.service.exception.InvalidIdException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public Car saveCar(Car car) {

        return car;
    }

    @Override
    public Optional<Car> findCarById(Long id) {
        if (id <= 0) try {
            throw new InvalidIdException("Id must be positive : " + id);
        } catch (InvalidIdException e) {
            e.printStackTrace();
        }
        return Optional.of(new Car());
    }
}
