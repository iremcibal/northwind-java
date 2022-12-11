package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.customer.CreateCustomerRequest;
import kodlama.io.northwind.business.dtos.request.customerDemographic.CreateCustDemoRequest;
import kodlama.io.northwind.business.dtos.response.customer.GetCustomerResponse;
import kodlama.io.northwind.business.dtos.response.customer.ListCustomerResponse;
import kodlama.io.northwind.business.dtos.response.customerDemographic.GetCustDemoResponse;
import kodlama.io.northwind.business.dtos.response.customerDemographic.ListCustDemoResponse;

import java.util.List;

public interface CustomerDemographicService {
    List<ListCustDemoResponse> getAll();
    GetCustDemoResponse addCustDemo(CreateCustDemoRequest createCustDemoRequest);
}
