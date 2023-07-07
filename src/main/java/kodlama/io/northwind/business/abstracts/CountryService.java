package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.address.CreateAddressRequest;
import kodlama.io.northwind.business.dtos.request.city.UpdateCityRequest;
import kodlama.io.northwind.business.dtos.request.country.CreateCountryRequest;
import kodlama.io.northwind.business.dtos.request.country.UpdateCountryRequest;
import kodlama.io.northwind.business.dtos.response.address.GetAddressResponse;
import kodlama.io.northwind.business.dtos.response.address.ListAddressResponse;
import kodlama.io.northwind.business.dtos.response.city.GetCityResponse;
import kodlama.io.northwind.business.dtos.response.country.GetCountryResponse;
import kodlama.io.northwind.business.dtos.response.country.ListCountryResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;

import java.util.List;

public interface CountryService {
    DataResult<List<ListCountryResponse>> getAll();
    DataResult<GetCountryResponse> getById(int id);
    DataResult<GetCountryResponse> addCountry(CreateCountryRequest createCountryRequest);
    DataResult<GetCountryResponse> update(UpdateCountryRequest request, int id);
    Result delete(int id);

}
