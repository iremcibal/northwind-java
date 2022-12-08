package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.category.CreateCategoryRequest;
import kodlama.io.northwind.business.dtos.response.category.GetCategoryResponse;
import kodlama.io.northwind.business.dtos.response.category.ListCategoryResponse;


import java.util.List;

public interface CategoryService {
    List<ListCategoryResponse> getAll();
    GetCategoryResponse getById(int id);
    GetCategoryResponse addCategory(CreateCategoryRequest createCategoryRequest);
}
