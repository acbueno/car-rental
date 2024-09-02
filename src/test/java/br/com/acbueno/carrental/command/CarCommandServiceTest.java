package br.com.acbueno.carrental.command;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import br.com.acbueno.carrental.command.model.Car;
import br.com.acbueno.carrental.command.model.enums.Category;
import br.com.acbueno.carrental.command.model.enums.Type;
import br.com.acbueno.carrental.command.repository.CarCommandRepository;
import br.com.acbueno.carrental.command.service.CarCommandService;
import br.com.acbueno.carrental.dto.CarRequestDTO;
import br.com.acbueno.carrental.mapper.CarMapper;

public class CarCommandServiceTest {

  @Mock
  private CarCommandRepository carCommandRepository;

  @Mock
  private CarMapper carMapper;

  @InjectMocks
  private CarCommandService carCommandService;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testSaveCar() {
    CarRequestDTO carRequestDTO = new CarRequestDTO();
    carRequestDTO.setModel("Chery Tiggo 7 Pro");
    carRequestDTO.setBrand("Cao Chery");
    carRequestDTO.setLicensePlate("XYZ0I12");
    carRequestDTO.setCategory(Category.B);
    carRequestDTO.setYearModel(2022);
    carRequestDTO.setType(Type.SUV);

    Car carEntity = new Car();
    carEntity.setBrand(carRequestDTO.getBrand());
    carEntity.setModel(carRequestDTO.getModel());
    carEntity.setCategory(carRequestDTO.getCategory());
    carEntity.setType(carRequestDTO.getType());
    carEntity.setLicensePlate(carRequestDTO.getLicensePlate());
    carEntity.setYearModel(carRequestDTO.getYearModel());

    // Usando Mockito para simular o comportamento do mapper e do repositório
    when(carMapper.converToEntity(any(CarRequestDTO.class))).thenReturn(carEntity);
    when(carCommandRepository.save(any(Car.class))).thenReturn(carEntity);

    Car result = carCommandService.addCar(carEntity);

    assertNotNull(result);
  }

}
