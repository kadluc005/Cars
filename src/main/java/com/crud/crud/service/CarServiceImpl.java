package com.crud.crud.service;

import com.crud.crud.model.Car;
import com.crud.crud.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getCar() {
        return carRepository.findAll();
    }

    @Override
    public Car updateCar(Long id, Car car) {
        return carRepository.findById(id)
                .map(p -> {
                    p.setPrice(car.getPrice());
                    p.setBrand(car.getBrand());
                    p.setDescription(car.getDescription());
                    return carRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Car not found!"));
    }

    @Override
    public String deleteCar(Long id) {
        carRepository.deleteById(id);
        return "Car deleted successfully!";
    }
}
