package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.ShipperService;
import kodlama.io.northwind.business.dtos.request.order.CreateOrderRequest;
import kodlama.io.northwind.business.dtos.request.shipper.CreateShipperRequest;
import kodlama.io.northwind.business.dtos.response.order.GetOrderResponse;
import kodlama.io.northwind.business.dtos.response.order.ListOrderResponse;
import kodlama.io.northwind.business.dtos.response.shipper.GetShipperResponse;
import kodlama.io.northwind.business.dtos.response.shipper.ListShipperResponse;
import kodlama.io.northwind.core.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shippers")
@AllArgsConstructor
public class ShipperController {
    private ShipperService shipperService;

    @GetMapping("/getAll")
    public DataResult<List<ListShipperResponse>> getAll(){
        return shipperService.getAll();
    }

    @PostMapping("/addShipper")
    public DataResult<GetShipperResponse> add(@RequestBody CreateShipperRequest createShipperRequest){
        return shipperService.addShipper(createShipperRequest);
    }
}
