package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.CustomerDemographicService;
import kodlama.io.northwind.business.dtos.request.customerDemographic.CreateCustDemoRequest;
import kodlama.io.northwind.business.dtos.response.customerDemographic.GetCustDemoResponse;
import kodlama.io.northwind.business.dtos.response.customerDemographic.ListCustDemoResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.CustomerDemographicRepository;
import kodlama.io.northwind.entities.concretes.CustomerDemographic;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerDemographicManager implements CustomerDemographicService {
    private CustomerDemographicRepository customerDemographicRepository;
    private ModelMapperService modelMapperService;


    @Override
    public DataResult<List<ListCustDemoResponse>> getAll() {
        List<CustomerDemographic> customerDemographics = customerDemographicRepository.findAll();
        List<ListCustDemoResponse> responses = customerDemographics.stream()
                .map(customerDemographic -> modelMapperService.forResponse().map(customerDemographic,ListCustDemoResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responses,"data listed");
    }

    @Override
    public DataResult<GetCustDemoResponse> addCustDemo(CreateCustDemoRequest createCustDemoRequest) {
        CustomerDemographic customerDemographic = modelMapperService.forRequest().map(createCustDemoRequest,CustomerDemographic.class);
        CustomerDemographic savedCustDemo = customerDemographicRepository.save(customerDemographic);
        GetCustDemoResponse response = modelMapperService.forResponse().map(savedCustDemo,GetCustDemoResponse.class);

        return new SuccessDataResult<>(response,"data added");
    }
}
