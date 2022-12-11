package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.OrderDetailService;
import kodlama.io.northwind.business.dtos.request.orderDetail.CreateOrderDetailRequest;
import kodlama.io.northwind.business.dtos.response.orderDetail.GetOrderDetailResponse;
import kodlama.io.northwind.business.dtos.response.orderDetail.ListOrderDetailResponse;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.OrderDetailRepository;
import kodlama.io.northwind.entities.concretes.OrderDetail;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderDetailManager implements OrderDetailService {
    private OrderDetailRepository repository;
    private ModelMapperService service;

    @Override
    public List<ListOrderDetailResponse> getAll() {
        List<OrderDetail> orders = repository.findAll();
        List<ListOrderDetailResponse> responses = orders.stream()
                .map(orderDetail -> service.forResponse().map(orderDetail,ListOrderDetailResponse.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public GetOrderDetailResponse addOrderDetail(CreateOrderDetailRequest createOrderDetailRequest) {
        OrderDetail detail = service.forRequest().map(createOrderDetailRequest,OrderDetail.class);
        OrderDetail savedDetail = repository.save(detail);
        GetOrderDetailResponse response = service.forResponse().map(savedDetail,GetOrderDetailResponse.class);

        return response;

    }
}
