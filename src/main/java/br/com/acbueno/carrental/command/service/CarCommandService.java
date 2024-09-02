package br.com.acbueno.carrental.command.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.acbueno.carrental.command.model.Car;
import br.com.acbueno.carrental.command.repository.CarCommandRepository;

@Service
public class CarCommandService {

  @Autowired
  private CarCommandRepository carCommandRepository;

  public Car addCar(Car car) {
    return carCommandRepository.save(car);
  }

  public Car updateCarAvailability(Long id, boolean available) {
    Car car =
        carCommandRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found car"));
    if (car != null) {
      car.setAvailable(available);
      return carCommandRepository.save(car);
    }
    return null;
  }

}
