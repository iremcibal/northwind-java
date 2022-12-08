package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.EmployeeService;
import kodlama.io.northwind.business.dtos.request.customer.CreateCustomerRequest;
import kodlama.io.northwind.business.dtos.request.employee.CreateEmployeeRequest;
import kodlama.io.northwind.business.dtos.response.customer.GetCustomerResponse;
import kodlama.io.northwind.business.dtos.response.customer.ListCustomerResponse;
import kodlama.io.northwind.business.dtos.response.employee.GetEmployeeResponse;
import kodlama.io.northwind.business.dtos.response.employee.ListEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping("/getAll")
    public List<ListEmployeeResponse> getAll(){
        return employeeService.getAll();
    }

    @PostMapping("/addEmployee")
    public GetEmployeeResponse add(@RequestBody CreateEmployeeRequest createEmployeeRequest){
        return employeeService.addEmployee(createEmployeeRequest);
    }

}
