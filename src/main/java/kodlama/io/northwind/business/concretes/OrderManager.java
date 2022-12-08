package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.OrderService;
import kodlama.io.northwind.business.dtos.request.order.CreateOrderRequest;
import kodlama.io.northwind.business.dtos.response.order.GetOrderResponse;
import kodlama.io.northwind.business.dtos.response.order.ListOrderResponse;
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
    public List<ListOrderResponse> getAll() {
        List<Order> orders = orderRepository.findAll();
        List<ListOrderResponse> responses = orders.stream()
                .map(order -> modelMapperService.forResponse().map(order,ListOrderResponse.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public GetOrderResponse addOrder(CreateOrderRequest createOrderRequest) {
        Order order =modelMapperService.forRequest().map(createOrderRequest,Order.class);
        Order savedOrder = orderRepository.save(order);
        GetOrderResponse response = modelMapperService.forResponse().map(savedOrder,GetOrderResponse.class);

        return response;
    }
}
