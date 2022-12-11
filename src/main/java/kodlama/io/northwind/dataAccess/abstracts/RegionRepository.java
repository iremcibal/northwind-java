package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.entities.concretes.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region,Integer> {
}
