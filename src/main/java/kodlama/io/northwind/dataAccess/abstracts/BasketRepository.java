package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.business.dtos.response.basket.GetBasketResponse;
import kodlama.io.northwind.entities.concretes.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BasketRepository extends JpaRepository<Basket,Integer> {

    @Query("select b from Basket b where b.customer.customerId=:customerId")
    Basket getByCustomer_customerId(String customerId);
}