package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.address.UpdateAddressRequest;
import kodlama.io.northwind.business.dtos.request.category.CreateCategoryRequest;
import kodlama.io.northwind.business.dtos.request.category.UpdateCategoryRequest;
import kodlama.io.northwind.business.dtos.response.address.GetAddressResponse;
import kodlama.io.northwind.business.dtos.response.category.GetCategoryResponse;
import kodlama.io.northwind.business.dtos.response.category.ListCategoryResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;


import java.util.List;

public interface CategoryService {
    DataResult<List<ListCategoryResponse>> getAll();
    DataResult<GetCategoryResponse> getById(int id);
    DataResult<GetCategoryResponse> addCategory(CreateCategoryRequest createCategoryRequest);
    DataResult<GetCategoryResponse> update(UpdateCategoryRequest request, int id);
    Result delete(int id);
}
