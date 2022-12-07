package kodlama.io.northwind.api;


import kodlama.io.northwind.business.abstracts.SupplierService;
import kodlama.io.northwind.business.dtos.request.product.CreateProductRequest;
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
    public List<Supplier> getAll(){
        return supplierService.getAll();
    }

    @GetMapping("/getById")
    public Supplier getById(@RequestParam("id") int id){
        return supplierService.getById(id);
    }

   /* @PostMapping()
    public Product add(@RequestBody CreateProductRequest createProductRequest){
        return supplierService.addProduct(createProductRequest);
    }*/
}
