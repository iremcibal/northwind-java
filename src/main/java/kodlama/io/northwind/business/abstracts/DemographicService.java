package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.demographic.CreateDemographicRequest;
import kodlama.io.northwind.business.dtos.response.demographic.GetDemographicResponse;
import kodlama.io.northwind.business.dtos.response.demographic.ListDemographicResponse;
import kodlama.io.northwind.core.results.DataResult;

import java.util.List;

public interface DemographicService {
    DataResult<List<ListDemographicResponse>> getAll();
    DataResult<GetDemographicResponse> addDemographic(CreateDemographicRequest createDemographicRequest);
}
