package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.orderDetail.CreateOrderDetailRequest;
import kodlama.io.northwind.business.dtos.response.orderDetail.GetOrderDetailResponse;
import kodlama.io.northwind.business.dtos.response.orderDetail.ListOrderDetailResponse;

import java.util.List;

public interface OrderDetailService {
    List<ListOrderDetailResponse> getAll();
    GetOrderDetailResponse addOrderDetail(CreateOrderDetailRequest createOrderDetailRequest);
}
