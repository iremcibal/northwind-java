package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.business.dtos.request.product.CreateProductRequest;
import kodlama.io.northwind.business.dtos.response.product.GetProductResponse;
import kodlama.io.northwind.business.dtos.response.product.ListProductResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsController {

    @Autowired
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
    public DataResult<GetProductResponse> add(@Valid @RequestBody CreateProductRequest createProductRequest){
        return productService.addProduct(createProductRequest);
    }

    @GetMapping("/getWithPagination")
    // RequestParam => page,pageSize
    public Page<Product> getWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return productService.findAllWithPagination(pageable);
    }

    @GetMapping("/getWithSlice")
    // RequestParam => page,pageSize
    public Slice<Product> getWithSlice(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return productService.findAllWithSlice(pageable);
    }

    @GetMapping("/getWithPaginationDto")
    // RequestParam => page,pageSize
    public Page<ListProductResponse>
    getWithPaginationDto(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return productService.findAllWithPaginationDto(pageable);
    }
}
