package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.*;
import kodlama.io.northwind.business.dtos.request.invoice.CreateInvoiceRequest;
import kodlama.io.northwind.business.dtos.request.order.CreateOrderRequest;
import kodlama.io.northwind.business.dtos.request.orderDetail.CreateOrderDetailRequest;
import kodlama.io.northwind.business.dtos.response.customer.GetCustomerResponse;
import kodlama.io.northwind.business.dtos.response.invoice.GetInvoiceResponse;
import kodlama.io.northwind.business.dtos.response.order.GetOrderResponse;
import kodlama.io.northwind.business.dtos.response.order.ListOrderResponse;
import kodlama.io.northwind.business.dtos.response.orderDetail.GetOrderDetailResponse;
import kodlama.io.northwind.business.dtos.response.product.GetProductResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.results.SuccessResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.OrderRepository;
import kodlama.io.northwind.entities.concretes.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {
    private OrderRepository orderRepository;
    private ModelMapperService modelMapperService;
    private OrderDetailService orderDetailService;
    private InvoiceService invoiceService;
    private ProductService productService;


    @Override
    public DataResult<List<ListOrderResponse>> getAll() {
        List<Order> orders = orderRepository.findAll();
        List<ListOrderResponse> responses = orders.stream()
                .map(order -> modelMapperService.forResponse().map(order,ListOrderResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responses,"data listed");
    }

    @Override
    @Transactional
    public Result addOrder(CreateOrderRequest createOrderRequest) {
        Order order = new Order();
        order = modelMapperService.forRequest().map(createOrderRequest,Order.class);
        orderRepository.save(order);
        orderDetailService.addRange(order.getOrderId() , createOrderRequest.getOrderDetails());

        return new SuccessResult("data added");
    }

    public double totalPrice(Product product, CreateOrderDetailRequest request) {
        double total = product.getUnitPrice() * request.getQuantity();
        return total;
    }
}
