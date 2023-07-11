package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.CityService;
import kodlama.io.northwind.business.businessRules.CityBusinessRules;
import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.business.dtos.request.city.CreateCityRequest;
import kodlama.io.northwind.business.dtos.request.city.UpdateCityRequest;
import kodlama.io.northwind.business.dtos.response.city.GetCityResponse;
import kodlama.io.northwind.business.dtos.response.city.ListCityResponse;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.results.SuccessResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.CityRepository;
import kodlama.io.northwind.entities.concretes.City;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityManager implements CityService {
    private CityRepository cityRepository;
    private ModelMapperService modelMapperService;
    private MessageService messageService;
    private CityBusinessRules cityBusinessRules;
    @Override
    public DataResult<List<ListCityResponse>> getAll() {
        List<City> cities = cityRepository.findAll();
        List<ListCityResponse> responses = cities.stream()
                .map(city -> modelMapperService.forResponse().map(city,ListCityResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responses,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public DataResult<GetCityResponse> getById(int id) {
        City city = cityRepository.findById(id).orElseThrow();
        GetCityResponse response = modelMapperService.forResponse().map(city,GetCityResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public DataResult<GetCityResponse> addCity(CreateCityRequest createCityRequest) {
        City city = modelMapperService.forRequest().map(createCityRequest,City.class);
        City savedCity = cityRepository.save(city);
        GetCityResponse response = modelMapperService.forResponse().map(savedCity,GetCityResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataAdded));
    }

    @Override
    public DataResult<GetCityResponse> update(UpdateCityRequest request, int id) {
        cityBusinessRules.checkIfCityNotExistById(id);
        City city = modelMapperService.forRequest().map(request,City.class);
        city.setCityId(id);
        cityRepository.save(city);
        GetCityResponse response = modelMapperService.forResponse().map(city,GetCityResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataUpdated));
    }

    @Override
    public Result delete(int id) {
        cityBusinessRules.checkIfCityNotExistById(id);
        cityRepository.deleteById(id);

        return new SuccessResult(messageService.getMessage(Messages.Data.dataDeleted));
    }
}
