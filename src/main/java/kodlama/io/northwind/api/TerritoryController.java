package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.TerritoryService;
import kodlama.io.northwind.business.dtos.request.region.CreateRegionRequest;
import kodlama.io.northwind.business.dtos.request.territory.CreateTerritoryRequest;
import kodlama.io.northwind.business.dtos.response.region.GetRegionResponse;
import kodlama.io.northwind.business.dtos.response.region.ListRegionResponse;
import kodlama.io.northwind.business.dtos.response.territory.GetTerritoryResponse;
import kodlama.io.northwind.business.dtos.response.territory.ListTerritoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/territories")
@AllArgsConstructor
public class TerritoryController {
    private TerritoryService service;

    @GetMapping("/getAll")
    public List<ListTerritoryResponse> getAll(){
        return service.getAll();
    }

    @PostMapping("/addTerritory")
    public GetTerritoryResponse add(@RequestBody CreateTerritoryRequest createTerritoryRequest){
        return service.addTerritory(createTerritoryRequest);
    }

}
