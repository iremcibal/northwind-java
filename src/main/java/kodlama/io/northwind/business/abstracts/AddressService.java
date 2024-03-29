package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.address.CreateAddressRequest;
import kodlama.io.northwind.business.dtos.request.address.UpdateAddressRequest;
import kodlama.io.northwind.business.dtos.request.category.CreateCategoryRequest;
import kodlama.io.northwind.business.dtos.response.address.GetAddressResponse;
import kodlama.io.northwind.business.dtos.response.address.ListAddressResponse;
import kodlama.io.northwind.business.dtos.response.category.GetCategoryResponse;
import kodlama.io.northwind.business.dtos.response.category.ListCategoryResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface AddressService {
    DataResult<List<ListAddressResponse>> getAll();
    DataResult<Slice<ListAddressResponse>> getAllWithPagination(Pageable pageable);
    DataResult<GetAddressResponse> getById(int id);
    DataResult<GetAddressResponse> addAddress(CreateAddressRequest createAddressRequest);
    DataResult<GetAddressResponse> update(UpdateAddressRequest request, int id);
    Result delete(int id);
}
