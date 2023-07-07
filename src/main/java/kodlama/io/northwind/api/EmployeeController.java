package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.EmployeeService;
import kodlama.io.northwind.business.dtos.request.customer.CreateCustomerRequest;
import kodlama.io.northwind.business.dtos.request.customer.UpdateCustomerRequest;
import kodlama.io.northwind.business.dtos.request.employee.CreateEmployeeRequest;
import kodlama.io.northwind.business.dtos.request.employee.UpdateEmployeeRequest;
import kodlama.io.northwind.business.dtos.response.customer.GetCustomerResponse;
import kodlama.io.northwind.business.dtos.response.customer.ListCustomerResponse;
import kodlama.io.northwind.business.dtos.response.employee.GetEmployeeResponse;
import kodlama.io.northwind.business.dtos.response.employee.ListEmployeeResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping("/getAll")
    public DataResult<List<ListEmployeeResponse>> getAll(){
        return employeeService.getAll();
    }

    @PostMapping("/addEmployee")
    public DataResult<GetEmployeeResponse> add(@RequestBody CreateEmployeeRequest createEmployeeRequest){
        return employeeService.addEmployee(createEmployeeRequest);
    }
    @PutMapping("/update")
    public DataResult<GetEmployeeResponse> update(@Valid @RequestBody UpdateEmployeeRequest updateEmployeeRequest, int id){
        return employeeService.update(updateEmployeeRequest,id);
    }
    @DeleteMapping("/delete")
    public Result delete(int id){
        return employeeService.delete(id);
    }
}
