package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.CategoryService;
import kodlama.io.northwind.business.abstracts.SupplierService;
import kodlama.io.northwind.entities.concretes.Category;
import kodlama.io.northwind.entities.concretes.Supplier;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoriesController {

    private CategoryService categoryService;

    @GetMapping("/getAll")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/getById")
    public Category getById(@RequestParam("id") int id){
        return categoryService.getById(id);
    }

   /* @PostMapping()
    public Product add(@RequestBody CreateProductRequest createProductRequest){
        return supplierService.addProduct(createProductRequest);
    }*/
}
