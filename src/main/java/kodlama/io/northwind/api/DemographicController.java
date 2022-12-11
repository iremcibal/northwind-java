package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.DemographicService;
import kodlama.io.northwind.business.dtos.request.customerDemographic.CreateCustDemoRequest;
import kodlama.io.northwind.business.dtos.request.demographic.CreateDemographicRequest;
import kodlama.io.northwind.business.dtos.response.customerDemographic.GetCustDemoResponse;
import kodlama.io.northwind.business.dtos.response.customerDemographic.ListCustDemoResponse;
import kodlama.io.northwind.business.dtos.response.demographic.GetDemographicResponse;
import kodlama.io.northwind.business.dtos.response.demographic.ListDemographicResponse;
import kodlama.io.northwind.entities.concretes.Demographic;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demographics")
@AllArgsConstructor
public class DemographicController {
    private DemographicService service;

    @GetMapping("/getAll")
    public List<ListDemographicResponse> getAll(){
        return service.getAll();
    }

    @PostMapping("/addDemographic")
    public GetDemographicResponse add(@RequestBody CreateDemographicRequest createDemographicRequest){
        return service.addDemographic(createDemographicRequest);
    }
}
