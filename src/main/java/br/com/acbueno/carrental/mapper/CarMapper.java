package br.com.acbueno.carrental.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.acbueno.carrental.command.model.Car;
import br.com.acbueno.carrental.dto.CarRequestDTO;
import br.com.acbueno.carrental.dto.CarResponseDTO;

@Component
public class CarMapper {

  @Autowired
  private ModelMapper modelMapper;

  public Car converToEntity(CarRequestDTO request) {
    return modelMapper.map(request, Car.class);
  }

  public CarResponseDTO convertToCarResponseDTO(Car entity) {
    return modelMapper.map(entity, CarResponseDTO.class);
  }

}
