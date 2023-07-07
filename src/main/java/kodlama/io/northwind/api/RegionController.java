package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.RegionService;
import kodlama.io.northwind.business.dtos.request.demographic.CreateDemographicRequest;
import kodlama.io.northwind.business.dtos.request.product.UpdateProductRequest;
import kodlama.io.northwind.business.dtos.request.region.CreateRegionRequest;
import kodlama.io.northwind.business.dtos.request.region.UpdateRegionRequest;
import kodlama.io.northwind.business.dtos.response.demographic.GetDemographicResponse;
import kodlama.io.northwind.business.dtos.response.demographic.ListDemographicResponse;
import kodlama.io.northwind.business.dtos.response.product.GetProductResponse;
import kodlama.io.northwind.business.dtos.response.region.GetRegionResponse;
import kodlama.io.northwind.business.dtos.response.region.ListRegionResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/regions")
@AllArgsConstructor
public class RegionController {
    private RegionService service;

    @GetMapping("/getAll")
    public DataResult<List<ListRegionResponse>> getAll(){
        return service.getAll();
    }

    @PostMapping("/addRegion")
    public DataResult<GetRegionResponse> add(@RequestBody CreateRegionRequest createRegionRequest){
        return service.addRegion(createRegionRequest);
    }
    @PutMapping("/update")
    public DataResult<GetRegionResponse> update(@Valid @RequestBody UpdateRegionRequest updateRegionRequest, int id){
        return service.update(updateRegionRequest,id);
    }
    @DeleteMapping("/delete")
    public Result delete(int id){
        return service.delete(id);
    }
}
