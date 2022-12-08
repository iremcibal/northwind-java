package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.CategoryService;
import kodlama.io.northwind.business.dtos.request.category.CreateCategoryRequest;
import kodlama.io.northwind.business.dtos.response.category.GetCategoryResponse;
import kodlama.io.northwind.business.dtos.response.category.ListCategoryResponse;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.CategoryRepository;
import kodlama.io.northwind.entities.concretes.Category;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<ListCategoryResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<ListCategoryResponse> responses = categories.stream()
                .map(category -> modelMapperService.forResponse().map(category,ListCategoryResponse.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public GetCategoryResponse getById(int id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        GetCategoryResponse response = modelMapperService.forResponse().map(category,GetCategoryResponse.class);

        return response;
    }

    @Override
    public GetCategoryResponse addCategory(CreateCategoryRequest createCategoryRequest) {
        Category category = modelMapperService.forRequest().map(createCategoryRequest,Category.class);
        Category savedCategory = categoryRepository.save(category);
        GetCategoryResponse response = modelMapperService.forResponse().map(savedCategory,GetCategoryResponse.class);

        return response;
    }
}
