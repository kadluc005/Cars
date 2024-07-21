package com.crud.crud.controller;

import com.crud.crud.model.Car;
import com.crud.crud.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@AllArgsConstructor
public class ProduitController {

    private final CarService carService;

    @PostMapping("/addCar")
    public Car addCar(@RequestBody Car car){
        return carService.addCar(car);
    }

    @GetMapping("cars")
    public List<Car> getCars(){
        return carService.getCar();
    }

    @PutMapping("/update/{id}")
    public Car update(@PathVariable Long id, @RequestBody Car car){
        return carService.updateCar(id, car);
    }

    @DeleteMapping("/delete/{id}")
    public String deletaCar(@PathVariable Long id){
        return carService.deleteCar(id);
    }
}
