package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.demographic.CreateDemographicRequest;
import kodlama.io.northwind.business.dtos.response.demographic.GetDemographicResponse;
import kodlama.io.northwind.business.dtos.response.demographic.ListDemographicResponse;

import java.util.List;

public interface DemographicService {
    List<ListDemographicResponse> getAll();
    GetDemographicResponse addDemographic(CreateDemographicRequest createDemographicRequest);
}
