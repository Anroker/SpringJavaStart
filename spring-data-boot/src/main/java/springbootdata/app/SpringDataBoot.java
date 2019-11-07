package springbootdata.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import springbootdata.app.model.Car;
import springbootdata.app.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataBoot {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringDataBoot.class);

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("A4", "Audi", 49000.0));
        cars.add(new Car("Auris", "Toyota", 35000.0));
        cars.add(new Car("Insignia", "Opel", 29500.0));

        CarRepository carRepo = ctx.getBean(CarRepository.class);
        cars.forEach(carRepo::save); //zapisujemy samochody

        Car firstCar = carRepo.findById(1L).get(); //pobieramy pierwszy
        carRepo.delete(firstCar); //usuwamy go

        //pobieramy i wyświetlamy pozostałe
        carRepo.findAll().forEach(System.out::println);

        ctx.close();
    }
}