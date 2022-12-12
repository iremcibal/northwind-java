package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.shipper.CreateShipperRequest;
import kodlama.io.northwind.business.dtos.response.shipper.GetShipperResponse;
import kodlama.io.northwind.business.dtos.response.shipper.ListShipperResponse;
import kodlama.io.northwind.core.results.DataResult;

import javax.xml.crypto.Data;
import java.util.List;

public interface ShipperService {
    DataResult<List<ListShipperResponse>> getAll();
    DataResult<GetShipperResponse> addShipper(CreateShipperRequest createShipperRequest);
}
