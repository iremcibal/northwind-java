package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.AddressService;
import kodlama.io.northwind.business.dtos.request.address.CreateAddressRequest;
import kodlama.io.northwind.business.dtos.request.address.UpdateAddressRequest;
import kodlama.io.northwind.business.dtos.request.category.CreateCategoryRequest;
import kodlama.io.northwind.business.dtos.response.address.GetAddressResponse;
import kodlama.io.northwind.business.dtos.response.address.ListAddressResponse;
import kodlama.io.northwind.business.dtos.response.category.GetCategoryResponse;
import kodlama.io.northwind.business.dtos.response.category.ListCategoryResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class AddressController {
    @Autowired
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

    @GetMapping("getWithPagination")
    public DataResult<Slice<ListAddressResponse>> getAll(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return addressService.getAllWithPagination(pageable);
    }

    @PutMapping("/update")
    public DataResult<GetAddressResponse> update(@Valid @RequestBody UpdateAddressRequest updateAddressRequest,int id){
        return addressService.update(updateAddressRequest,id);
    }
    @DeleteMapping("/delete")
    public Result delete(int id){
        return addressService.delete(id);
    }
}
