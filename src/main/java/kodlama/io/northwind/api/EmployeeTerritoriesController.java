package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.EmployeeTerritoriesService;
import kodlama.io.northwind.business.dtos.request.demographic.CreateDemographicRequest;
import kodlama.io.northwind.business.dtos.request.employeeTerritories.CreateEmpTerriRequest;
import kodlama.io.northwind.business.dtos.response.demographic.GetDemographicResponse;
import kodlama.io.northwind.business.dtos.response.demographic.ListDemographicResponse;
import kodlama.io.northwind.business.dtos.response.employeeTerritories.GetEmpTerriResponse;
import kodlama.io.northwind.business.dtos.response.employeeTerritories.ListEmpTerriResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employeeTerritories")
@AllArgsConstructor
public class EmployeeTerritoriesController {
    private EmployeeTerritoriesService service;

    @GetMapping("/getAll")
    public List<ListEmpTerriResponse> getAll(){
        return service.getAll();
    }

    @PostMapping("/addEmployeeTerritory")
    public GetEmpTerriResponse add(@RequestBody CreateEmpTerriRequest createEmpTerriRequest){
        return service.addEmpTerri(createEmpTerriRequest);
    }
}
