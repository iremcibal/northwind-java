package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.entities.concretes.Territory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerritoryRepository extends JpaRepository<Territory,String> {
}
