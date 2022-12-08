package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.employee.CreateEmployeeRequest;
import kodlama.io.northwind.business.dtos.response.employee.GetEmployeeResponse;
import kodlama.io.northwind.business.dtos.response.employee.ListEmployeeResponse;

import java.util.List;

public interface EmployeeService {
    List<ListEmployeeResponse> getAll();
    GetEmployeeResponse addEmployee(CreateEmployeeRequest createEmployeeRequest);
}
