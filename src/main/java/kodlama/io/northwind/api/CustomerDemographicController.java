package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.CustomerDemographicService;
import kodlama.io.northwind.business.dtos.request.category.CreateCategoryRequest;
import kodlama.io.northwind.business.dtos.request.customerDemographic.CreateCustDemoRequest;
import kodlama.io.northwind.business.dtos.response.category.GetCategoryResponse;
import kodlama.io.northwind.business.dtos.response.category.ListCategoryResponse;
import kodlama.io.northwind.business.dtos.response.customerDemographic.GetCustDemoResponse;
import kodlama.io.northwind.business.dtos.response.customerDemographic.ListCustDemoResponse;
import kodlama.io.northwind.core.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customerDemographics")
@AllArgsConstructor
public class CustomerDemographicController {
    private CustomerDemographicService service;

    @GetMapping("/getAll")
    public DataResult<List<ListCustDemoResponse>> getAll(){
        return service.getAll();
    }

    @PostMapping("/addCustDemo")
    public DataResult<GetCustDemoResponse> add(@RequestBody CreateCustDemoRequest createCustDemoRequest){
        return service.addCustDemo(createCustDemoRequest);
    }
}
