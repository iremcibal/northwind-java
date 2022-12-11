package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.region.CreateRegionRequest;
import kodlama.io.northwind.business.dtos.response.region.GetRegionResponse;
import kodlama.io.northwind.business.dtos.response.region.ListRegionResponse;

import java.util.List;

public interface RegionService {
    List<ListRegionResponse> getAll();
    GetRegionResponse addRegion(CreateRegionRequest createRegionRequest);
}
