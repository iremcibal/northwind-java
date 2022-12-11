package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.TerritoryService;
import kodlama.io.northwind.business.dtos.request.territory.CreateTerritoryRequest;
import kodlama.io.northwind.business.dtos.response.territory.GetTerritoryResponse;
import kodlama.io.northwind.business.dtos.response.territory.ListTerritoryResponse;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.TerritoryRepository;
import kodlama.io.northwind.entities.concretes.Territory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TerritoryManager implements TerritoryService {
    private TerritoryRepository repository;
    private ModelMapperService modelMapperService;


    @Override
    public List<ListTerritoryResponse> getAll() {
        List<Territory> territories = repository.findAll();
        List<ListTerritoryResponse> responses = territories.stream()
                .map(territory -> modelMapperService.forResponse().map(territory,ListTerritoryResponse.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public GetTerritoryResponse addTerritory(CreateTerritoryRequest createTerritoryRequest) {
        Territory territory = modelMapperService.forRequest().map(createTerritoryRequest,Territory.class);
        Territory savedTerritory = repository.save(territory);
        GetTerritoryResponse response = modelMapperService.forResponse().map(savedTerritory,GetTerritoryResponse.class);

        return response;
    }
}
