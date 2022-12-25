package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.basketItem.CreateBasketItemRequest;
import kodlama.io.northwind.business.dtos.request.category.CreateCategoryRequest;
import kodlama.io.northwind.business.dtos.response.basketItem.GetBasketItemResponse;
import kodlama.io.northwind.business.dtos.response.basketItem.ListBasketItemResponse;
import kodlama.io.northwind.business.dtos.response.category.GetCategoryResponse;
import kodlama.io.northwind.business.dtos.response.category.ListCategoryResponse;
import kodlama.io.northwind.core.results.DataResult;

import java.util.List;

public interface BasketItemService {
    DataResult<List<ListBasketItemResponse>> getAll();
    //DataResult<GetBasketItemResponse> getById(int id);
    DataResult<GetBasketItemResponse> addBasketItem(CreateBasketItemRequest createBasketItemRequest);
}
