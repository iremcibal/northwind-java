package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.entities.concretes.UsState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsStateRepository extends JpaRepository<UsState,Integer> {
}
