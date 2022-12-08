package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.order.CreateOrderRequest;
import kodlama.io.northwind.business.dtos.response.order.GetOrderResponse;
import kodlama.io.northwind.business.dtos.response.order.ListOrderResponse;

import java.util.List;

public interface OrderService {
    List<ListOrderResponse> getAll();
    GetOrderResponse addOrder(CreateOrderRequest createOrderRequest);
}
