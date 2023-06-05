package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Integer> {
}
