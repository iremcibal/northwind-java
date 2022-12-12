package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.territory.CreateTerritoryRequest;
import kodlama.io.northwind.business.dtos.response.territory.GetTerritoryResponse;
import kodlama.io.northwind.business.dtos.response.territory.ListTerritoryResponse;
import kodlama.io.northwind.core.results.DataResult;

import java.util.List;

public interface TerritoryService {
    DataResult<List<ListTerritoryResponse>> getAll();
    DataResult<GetTerritoryResponse> addTerritory(CreateTerritoryRequest createTerritoryRequest);
}
