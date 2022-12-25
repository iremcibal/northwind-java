package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.CategoryService;
import kodlama.io.northwind.business.dtos.request.category.CreateCategoryRequest;
import kodlama.io.northwind.business.dtos.response.category.GetCategoryResponse;
import kodlama.io.northwind.business.dtos.response.category.ListCategoryResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.entities.concretes.Category;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoriesController {
    private CategoryService categoryService;

    @GetMapping("/getAll")
    public DataResult<List<ListCategoryResponse>> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetCategoryResponse> getById(@RequestParam("id") int id){
        return categoryService.getById(id);
    }

    @PostMapping("/addCategory")
    public DataResult<GetCategoryResponse> add(@RequestBody CreateCategoryRequest createCategoryRequest){
        return categoryService.addCategory(createCategoryRequest);
    }
}
