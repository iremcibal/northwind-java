package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.CountryService;
import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.business.dtos.request.country.CreateCountryRequest;
import kodlama.io.northwind.business.dtos.response.city.GetCityResponse;
import kodlama.io.northwind.business.dtos.response.city.ListCityResponse;
import kodlama.io.northwind.business.dtos.response.country.GetCountryResponse;
import kodlama.io.northwind.business.dtos.response.country.ListCountryResponse;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.CountryRepository;
import kodlama.io.northwind.entities.concretes.City;
import kodlama.io.northwind.entities.concretes.Country;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CountryManager implements CountryService {
    private CountryRepository countryRepository;
    private ModelMapperService modelMapperService;
    private MessageService messageService;

    @Override
    public DataResult<List<ListCountryResponse>> getAll() {
        List<Country> countries = countryRepository.findAll();
        List<ListCountryResponse> responses = countries.stream()
                .map(country -> modelMapperService.forResponse().map(country,ListCountryResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responses,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public DataResult<GetCountryResponse> getById(int id) {
        Country country = countryRepository.findById(id).orElseThrow();
        GetCountryResponse response = modelMapperService.forResponse().map(country,GetCountryResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public DataResult<GetCountryResponse> addCountry(CreateCountryRequest createCountryRequest) {
        Country country = modelMapperService.forRequest().map(createCountryRequest,Country.class);
        Country savedCountry = countryRepository.save(country);
        GetCountryResponse response = modelMapperService.forResponse().map(savedCountry,GetCountryResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataAdded));
    }
}
