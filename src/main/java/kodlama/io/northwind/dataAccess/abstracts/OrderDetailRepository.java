package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.entities.concretes.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
}
