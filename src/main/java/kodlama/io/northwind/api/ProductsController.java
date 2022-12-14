package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.business.dtos.request.product.CreateProductRequest;
import kodlama.io.northwind.business.dtos.response.product.GetProductResponse;
import kodlama.io.northwind.business.dtos.response.product.ListProductResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsController {

    private ProductService productService;

    @GetMapping("/getAll")
    public DataResult<List<ListProductResponse>> getAll(){
        return productService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetProductResponse> getById(@RequestParam("id") int id){
        return productService.getById(id);
    }
    @GetMapping("{id}")
    public DataResult<GetProductResponse> getByIdPath(@PathVariable int id){
        return productService.getById(id);
    }

    @GetMapping("/getByStockGreaterThan")
    public DataResult<List<ListProductResponse>> getAllByStock(@RequestParam("stock") int stock){
        return productService.getAllByUnitsInStockGreaterThan(stock);
    }

    @GetMapping("/getByName")
    public DataResult<GetProductResponse> getByName(@RequestParam("name") String name){
        return productService.getByProductName(name);
    }

    @PostMapping("/addProduct")
    public DataResult<GetProductResponse> add(@RequestBody CreateProductRequest createProductRequest){
        return productService.addProduct(createProductRequest);
    }
}
