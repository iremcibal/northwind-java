package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.OrderService;
import kodlama.io.northwind.business.dtos.request.employee.CreateEmployeeRequest;
import kodlama.io.northwind.business.dtos.request.order.CreateOrderRequest;
import kodlama.io.northwind.business.dtos.response.employee.GetEmployeeResponse;
import kodlama.io.northwind.business.dtos.response.employee.ListEmployeeResponse;
import kodlama.io.northwind.business.dtos.response.order.GetOrderResponse;
import kodlama.io.northwind.business.dtos.response.order.ListOrderResponse;
import kodlama.io.northwind.core.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;

    @GetMapping("/getAll")
    public DataResult<List<ListOrderResponse>> getAll(){
        return orderService.getAll();
    }

    @PostMapping("/addOrder")
    public DataResult<GetOrderResponse> add(@RequestBody CreateOrderRequest createOrderRequest){
        return orderService.addOrder(createOrderRequest);
    }
}
