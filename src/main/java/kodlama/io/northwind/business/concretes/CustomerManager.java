package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.CustomerService;
import kodlama.io.northwind.business.dtos.request.customer.CreateCustomerRequest;
import kodlama.io.northwind.business.dtos.response.customer.GetCustomerResponse;
import kodlama.io.northwind.business.dtos.response.customer.ListCustomerResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.CustomerRepository;
import kodlama.io.northwind.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<ListCustomerResponse>> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<ListCustomerResponse> responses = customers.stream()
                .map(customer -> modelMapperService.forResponse().map(customer,ListCustomerResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responses,"data listed");
    }

    @Override
    public DataResult<GetCustomerResponse> addCustomer(CreateCustomerRequest createCustomerRequest) {
        Customer customer = modelMapperService.forRequest().map(createCustomerRequest,Customer.class);
        Customer savedCustomer = customerRepository.save(customer);
        GetCustomerResponse response = modelMapperService.forResponse().map(savedCustomer,GetCustomerResponse.class);

        return new SuccessDataResult<>(response,"data added");
    }
}
