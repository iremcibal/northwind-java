package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.customer.CreateCustomerRequest;
import kodlama.io.northwind.business.dtos.response.customer.GetCustomerResponse;
import kodlama.io.northwind.business.dtos.response.customer.ListCustomerResponse;
import kodlama.io.northwind.core.results.DataResult;

import java.util.List;

public interface CustomerService {
    DataResult<List<ListCustomerResponse>> getAll();
    DataResult<GetCustomerResponse> addCustomer(CreateCustomerRequest createCustomerRequest);
}
