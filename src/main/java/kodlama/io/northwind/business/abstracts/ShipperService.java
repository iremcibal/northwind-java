package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.shipper.CreateShipperRequest;
import kodlama.io.northwind.business.dtos.response.shipper.GetShipperResponse;
import kodlama.io.northwind.business.dtos.response.shipper.ListShipperResponse;

import java.util.List;

public interface ShipperService {
    List<ListShipperResponse> getAll();
    GetShipperResponse addShipper(CreateShipperRequest createShipperRequest);
}
