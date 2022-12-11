package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.RegionService;
import kodlama.io.northwind.business.dtos.request.demographic.CreateDemographicRequest;
import kodlama.io.northwind.business.dtos.request.region.CreateRegionRequest;
import kodlama.io.northwind.business.dtos.response.demographic.GetDemographicResponse;
import kodlama.io.northwind.business.dtos.response.demographic.ListDemographicResponse;
import kodlama.io.northwind.business.dtos.response.region.GetRegionResponse;
import kodlama.io.northwind.business.dtos.response.region.ListRegionResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
@AllArgsConstructor
public class RegionController {
    private RegionService service;

    @GetMapping("/getAll")
    public List<ListRegionResponse> getAll(){
        return service.getAll();
    }

    @PostMapping("/addRegion")
    public GetRegionResponse add(@RequestBody CreateRegionRequest createRegionRequest){
        return service.addRegion(createRegionRequest);
    }
}
