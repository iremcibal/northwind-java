package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.DemographicService;
import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.business.dtos.request.demographic.CreateDemographicRequest;
import kodlama.io.northwind.business.dtos.response.demographic.GetDemographicResponse;
import kodlama.io.northwind.business.dtos.response.demographic.ListDemographicResponse;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.DemographicRepository;
import kodlama.io.northwind.entities.concretes.Demographic;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DemographicManager implements DemographicService {
    private DemographicRepository demographicRepository;
    private ModelMapperService modelMapperService;
    private MessageService messageService;


    @Override
    public DataResult<List<ListDemographicResponse>> getAll() {
        List<Demographic> demographics = demographicRepository.findAll();
        List<ListDemographicResponse> responses = demographics.stream()
                .map(demographic -> modelMapperService.forResponse().map(demographic,ListDemographicResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responses,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public DataResult<GetDemographicResponse> addDemographic(CreateDemographicRequest createDemographicRequest) {
        Demographic demographic = modelMapperService.forRequest().map(createDemographicRequest,Demographic.class);
        Demographic savedDemographic = demographicRepository.save(demographic);
        GetDemographicResponse response = modelMapperService.forResponse().map(savedDemographic,GetDemographicResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataAdded));
    }
}
