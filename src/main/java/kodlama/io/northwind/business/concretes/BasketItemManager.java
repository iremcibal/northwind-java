package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.BasketItemService;
import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.business.dtos.request.basketItem.CreateBasketItemRequest;
import kodlama.io.northwind.business.dtos.response.basketItem.GetBasketItemResponse;
import kodlama.io.northwind.business.dtos.response.basketItem.ListBasketItemResponse;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.BasketItemRepository;
import kodlama.io.northwind.entities.concretes.BasketItem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BasketItemManager implements BasketItemService {
    private BasketItemRepository repository;
    private ModelMapperService service;
    private MessageService messageService;

    @Override
    public DataResult<List<ListBasketItemResponse>> getAll() {
        List<BasketItem> basketItems = repository.findAll();
        List<ListBasketItemResponse> responses = basketItems.stream()
                .map(basketItem -> service.forResponse().map(basketItem,ListBasketItemResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responses,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public DataResult<GetBasketItemResponse> addBasketItem(CreateBasketItemRequest createBasketItemRequest) {
        BasketItem basketItem = service.forRequest().map(createBasketItemRequest,BasketItem.class);
        BasketItem savedBasketItem = repository.save(basketItem);
        GetBasketItemResponse response = service.forResponse().map(savedBasketItem,GetBasketItemResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataAdded));
    }
}
