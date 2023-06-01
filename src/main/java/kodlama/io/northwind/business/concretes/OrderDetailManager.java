package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.InvoiceService;
import kodlama.io.northwind.business.abstracts.OrderDetailService;
import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.business.dtos.request.invoice.CreateInvoiceRequest;
import kodlama.io.northwind.business.dtos.request.orderDetail.CreateOrderDetailRequest;
import kodlama.io.northwind.business.dtos.response.orderDetail.GetOrderDetailResponse;
import kodlama.io.northwind.business.dtos.response.orderDetail.ListOrderDetailResponse;
import kodlama.io.northwind.business.dtos.response.product.GetProductResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.results.SuccessResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.OrderDetailRepository;
import kodlama.io.northwind.entities.concretes.Invoice;
import kodlama.io.northwind.entities.concretes.Order;
import kodlama.io.northwind.entities.concretes.OrderDetail;
import kodlama.io.northwind.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderDetailManager implements OrderDetailService {
    private OrderDetailRepository repository;
    private ModelMapperService modelMapperService;
    private InvoiceService invoiceService;

    @Override
    public Result addRange(int orderId, List<CreateOrderDetailRequest> createOrderDetailRequest) {
        for (CreateOrderDetailRequest request: createOrderDetailRequest) {
            OrderDetail detail = modelMapperService.forRequest().map(request, OrderDetail.class);
            detail.getOrder().setOrderId(orderId);
            repository.save(detail);
            invoiceService.addRange(detail.getId(),request.getCreateInvoiceRequest());

        }

        return new SuccessResult();
    }

    /*@Override
    public DataResult<List<ListOrderDetailResponse>> getAll() {
        List<OrderDetail> orders = repository.findAll();
        List<ListOrderDetailResponse> responses = orders.stream()
                .map(orderDetail -> service.forResponse().map(orderDetail,ListOrderDetailResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responses,"data listed");
    }

    @Override
    public DataResult<GetOrderDetailResponse> addOrderDetailRes(CreateOrderDetailRequest createOrderDetailRequest) {
        OrderDetail detail = service.forRequest().map(createOrderDetailRequest,OrderDetail.class);
        OrderDetail savedDetail = repository.save(detail);
        GetOrderDetailResponse response = service.forResponse().map(savedDetail,GetOrderDetailResponse.class);

        return new SuccessDataResult<>(response,"data added");

    }

    @Override
    public DataResult<OrderDetail> addOrderDetail(OrderDetail order) {
        OrderDetail savedDetail = repository.save(order);
        return  new SuccessDataResult<>(savedDetail,"data added");
    }

    @Override
    public DataResult<List<ListOrderDetailResponse>> getByOrderId(int orderId) {
        List<ListOrderDetailResponse> dto = repository.findAllOrderById(orderId);
        return new SuccessDataResult<>(dto,"data listed");
    }

    @Override
    public DataResult<GetOrderDetailResponse> getById(int id) {
        Optional<OrderDetail> detail = repository.findById(id);
        GetOrderDetailResponse response = service.forResponse().map(detail,GetOrderDetailResponse.class);

        return new SuccessDataResult<>(response,"data listed");
    }*/


}
