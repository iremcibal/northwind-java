package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.BasketService;
import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.business.dtos.request.basket.CreateBasketRequest;
import kodlama.io.northwind.business.dtos.response.basket.GetBasketResponse;
import kodlama.io.northwind.business.dtos.response.basket.ListBasketResponse;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.BasketRepository;
import kodlama.io.northwind.entities.concretes.Basket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BasketManager implements BasketService {
    private BasketRepository repository;
    private ModelMapperService service;
    private MessageService messageService;

    @Override
    public DataResult<List<ListBasketResponse>> getAll() {
        List<Basket> baskets = repository.findAll();
        List<ListBasketResponse> responses = baskets.stream()
                .map(basket -> service.forResponse().map(basket,ListBasketResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responses,messageService.getMessage(Messages.Data.dataListed));

    }

    @Override
    public DataResult<GetBasketResponse> addBasket(CreateBasketRequest createBasketRequest) {
        Basket basket = service.forRequest().map(createBasketRequest,Basket.class);
        Basket savedBasket = repository.save(basket);
        GetBasketResponse response = service.forResponse().map(savedBasket,GetBasketResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataAdded));
    }

    @Override
    public DataResult<Basket> getByCustomerCustomerId(String customerId) {
        Basket basket = repository.getByCustomer_customerId(customerId);
        return new SuccessDataResult<>(basket,messageService.getMessage(Messages.Data.dataListed));
    }
}
