package br.com.acbueno.carrental.command.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.acbueno.carrental.command.model.Car;

public interface CarCommandRepository extends JpaRepository<Car, Long> {

  public List<Car> findByType(String type);

}
