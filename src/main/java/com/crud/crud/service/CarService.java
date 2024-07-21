package com.crud.crud.service;

import com.crud.crud.model.Car;

import java.util.List;

public interface CarService {

    Car addCar(Car car);
    List<Car> getCar();
    Car updateCar(Long id, Car car);
    String deleteCar(Long id);
}
