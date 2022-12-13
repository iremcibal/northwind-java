package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.orderDetail.CreateOrderDetailRequest;
import kodlama.io.northwind.business.dtos.response.orderDetail.GetOrderDetailResponse;
import kodlama.io.northwind.business.dtos.response.orderDetail.ListOrderDetailResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.entities.dtos.OrderDetailDto;

import java.util.List;

public interface OrderDetailService {
    DataResult<List<ListOrderDetailResponse>> getAll();
    DataResult<GetOrderDetailResponse> addOrderDetail(CreateOrderDetailRequest createOrderDetailRequest);
    DataResult<List<ListOrderDetailResponse>> getByOrderId(int orderId);
}
