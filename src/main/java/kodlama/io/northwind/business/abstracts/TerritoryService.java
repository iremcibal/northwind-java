package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.territory.CreateTerritoryRequest;
import kodlama.io.northwind.business.dtos.response.territory.GetTerritoryResponse;
import kodlama.io.northwind.business.dtos.response.territory.ListTerritoryResponse;

import java.util.List;

public interface TerritoryService {
    List<ListTerritoryResponse> getAll();
    GetTerritoryResponse addTerritory(CreateTerritoryRequest createTerritoryRequest);
}
