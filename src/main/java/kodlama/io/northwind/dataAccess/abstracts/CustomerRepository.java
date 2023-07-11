package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.business.dtos.response.customer.GetCustomerResponse;
import kodlama.io.northwind.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer getCustomerByCustomerId(String id);
    boolean existsCustomerByCustomerId(String id);

}
