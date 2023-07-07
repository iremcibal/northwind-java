package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.country.UpdateCountryRequest;
import kodlama.io.northwind.business.dtos.request.customer.CreateCustomerRequest;
import kodlama.io.northwind.business.dtos.request.customer.UpdateCustomerRequest;
import kodlama.io.northwind.business.dtos.response.country.GetCountryResponse;
import kodlama.io.northwind.business.dtos.response.customer.GetCustomerResponse;
import kodlama.io.northwind.business.dtos.response.customer.ListCustomerResponse;
import kodlama.io.northwind.business.dtos.response.orderDetail.GetOrderDetailResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;
import kodlama.io.northwind.entities.concretes.Customer;

import java.util.List;

public interface CustomerService {
    DataResult<List<ListCustomerResponse>> getAll();
    DataResult<GetCustomerResponse> addCustomer(CreateCustomerRequest createCustomerRequest);
    DataResult<GetCustomerResponse> getById(String id);
    DataResult<Customer> getByCustomerId(String id);
    DataResult<GetCustomerResponse> update(UpdateCustomerRequest request, int id);
    Result delete(int id);
}
