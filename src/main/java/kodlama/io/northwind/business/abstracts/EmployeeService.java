package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.customer.UpdateCustomerRequest;
import kodlama.io.northwind.business.dtos.request.employee.CreateEmployeeRequest;
import kodlama.io.northwind.business.dtos.request.employee.UpdateEmployeeRequest;
import kodlama.io.northwind.business.dtos.response.customer.GetCustomerResponse;
import kodlama.io.northwind.business.dtos.response.employee.GetEmployeeResponse;
import kodlama.io.northwind.business.dtos.response.employee.ListEmployeeResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;

import java.util.List;

public interface EmployeeService {
    DataResult<List<ListEmployeeResponse>> getAll();
    DataResult<GetEmployeeResponse> addEmployee(CreateEmployeeRequest createEmployeeRequest);
    DataResult<GetEmployeeResponse> update(UpdateEmployeeRequest request, int id);
    Result delete(int id);

}
