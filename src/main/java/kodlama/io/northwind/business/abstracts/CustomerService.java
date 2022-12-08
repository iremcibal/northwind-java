package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.customer.CreateCustomerRequest;
import kodlama.io.northwind.business.dtos.response.customer.GetCustomerResponse;
import kodlama.io.northwind.business.dtos.response.customer.ListCustomerResponse;

import java.util.List;

public interface CustomerService {
    List<ListCustomerResponse> getAll();
    GetCustomerResponse addCustomer(CreateCustomerRequest createCustomerRequest);
}
