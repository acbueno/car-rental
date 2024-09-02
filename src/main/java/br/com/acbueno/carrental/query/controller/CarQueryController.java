package br.com.acbueno.carrental.query.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.acbueno.carrental.command.model.Car;
import br.com.acbueno.carrental.dto.CarResponseDTO;
import br.com.acbueno.carrental.mapper.CarMapper;
import br.com.acbueno.carrental.query.service.CarQueryService;

@RestController
@RequestMapping("/cars/query")
public class CarQueryController {

  @Autowired
  private CarQueryService carQueryService;

  @Autowired
  private CarMapper carMapper;

  @GetMapping("/id/{id}")
  public ResponseEntity<CarResponseDTO> getCar(@PathVariable("id") Long id) {
    CarResponseDTO value = carMapper.convertToCarResponseDTO(carQueryService.getCar(id));
    return ResponseEntity.ok(value);
  }

  @GetMapping
  public ResponseEntity<List<CarResponseDTO>> getAllCars() {
    List<CarResponseDTO> listCarsReponse = new ArrayList<>();
    List<Car> listCars = carQueryService.getAllCars();
    for (Car car : listCars) {
      listCarsReponse.add(carMapper.convertToCarResponseDTO(car));
    }
    return ResponseEntity.ok(listCarsReponse);
  }

  @GetMapping("/type/{type}")
  public ResponseEntity<List<CarResponseDTO>> getAllCarsByType(@PathVariable("type") String type) {
    List<CarResponseDTO> listCarResponse = new ArrayList<>();
    carQueryService.getListCarByType(type).forEach(c -> {
      listCarResponse.add(carMapper.convertToCarResponseDTO(c));
    });
    return ResponseEntity.ok(listCarResponse);
  }

  @GetMapping("/category/{category}")
  public ResponseEntity<List<CarResponseDTO>> getAllCarsByCategory(
      @PathVariable("category") String category) {
    List<CarResponseDTO> listCarResponse = new ArrayList<>();
    carQueryService.getListCarTypeCategory(category).forEach(c -> {
      listCarResponse.add(carMapper.convertToCarResponseDTO(c));
    });
    return ResponseEntity.ok(listCarResponse);
  }

}
