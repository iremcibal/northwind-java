package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.address.CreateAddressRequest;
import kodlama.io.northwind.business.dtos.request.country.CreateCountryRequest;
import kodlama.io.northwind.business.dtos.response.address.GetAddressResponse;
import kodlama.io.northwind.business.dtos.response.address.ListAddressResponse;
import kodlama.io.northwind.business.dtos.response.country.GetCountryResponse;
import kodlama.io.northwind.business.dtos.response.country.ListCountryResponse;
import kodlama.io.northwind.core.results.DataResult;

import java.util.List;

public interface CountryService {
    DataResult<List<ListCountryResponse>> getAll();
    DataResult<GetCountryResponse> getById(int id);
    DataResult<GetCountryResponse> addCountry(CreateCountryRequest createCountryRequest);
}
