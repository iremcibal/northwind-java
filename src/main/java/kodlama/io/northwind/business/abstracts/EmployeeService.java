package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.employee.CreateEmployeeRequest;
import kodlama.io.northwind.business.dtos.response.employee.GetEmployeeResponse;
import kodlama.io.northwind.business.dtos.response.employee.ListEmployeeResponse;
import kodlama.io.northwind.core.results.DataResult;

import java.util.List;

public interface EmployeeService {
    DataResult<List<ListEmployeeResponse>> getAll();
    DataResult<GetEmployeeResponse> addEmployee(CreateEmployeeRequest createEmployeeRequest);
}
