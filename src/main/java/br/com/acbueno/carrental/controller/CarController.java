package br.com.acbueno.carrental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.acbueno.carrental.command.model.Car;
import br.com.acbueno.carrental.command.service.CarCommandService;
import br.com.acbueno.carrental.dto.CarRequestDTO;
import br.com.acbueno.carrental.dto.CarResponseDTO;
import br.com.acbueno.carrental.mapper.CarMapper;

@RestController
@RequestMapping("/cars")
public class CarController {

  @Autowired
  private CarCommandService carCommandService;

  @Autowired
  private CarMapper carModelMapper;

  @PostMapping
  public ResponseEntity<Void> addCar(@RequestBody CarRequestDTO request) {
    Car entity = carModelMapper.converToEntity(request);
    carCommandService.addCar(entity);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PatchMapping("/{id}/availability")
  public ResponseEntity<CarResponseDTO> updatCarAvailability(@PathVariable("id") Long id,
      @RequestParam boolean available) {
    Car entity = carCommandService.updateCarAvailability(id, available);
    CarResponseDTO carResponseDTO = carModelMapper.convertToCarResponseDTO(entity);
    return ResponseEntity.ok(carResponseDTO);
  }

}
