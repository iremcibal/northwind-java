package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.EmployeeTerritoriesService;
import kodlama.io.northwind.business.dtos.request.employeeTerritories.CreateEmpTerriRequest;
import kodlama.io.northwind.business.dtos.response.employeeTerritories.GetEmpTerriResponse;
import kodlama.io.northwind.business.dtos.response.employeeTerritories.ListEmpTerriResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.EmployeeTerritoriesRepository;
import kodlama.io.northwind.entities.concretes.EmployeeTerritories;
import kodlama.io.northwind.entities.dtos.EmployeeTerritoryDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeTerritoriesManager implements EmployeeTerritoriesService {
    private EmployeeTerritoriesRepository repository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<ListEmpTerriResponse>> getAll() {
        List<EmployeeTerritories> employeeTerritories = repository.findAll();
        List<ListEmpTerriResponse> responses = employeeTerritories.stream()
                .map(employeeTerritory -> modelMapperService.forResponse().map(employeeTerritory,ListEmpTerriResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responses,"data listed");
    }

    @Override
    public DataResult<GetEmpTerriResponse> addEmpTerri(CreateEmpTerriRequest createEmpTerriRequest) {
        EmployeeTerritories employeeTerritories = modelMapperService.forRequest().map(createEmpTerriRequest,EmployeeTerritories.class);
        EmployeeTerritories savedEmpTerri = repository.save(employeeTerritories);
        GetEmpTerriResponse response = modelMapperService.forResponse().map(savedEmpTerri,GetEmpTerriResponse.class);

        return new SuccessDataResult<>(response,"data added");
    }

    @Override
    public DataResult<List<EmployeeTerritoryDto>> getByEmployerTerritoryId(int empTerriId) {
        List<EmployeeTerritoryDto> dto = repository.getByEmployerTerritoryId(empTerriId);
        return new SuccessDataResult<>(dto,"data listed");
    }
}
