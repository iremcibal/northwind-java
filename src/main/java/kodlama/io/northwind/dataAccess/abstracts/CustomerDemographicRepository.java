package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.entities.concretes.CustomerDemographic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDemographicRepository extends JpaRepository<CustomerDemographic,Integer> {
}
