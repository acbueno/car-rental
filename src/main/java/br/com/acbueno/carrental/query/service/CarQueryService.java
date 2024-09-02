package br.com.acbueno.carrental.query.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import br.com.acbueno.carrental.command.model.Car;
import br.com.acbueno.carrental.command.repository.CarCommandRepository;

@Service
public class CarQueryService {

  @Autowired
  private CarCommandRepository carCommandRepository;

  @Cacheable(value = "cars", key = "id")
  public Car getCar(Long id) {
    return carCommandRepository.findById(id).orElse(null);
  }

  @Cacheable(value = "carList")
  public List<Car> getAllCars() {
    return carCommandRepository.findAll();
  }

  @Cacheable(value = "carListAvailable")
  public List<Car> getAllCarAvailable() {
    //@formatter:off 
    return carCommandRepository.findAll()
         .stream().filter(Car::isAvailable)
         .collect(Collectors.toList());
    //@formatter:on
  }

  @Cacheable(value = "carListType")
  public List<Car> getListCarByType(String type) {
    List<Car> listCarByType = new ArrayList<>();
    carCommandRepository.findAll().forEach(c -> {
      if (c.getType().name().equals(type.toUpperCase())) {
        listCarByType.add(c);
      }
    });;
    return listCarByType;
  }

  @Cacheable(value = "carListCategory")
  public List<Car> getListCarTypeCategory(String category) {
    List<Car> listCarByCategory = new ArrayList<>();
    carCommandRepository.findAll().forEach(c -> {
      if (c.getCategory().name().equals(category.toUpperCase())) {
        listCarByCategory.add(c);
      }
    });
    return listCarByCategory;
  }

}
