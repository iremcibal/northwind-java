package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.CityService;
import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.business.dtos.request.city.CreateCityRequest;
import kodlama.io.northwind.business.dtos.response.address.GetAddressResponse;
import kodlama.io.northwind.business.dtos.response.address.ListAddressResponse;
import kodlama.io.northwind.business.dtos.response.city.GetCityResponse;
import kodlama.io.northwind.business.dtos.response.city.ListCityResponse;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.CityRepository;
import kodlama.io.northwind.entities.concretes.Address;
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
}
