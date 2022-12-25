package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.demographic.CreateDemographicRequest;
import kodlama.io.northwind.business.dtos.request.status.CreateStatusRequest;
import kodlama.io.northwind.business.dtos.response.demographic.GetDemographicResponse;
import kodlama.io.northwind.business.dtos.response.demographic.ListDemographicResponse;
import kodlama.io.northwind.business.dtos.response.status.GetStatusResponse;
import kodlama.io.northwind.business.dtos.response.status.ListStatusResponse;
import kodlama.io.northwind.core.results.DataResult;

import java.util.List;

public interface StatusService {
    DataResult<List<ListStatusResponse>> getAll();
    DataResult<GetStatusResponse> addStatus(CreateStatusRequest createStatusRequest);
}
