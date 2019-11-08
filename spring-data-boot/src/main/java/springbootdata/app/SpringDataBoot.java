package springbootdata.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import springbootdata.app.model.Employee;
import springbootdata.app.repository.EmployeeRepository;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringDataBoot {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringDataBoot.class);

        EmployeeRepository repository = ctx.getBean(EmployeeRepository.class);

        Stream.of(
                new Employee("Wojtek", "Kowalski", 3000.0),
                new Employee("Barnabasz", "Rabarbar", 4000.0),
                new Employee("Rumcajs", "styczka", 5000.0),
                new Employee("Ratatator", "Rotototor", 6000.0)
        ).forEach(repository::save);

        System.out.println("Employees with last name Kowalski and salary >=2000");
        repository.findByLastNameAndSalary("Kowalski", 2000).forEach(System.out::println);
        System.out.println();

        System.out.println("Employee names with salary >= 4000");
        repository.namesForSalaryAsc(4000)
                .forEach(System.out::println);

        /*List<Car> cars = new ArrayList<>();
        cars.add(new Car("A4", "Audi", 49000.0));
        cars.add(new Car("A5", "Audi", 67000.0));
        cars.add(new Car("Auris", "Toyota", 35000.0));
        cars.add(new Car("Insignia", "Opel", 29500.0));
        cars.add(new Car("A8", "Audi", 28000.0));
        cars.add(new Car("Corolla", "Toyota", 31000.0));
        cars.add(new Car("Vectra", "Opel", 29500.0));
        cars.add(new Car("Astra", "Opel", 29500.0));

        CarRepository carRepo = ctx.getBean(CarRepository.class);
        cars.forEach(carRepo::save); //zapisujemy samochody

        System.out.println("Toyota cars:");
        List<Car> toyotaCars = carRepo.findByBrand("Toyota");
        toyotaCars.forEach(System.out::println);
        System.out.println();

        System.out.println("First Opel Car:");
        Car firstOpel = carRepo.findFirstByBrand("Opel");
        System.out.println(firstOpel + "\n");

        System.out.println("Audi for 49000: ");
        carRepo.findAllByBrandAndPrice("Audi", 49000).forEach(System.out::println);
        System.out.println("Toyota or Opel:");
        carRepo.findAllByBrandOrBrand("Toyota", "Opel").forEach(System.out::println);
        System.out.println();

        System.out.println("All Audi cars, price ascending");
        carRepo.findAllByBrandOrderByPriceAsc("Audi")
                .forEach(System.out::println);
        System.out.println();

        Car firstCar = carRepo.findById(1L).get(); //pobieramy pierwszy
        carRepo.delete(firstCar); //usuwamy go

        //pobieramy i wyświetlamy pozostałe
        carRepo.findAll().forEach(System.out::println);*/

        ctx.close();
    }
}