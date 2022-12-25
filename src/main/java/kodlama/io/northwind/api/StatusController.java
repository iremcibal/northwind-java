package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.StatusService;
import kodlama.io.northwind.business.dtos.request.region.CreateRegionRequest;
import kodlama.io.northwind.business.dtos.request.status.CreateStatusRequest;
import kodlama.io.northwind.business.dtos.response.region.GetRegionResponse;
import kodlama.io.northwind.business.dtos.response.region.ListRegionResponse;
import kodlama.io.northwind.business.dtos.response.status.GetStatusResponse;
import kodlama.io.northwind.business.dtos.response.status.ListStatusResponse;
import kodlama.io.northwind.core.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
@AllArgsConstructor
public class StatusController {
    private StatusService service;

    @GetMapping("/getAll")
    public DataResult<List<ListStatusResponse>> getAll(){
        return service.getAll();
    }

    @PostMapping("/addStatus")
    public DataResult<GetStatusResponse> add(@RequestBody CreateStatusRequest createStatusRequest){
        return service.addStatus(createStatusRequest);
    }
}
