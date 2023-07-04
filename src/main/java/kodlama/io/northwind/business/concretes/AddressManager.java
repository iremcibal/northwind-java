package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.AddressService;
import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.business.dtos.request.address.CreateAddressRequest;
import kodlama.io.northwind.business.dtos.response.address.GetAddressResponse;
import kodlama.io.northwind.business.dtos.response.address.ListAddressResponse;
import kodlama.io.northwind.business.dtos.response.region.ListRegionResponse;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.AddressRepository;
import kodlama.io.northwind.entities.concretes.Address;
import kodlama.io.northwind.entities.concretes.Category;
import kodlama.io.northwind.entities.concretes.Region;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {
    private AddressRepository addressRepository;
    private ModelMapperService modelMapperService;
    private MessageService messageService;
    @Override
    public DataResult<List<ListAddressResponse>> getAll() {
        List<Address> addresses = addressRepository.findAll();
        List<ListAddressResponse> responses = addresses.stream()
                .map(address -> modelMapperService.forResponse().map(address,ListAddressResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responses,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public DataResult<Slice<ListAddressResponse>> getAllWithPagination(Pageable pageable) {
        return new SuccessDataResult<>(addressRepository.findAllPageable(pageable));
    }

    @Override
    public DataResult<GetAddressResponse> getById(int id) {
        Address address = addressRepository.findById(id).orElseThrow();
        GetAddressResponse response = modelMapperService.forResponse().map(address,GetAddressResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public DataResult<GetAddressResponse> addAddress(CreateAddressRequest createAddressRequest) {
        Address address = modelMapperService.forRequest().map(createAddressRequest,Address.class);
        Address savedAddress = addressRepository.save(address);
        GetAddressResponse response = modelMapperService.forResponse().map(savedAddress,GetAddressResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataAdded));
    }
}
