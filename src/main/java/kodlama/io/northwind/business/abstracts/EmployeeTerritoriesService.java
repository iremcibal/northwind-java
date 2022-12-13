package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.demographic.CreateDemographicRequest;
import kodlama.io.northwind.business.dtos.request.employeeTerritories.CreateEmpTerriRequest;
import kodlama.io.northwind.business.dtos.response.demographic.GetDemographicResponse;
import kodlama.io.northwind.business.dtos.response.demographic.ListDemographicResponse;
import kodlama.io.northwind.business.dtos.response.employeeTerritories.GetEmpTerriResponse;
import kodlama.io.northwind.business.dtos.response.employeeTerritories.ListEmpTerriResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.entities.dtos.EmployeeTerritoryDto;

import java.util.List;

public interface EmployeeTerritoriesService {
    DataResult<List<ListEmpTerriResponse>> getAll();
    DataResult<GetEmpTerriResponse> addEmpTerri(CreateEmpTerriRequest createEmpTerriRequest);
    DataResult<List<ListEmpTerriResponse>> getByEmployerTerritoryId(int empTerriId);
}
