package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.RegionService;
import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.business.dtos.request.region.CreateRegionRequest;
import kodlama.io.northwind.business.dtos.response.region.GetRegionResponse;
import kodlama.io.northwind.business.dtos.response.region.ListRegionResponse;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.RegionRepository;
import kodlama.io.northwind.entities.concretes.Region;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RegionManager implements RegionService {
    private RegionRepository repository;
    private ModelMapperService modelMapperService;
    private MessageService messageService;


    @Override
    public DataResult<List<ListRegionResponse>> getAll() {
        List<Region> regions = repository.findAll();
        List<ListRegionResponse> responses = regions.stream()
                .map(region -> modelMapperService.forResponse().map(region,ListRegionResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responses,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public DataResult<GetRegionResponse> addRegion(CreateRegionRequest createRegionRequest) {
        Region region = modelMapperService.forRequest().map(createRegionRequest,Region.class);
        Region savedRegion = repository.save(region);
        GetRegionResponse response = modelMapperService.forResponse().map(savedRegion,GetRegionResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataAdded));
    }
}
