package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.OrderDetailService;
import kodlama.io.northwind.business.dtos.request.orderDetail.CreateOrderDetailRequest;
import kodlama.io.northwind.business.dtos.response.orderDetail.GetOrderDetailResponse;
import kodlama.io.northwind.business.dtos.response.orderDetail.ListOrderDetailResponse;
import kodlama.io.northwind.entities.dtos.OrderDetailDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderDetail")
@AllArgsConstructor
public class OrderDetailController {
    private OrderDetailService service;

    @GetMapping("/getAll")
    public List<ListOrderDetailResponse> getAll(){
        return service.getAll();
    }

    @PostMapping("/addOrderDetail")
    public GetOrderDetailResponse add(@RequestBody CreateOrderDetailRequest createOrderDetailRequest){
        return service.addOrderDetail(createOrderDetailRequest);
    }

    @GetMapping("/getDTOByOrderId")
    public List<OrderDetailDto> getByOrderId(@RequestParam("orderId")int orderId) {
        return service.getByOrderId(orderId);
    }
}
