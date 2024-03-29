package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.CountryService;
import kodlama.io.northwind.business.dtos.request.address.CreateAddressRequest;
import kodlama.io.northwind.business.dtos.request.city.UpdateCityRequest;
import kodlama.io.northwind.business.dtos.request.country.CreateCountryRequest;
import kodlama.io.northwind.business.dtos.request.country.UpdateCountryRequest;
import kodlama.io.northwind.business.dtos.response.address.GetAddressResponse;
import kodlama.io.northwind.business.dtos.response.address.ListAddressResponse;
import kodlama.io.northwind.business.dtos.response.city.GetCityResponse;
import kodlama.io.northwind.business.dtos.response.country.GetCountryResponse;
import kodlama.io.northwind.business.dtos.response.country.ListCountryResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/countries")
@AllArgsConstructor
public class CountryController {
    private CountryService countryService;
    @GetMapping("/getAll")
    public DataResult<List<ListCountryResponse>> getAll(){
        return countryService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetCountryResponse> getById(@RequestParam("id") int id){
        return countryService.getById(id);
    }

    @PostMapping("/addCountry")
    public DataResult<GetCountryResponse> add(@Valid @RequestBody CreateCountryRequest createCountryRequest){
        return countryService.addCountry(createCountryRequest);
    }
    @PutMapping("/update")
    public DataResult<GetCountryResponse> update(@Valid @RequestBody UpdateCountryRequest updateCountryRequest, int id){
        return countryService.update(updateCountryRequest,id);
    }
    @DeleteMapping("/delete")
    public Result delete(int id){
        return countryService.delete(id);
    }
}
