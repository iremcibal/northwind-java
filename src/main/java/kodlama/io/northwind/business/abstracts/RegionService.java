package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.city.UpdateCityRequest;
import kodlama.io.northwind.business.dtos.request.region.CreateRegionRequest;
import kodlama.io.northwind.business.dtos.request.region.UpdateRegionRequest;
import kodlama.io.northwind.business.dtos.response.city.GetCityResponse;
import kodlama.io.northwind.business.dtos.response.region.GetRegionResponse;
import kodlama.io.northwind.business.dtos.response.region.ListRegionResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;

import java.util.List;

public interface RegionService {
    DataResult<List<ListRegionResponse>> getAll();
    DataResult<GetRegionResponse> addRegion(CreateRegionRequest createRegionRequest);
    DataResult<GetRegionResponse> update(UpdateRegionRequest request, int id);
    Result delete(int id);
}
