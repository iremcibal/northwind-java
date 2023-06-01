package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.invoice.CreateInvoiceRequest;
import kodlama.io.northwind.business.dtos.request.orderDetail.CreateOrderDetailRequest;
import kodlama.io.northwind.business.dtos.response.order.GetOrderResponse;
import kodlama.io.northwind.business.dtos.response.orderDetail.GetOrderDetailResponse;
import kodlama.io.northwind.business.dtos.response.orderDetail.ListOrderDetailResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;
import kodlama.io.northwind.entities.concretes.Order;
import kodlama.io.northwind.entities.concretes.OrderDetail;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderDetailService {
    //DataResult<List<ListOrderDetailResponse>> getAll();
    //DataResult<GetOrderDetailResponse> addOrderDetailRes(CreateOrderDetailRequest createOrderDetailRequest);
    //DataResult<OrderDetail> addOrderDetail(OrderDetail orderDetail);
    //DataResult<List<ListOrderDetailResponse>> getByOrderId(int orderId);
    //DataResult<GetOrderDetailResponse> getById(int id);

    Result addRange(int orderId, List<CreateOrderDetailRequest> createOrderDetailRequest);
}
