package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.address.CreateAddressRequest;
import kodlama.io.northwind.business.dtos.request.city.CreateCityRequest;
import kodlama.io.northwind.business.dtos.response.address.GetAddressResponse;
import kodlama.io.northwind.business.dtos.response.address.ListAddressResponse;
import kodlama.io.northwind.business.dtos.response.city.GetCityResponse;
import kodlama.io.northwind.business.dtos.response.city.ListCityResponse;
import kodlama.io.northwind.core.results.DataResult;

import java.util.List;

public interface CityService {
    DataResult<List<ListCityResponse>> getAll();
    DataResult<GetCityResponse> getById(int id);
    DataResult<GetCityResponse> addCity(CreateCityRequest createCityRequest);
}
