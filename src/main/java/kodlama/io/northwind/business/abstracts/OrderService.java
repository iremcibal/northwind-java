package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.order.CreateOrderRequest;
import kodlama.io.northwind.business.dtos.response.order.GetOrderResponse;
import kodlama.io.northwind.business.dtos.response.order.ListOrderResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;
import kodlama.io.northwind.entities.concretes.Order;

import java.util.List;

public interface OrderService {
    DataResult<List<ListOrderResponse>> getAll();
    Result addOrder(CreateOrderRequest createOrderRequest);
    Result delete(int id);
}
