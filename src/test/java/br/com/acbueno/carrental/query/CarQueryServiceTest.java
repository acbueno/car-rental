package br.com.acbueno.carrental.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import br.com.acbueno.carrental.command.model.Car;
import br.com.acbueno.carrental.command.model.enums.Category;
import br.com.acbueno.carrental.command.model.enums.Type;
import br.com.acbueno.carrental.command.repository.CarCommandRepository;
import br.com.acbueno.carrental.mapper.CarMapper;
import br.com.acbueno.carrental.query.service.CarQueryService;

public class CarQueryServiceTest {

  @InjectMocks
  private CarQueryService carQueryService;

  @Mock
  private CarCommandRepository carCommandRepository;

  @Mock
  private CarMapper carMapper;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testFindCarById() {
    Car car = new Car();
    car.setId(1L);
    car.setAvailable(true);
    car.setBrand("Nissan");
    car.setModel("Versa");
    car.setLicensePlate("XYZ0I12");
    car.setType(Type.SEDAN);
    car.setCategory(Category.C);
    car.setYearModel(2024);

    when(carCommandRepository.findById(1L)).thenReturn(Optional.of(car));

    Car result = carQueryService.getCar(1L);

    assertNotNull(result);
    assertEquals(1L, result.getId());
    assertEquals("Versa", result.getModel());
  }

}
