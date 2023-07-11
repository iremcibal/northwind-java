package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.CategoryService;
import kodlama.io.northwind.business.businessRules.CategoryBusinessRules;
import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.business.dtos.request.category.CreateCategoryRequest;
import kodlama.io.northwind.business.dtos.request.category.UpdateCategoryRequest;
import kodlama.io.northwind.business.dtos.response.category.GetCategoryResponse;
import kodlama.io.northwind.business.dtos.response.category.ListCategoryResponse;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.results.SuccessResult;
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
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapperService modelMapperService;
    @Autowired
    private CategoryBusinessRules rules;
    private MessageService messageService;

    @Override
    public DataResult<List<ListCategoryResponse>> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<ListCategoryResponse> responses = categories.stream()
                .map(category -> modelMapperService.forResponse().map(category,ListCategoryResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responses,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public DataResult<GetCategoryResponse> getById(int id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        GetCategoryResponse response = modelMapperService.forResponse().map(category,GetCategoryResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public DataResult<GetCategoryResponse> addCategory(CreateCategoryRequest createCategoryRequest) {
        Category category = modelMapperService.forRequest().map(createCategoryRequest,Category.class);
        rules.CategoryExistsWithSameName(createCategoryRequest.getCategoryName());
        Category savedCategory = categoryRepository.save(category);
        GetCategoryResponse response = modelMapperService.forResponse().map(savedCategory,GetCategoryResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataAdded));
    }

    @Override
    public DataResult<GetCategoryResponse> update(UpdateCategoryRequest request, int id) {
        rules.CategoryNotExistsWithSameId(id);
        Category category = modelMapperService.forRequest().map(request,Category.class);
        category.setCategoryId(id);
        categoryRepository.save(category);
        GetCategoryResponse response = modelMapperService.forResponse().map(category,GetCategoryResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataUpdated));
    }

    @Override
    public Result delete(int id) {
        rules.CategoryNotExistsWithSameId(id);
        categoryRepository.deleteById(id);

        return new SuccessResult(messageService.getMessage(Messages.Data.dataDeleted));
    }
}
