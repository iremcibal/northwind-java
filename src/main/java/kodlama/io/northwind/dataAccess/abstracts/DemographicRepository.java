package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.entities.concretes.Demographic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemographicRepository extends JpaRepository<Demographic,String> {
}
