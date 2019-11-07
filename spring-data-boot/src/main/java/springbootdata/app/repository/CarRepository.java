package springbootdata.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springbootdata.app.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
}