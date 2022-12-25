package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.basket.CreateBasketRequest;
import kodlama.io.northwind.business.dtos.request.category.CreateCategoryRequest;
import kodlama.io.northwind.business.dtos.response.basket.GetBasketResponse;
import kodlama.io.northwind.business.dtos.response.basket.ListBasketResponse;
import kodlama.io.northwind.business.dtos.response.category.GetCategoryResponse;
import kodlama.io.northwind.business.dtos.response.category.ListCategoryResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.entities.concretes.Basket;

import java.util.List;

public interface BasketService {
    DataResult<List<ListBasketResponse>> getAll();
    //DataResult<GetCategoryResponse> getById(int id);
    DataResult<GetBasketResponse> addBasket(CreateBasketRequest createBasketRequest);
    DataResult<Basket> getByCustomerCustomerId(String customerId);
}
