package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.BasketService;
import kodlama.io.northwind.business.dtos.request.basket.CreateBasketRequest;
import kodlama.io.northwind.business.dtos.request.category.CreateCategoryRequest;
import kodlama.io.northwind.business.dtos.response.basket.GetBasketResponse;
import kodlama.io.northwind.business.dtos.response.basket.ListBasketResponse;
import kodlama.io.northwind.business.dtos.response.category.GetCategoryResponse;
import kodlama.io.northwind.business.dtos.response.category.ListCategoryResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.entities.concretes.Basket;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/baskets")
@AllArgsConstructor
public class BasketController {
    private BasketService service;

    @GetMapping("/getAll")
    public DataResult<List<ListBasketResponse>> getAll(){
        return service.getAll();
    }

    @GetMapping("/getByCustomerId")
    public DataResult<Basket> getById(@RequestParam("id") String id){
        return service.getByCustomerCustomerId(id);
    }

    @PostMapping("/addBasket")
    public DataResult<GetBasketResponse> add(@RequestBody CreateBasketRequest createBasketRequest){
        return service.addBasket(createBasketRequest);
    }
}
