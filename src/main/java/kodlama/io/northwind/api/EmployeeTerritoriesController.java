package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.EmployeeTerritoriesService;
import kodlama.io.northwind.business.dtos.request.demographic.CreateDemographicRequest;
import kodlama.io.northwind.business.dtos.request.employeeTerritories.CreateEmpTerriRequest;
import kodlama.io.northwind.business.dtos.response.demographic.GetDemographicResponse;
import kodlama.io.northwind.business.dtos.response.demographic.ListDemographicResponse;
import kodlama.io.northwind.business.dtos.response.employeeTerritories.GetEmpTerriResponse;
import kodlama.io.northwind.business.dtos.response.employeeTerritories.ListEmpTerriResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.entities.dtos.EmployeeTerritoryDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employeeTerritories")
@AllArgsConstructor
public class EmployeeTerritoriesController {
    private EmployeeTerritoriesService service;

    @GetMapping("/getAll")
    public DataResult<List<ListEmpTerriResponse>> getAll(){
        return service.getAll();
    }

    @PostMapping("/addEmployeeTerritory")
    public DataResult<GetEmpTerriResponse> add(@RequestBody CreateEmpTerriRequest createEmpTerriRequest){
        return service.addEmpTerri(createEmpTerriRequest);
    }

    @GetMapping("getByEmployerTerritoryId")
    public DataResult<List<ListEmpTerriResponse>> getByEmployerTerritoryId(int empTerriId){
        return service.getByEmployerTerritoryId(empTerriId);
    }
}
