package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.AddressService;
import kodlama.io.northwind.business.dtos.request.address.CreateAddressRequest;
import kodlama.io.northwind.business.dtos.request.category.CreateCategoryRequest;
import kodlama.io.northwind.business.dtos.response.address.GetAddressResponse;
import kodlama.io.northwind.business.dtos.response.address.ListAddressResponse;
import kodlama.io.northwind.business.dtos.response.category.GetCategoryResponse;
import kodlama.io.northwind.business.dtos.response.category.ListCategoryResponse;
import kodlama.io.northwind.core.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class AddressController {
    private AddressService addressService;

    @GetMapping("/getAll")
    public DataResult<List<ListAddressResponse>> getAll(){
        return addressService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetAddressResponse> getById(@RequestParam("id") int id){
        return addressService.getById(id);
    }

    @PostMapping("/addAddress")
    public DataResult<GetAddressResponse> add(@Valid @RequestBody CreateAddressRequest createAddressRequest){
        return addressService.addAddress(createAddressRequest);
    }
}
