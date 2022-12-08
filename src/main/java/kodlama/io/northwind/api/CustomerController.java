package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.CustomerService;
import kodlama.io.northwind.business.dtos.request.customer.CreateCustomerRequest;
import kodlama.io.northwind.business.dtos.response.customer.GetCustomerResponse;
import kodlama.io.northwind.business.dtos.response.customer.ListCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping("/getAll")
    public List<ListCustomerResponse> getAll(){
        return customerService.getAll();
    }

    @PostMapping("/addCustomer")
    public GetCustomerResponse add(@RequestBody CreateCustomerRequest createCustomerRequest){
        return customerService.addCustomer(createCustomerRequest);
    }
}
