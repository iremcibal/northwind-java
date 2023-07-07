package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.EmployeeService;
import kodlama.io.northwind.business.businessRules.EmployeeBusinessRules;
import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.business.dtos.request.employee.CreateEmployeeRequest;
import kodlama.io.northwind.business.dtos.request.employee.UpdateEmployeeRequest;
import kodlama.io.northwind.business.dtos.response.employee.GetEmployeeResponse;
import kodlama.io.northwind.business.dtos.response.employee.ListEmployeeResponse;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.results.SuccessResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.EmployeeRepository;
import kodlama.io.northwind.entities.concretes.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapperService modelMapperService;
    private MessageService messageService;
    private EmployeeBusinessRules employeeBusinessRules;

    @Override
    public DataResult<List<ListEmployeeResponse>> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<ListEmployeeResponse> responses = employees.stream()
                .map(employee -> modelMapperService.forResponse().map(employee,ListEmployeeResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responses,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public DataResult<GetEmployeeResponse> addEmployee(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = modelMapperService.forRequest().map(createEmployeeRequest,Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        GetEmployeeResponse response = modelMapperService.forResponse().map(savedEmployee,GetEmployeeResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataAdded));
    }

    @Override
    public DataResult<GetEmployeeResponse> update(UpdateEmployeeRequest request, int id) {
        employeeBusinessRules.checkIfEmployeeExistById(id);
        Employee employee = modelMapperService.forRequest().map(request,Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        GetEmployeeResponse response = modelMapperService.forResponse().map(savedEmployee,GetEmployeeResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataUpdated));
    }

    @Override
    public Result delete(int id) {
        employeeBusinessRules.checkIfEmployeeExistById(id);
        employeeRepository.deleteById(id);

        return new SuccessResult(messageService.getMessage(Messages.Data.dataDeleted));
    }
}
