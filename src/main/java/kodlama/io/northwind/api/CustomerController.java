package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.CustomerService;
import kodlama.io.northwind.business.dtos.request.country.UpdateCountryRequest;
import kodlama.io.northwind.business.dtos.request.customer.CreateCustomerRequest;
import kodlama.io.northwind.business.dtos.request.customer.UpdateCustomerRequest;
import kodlama.io.northwind.business.dtos.response.country.GetCountryResponse;
import kodlama.io.northwind.business.dtos.response.customer.GetCustomerResponse;
import kodlama.io.northwind.business.dtos.response.customer.ListCustomerResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping("/getAll")
    public DataResult<List<ListCustomerResponse>> getAll(){
        return customerService.getAll();
    }

    @PostMapping("/addCustomer")
    public DataResult<GetCustomerResponse> add(@RequestBody CreateCustomerRequest createCustomerRequest){
        return customerService.addCustomer(createCustomerRequest);
    }
    @PutMapping("/update")
    public DataResult<GetCustomerResponse> update(@Valid @RequestBody UpdateCustomerRequest updateCustomerRequest, String id){
        return customerService.update(updateCustomerRequest,id);
    }
    @DeleteMapping("/delete")
    public Result delete(String id){
        return customerService.delete(id);
    }
}
