package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.CityService;
import kodlama.io.northwind.business.dtos.request.address.CreateAddressRequest;
import kodlama.io.northwind.business.dtos.request.city.CreateCityRequest;
import kodlama.io.northwind.business.dtos.response.address.GetAddressResponse;
import kodlama.io.northwind.business.dtos.response.address.ListAddressResponse;
import kodlama.io.northwind.business.dtos.response.city.GetCityResponse;
import kodlama.io.northwind.business.dtos.response.city.ListCityResponse;
import kodlama.io.northwind.core.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
@AllArgsConstructor
public class CityController {
    private CityService cityService;

    @GetMapping("/getAll")
    public DataResult<List<ListCityResponse>> getAll(){
        return cityService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetCityResponse> getById(@RequestParam("id") int id){
        return cityService.getById(id);
    }
    @PostMapping("/addCity")
    public DataResult<GetCityResponse> add(@Valid @RequestBody CreateCityRequest createCityRequest){
        return cityService.addCity(createCityRequest);
    }


}
