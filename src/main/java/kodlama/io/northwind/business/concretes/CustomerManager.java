package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.CustomerService;
import kodlama.io.northwind.business.businessRules.CustomerBusinessRules;
import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.business.dtos.request.customer.CreateCustomerRequest;
import kodlama.io.northwind.business.dtos.request.customer.UpdateCustomerRequest;
import kodlama.io.northwind.business.dtos.response.customer.GetCustomerResponse;
import kodlama.io.northwind.business.dtos.response.customer.ListCustomerResponse;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.results.SuccessResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.CustomerRepository;
import kodlama.io.northwind.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;
    private MessageService messageService;
    private CustomerBusinessRules customerBusinessRules;

    @Override
    public DataResult<List<ListCustomerResponse>> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<ListCustomerResponse> responses = customers.stream()
                .map(customer -> modelMapperService.forResponse().map(customer,ListCustomerResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responses,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public DataResult<GetCustomerResponse> addCustomer(CreateCustomerRequest createCustomerRequest) {
        Customer customer = modelMapperService.forRequest().map(createCustomerRequest,Customer.class);
        Customer savedCustomer = customerRepository.save(customer);
        GetCustomerResponse response = modelMapperService.forResponse().map(savedCustomer,GetCustomerResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataAdded));
    }

    @Override
    public DataResult<GetCustomerResponse> getById(String id) {
        Customer detail = customerRepository.getCustomerByCustomerId(id);
        GetCustomerResponse response = modelMapperService.forResponse().map(detail,GetCustomerResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public DataResult<Customer> getByCustomerId(String id) {
        Customer customer = customerRepository.getCustomerByCustomerId(id);
        return new SuccessDataResult<>(customer,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public DataResult<GetCustomerResponse> update(UpdateCustomerRequest request, int id) {
        customerBusinessRules.checkIfCustomerExistById(id);
        Customer customer = modelMapperService.forRequest().map(request,Customer.class);
        Customer savedCustomer = customerRepository.save(customer);
        GetCustomerResponse response = modelMapperService.forResponse().map(savedCustomer,GetCustomerResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataUpdated));
    }

    @Override
    public Result delete(int id) {
        customerBusinessRules.checkIfCustomerExistById(id);
        customerRepository.deleteById(id);

        return new SuccessResult(messageService.getMessage(Messages.Data.dataDeleted));
    }
}
