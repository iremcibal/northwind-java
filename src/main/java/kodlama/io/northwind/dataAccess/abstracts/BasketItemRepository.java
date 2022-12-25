package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.entities.concretes.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketItemRepository extends JpaRepository<BasketItem,Integer> {
}
