package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.region.CreateRegionRequest;
import kodlama.io.northwind.business.dtos.response.region.GetRegionResponse;
import kodlama.io.northwind.business.dtos.response.region.ListRegionResponse;
import kodlama.io.northwind.core.results.DataResult;

import java.util.List;

public interface RegionService {
    DataResult<List<ListRegionResponse>> getAll();
    DataResult<GetRegionResponse> addRegion(CreateRegionRequest createRegionRequest);
}
