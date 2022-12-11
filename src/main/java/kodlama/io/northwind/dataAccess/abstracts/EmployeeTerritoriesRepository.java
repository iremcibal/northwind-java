package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.entities.concretes.EmployeeTerritories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTerritoriesRepository extends JpaRepository<EmployeeTerritories,Integer> {
}
