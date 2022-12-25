package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.BasketItemService;
import kodlama.io.northwind.business.abstracts.BasketService;
import kodlama.io.northwind.business.dtos.request.basket.CreateBasketRequest;
import kodlama.io.northwind.business.dtos.request.basketItem.CreateBasketItemRequest;
import kodlama.io.northwind.business.dtos.response.basket.GetBasketResponse;
import kodlama.io.northwind.business.dtos.response.basket.ListBasketResponse;
import kodlama.io.northwind.business.dtos.response.basketItem.GetBasketItemResponse;
import kodlama.io.northwind.business.dtos.response.basketItem.ListBasketItemResponse;
import kodlama.io.northwind.core.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/basketItem")
@AllArgsConstructor
public class BasketItemController {
    private BasketItemService service;

    @GetMapping("/getAll")
    public DataResult<List<ListBasketItemResponse>> getAll(){
        return service.getAll();
    }

    @PostMapping("/addBasketItem")
    public DataResult<GetBasketItemResponse> add(@RequestBody CreateBasketItemRequest createBasketItemRequest){
        return service.addBasketItem(createBasketItemRequest);
    }
}
