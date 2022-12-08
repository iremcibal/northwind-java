package kodlama.io.northwind.api;


import kodlama.io.northwind.business.abstracts.SupplierService;
import kodlama.io.northwind.business.dtos.request.product.CreateProductRequest;
import kodlama.io.northwind.business.dtos.request.supplier.CreateSupplierRequest;
import kodlama.io.northwind.business.dtos.response.supplier.GetSupplierResponse;
import kodlama.io.northwind.business.dtos.response.supplier.ListSupplierResponse;
import kodlama.io.northwind.entities.concretes.Product;
import kodlama.io.northwind.entities.concretes.Supplier;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@AllArgsConstructor
public class SuppliersController {
    private SupplierService supplierService;

    @GetMapping("/getAll")
    public List<ListSupplierResponse> getAll(){
        return supplierService.getAll();
    }

    @GetMapping("/getById")
    public GetSupplierResponse getById(@RequestParam("id") int id){
        return supplierService.getById(id);
    }

    @PostMapping("/addSupplier")
    public GetSupplierResponse add(@RequestBody CreateSupplierRequest createSupplierRequest){
        return supplierService.addSupplier(createSupplierRequest);
    }
}
