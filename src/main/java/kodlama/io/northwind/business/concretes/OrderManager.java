package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.OrderService;
import kodlama.io.northwind.business.dtos.request.order.CreateOrderRequest;
import kodlama.io.northwind.business.dtos.response.order.GetOrderResponse;
import kodlama.io.northwind.business.dtos.response.order.ListOrderResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.OrderRepository;
import kodlama.io.northwind.entities.concretes.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {
    private OrderRepository orderRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<ListOrderResponse>> getAll() {
        List<Order> orders = orderRepository.findAll();
        List<ListOrderResponse> responses = orders.stream()
                .map(order -> modelMapperService.forResponse().map(order,ListOrderResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responses,"data listed");
    }

    @Override
    public DataResult<GetOrderResponse> addOrder(CreateOrderRequest createOrderRequest) {
        Order order =modelMapperService.forRequest().map(createOrderRequest,Order.class);
        Order savedOrder = orderRepository.save(order);
        GetOrderResponse response = modelMapperService.forResponse().map(savedOrder,GetOrderResponse.class);

        return new SuccessDataResult<>(response,"data added");
    }
}
