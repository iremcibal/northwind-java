package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.UsStateService;
import kodlama.io.northwind.business.dtos.request.customerDemographic.CreateCustDemoRequest;
import kodlama.io.northwind.business.dtos.request.usState.CreateUsStateRequest;
import kodlama.io.northwind.business.dtos.response.customerDemographic.GetCustDemoResponse;
import kodlama.io.northwind.business.dtos.response.usState.GetUsStateResponse;
import kodlama.io.northwind.business.dtos.response.usState.ListUsStateResponse;
import kodlama.io.northwind.core.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usState")
@AllArgsConstructor
public class UsStateController {
    private UsStateService service;

    @GetMapping("/getAll")
    public DataResult<List<ListUsStateResponse>> getAll(){
        return service.getAll();
    }

    @PostMapping("/addUsState")
    public DataResult<GetUsStateResponse> add(@RequestBody CreateUsStateRequest createUsStateRequest){
        return service.addUsState(createUsStateRequest);
    }
}
