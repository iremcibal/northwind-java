package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.order.CreateOrderRequest;
import kodlama.io.northwind.business.dtos.response.order.GetOrderResponse;
import kodlama.io.northwind.business.dtos.response.order.ListOrderResponse;
import kodlama.io.northwind.core.results.DataResult;

import java.util.List;

public interface OrderService {
    DataResult<List<ListOrderResponse>> getAll();
    DataResult<GetOrderResponse> addOrder(CreateOrderRequest createOrderRequest);
}
