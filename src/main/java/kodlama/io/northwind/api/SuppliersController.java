package kodlama.io.northwind.api;


import kodlama.io.northwind.business.abstracts.SupplierService;
import kodlama.io.northwind.business.dtos.request.product.CreateProductRequest;
import kodlama.io.northwind.business.dtos.request.product.UpdateProductRequest;
import kodlama.io.northwind.business.dtos.request.supplier.CreateSupplierRequest;
import kodlama.io.northwind.business.dtos.request.supplier.UpdateSupplierRequest;
import kodlama.io.northwind.business.dtos.response.product.GetProductResponse;
import kodlama.io.northwind.business.dtos.response.supplier.GetSupplierResponse;
import kodlama.io.northwind.business.dtos.response.supplier.ListSupplierResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;
import kodlama.io.northwind.entities.concretes.Product;
import kodlama.io.northwind.entities.concretes.Supplier;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@AllArgsConstructor
public class SuppliersController {
    private SupplierService supplierService;

    @GetMapping("/getAll")
    public DataResult<List<ListSupplierResponse>> getAll(){
        return supplierService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetSupplierResponse> getById(@RequestParam("id") int id){
        return supplierService.getById(id);
    }

    @PostMapping("/addSupplier")
    public DataResult<GetSupplierResponse> add(@RequestBody CreateSupplierRequest createSupplierRequest){
        return supplierService.addSupplier(createSupplierRequest);
    }
    @PutMapping("/update")
    public DataResult<GetSupplierResponse> update(@Valid @RequestBody UpdateSupplierRequest updateSupplierRequest, int id){
        return supplierService.update(updateSupplierRequest,id);
    }
    @DeleteMapping("/delete")
    public Result delete(int id){
        return supplierService.delete(id);
    }
}
