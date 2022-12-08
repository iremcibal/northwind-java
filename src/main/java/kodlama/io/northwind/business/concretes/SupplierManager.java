package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.SupplierService;
import kodlama.io.northwind.business.dtos.request.supplier.CreateSupplierRequest;
import kodlama.io.northwind.business.dtos.response.category.GetCategoryResponse;
import kodlama.io.northwind.business.dtos.response.supplier.GetSupplierResponse;
import kodlama.io.northwind.business.dtos.response.supplier.ListSupplierResponse;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.SupplierRepository;
import kodlama.io.northwind.entities.concretes.Supplier;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SupplierManager implements SupplierService {
    private SupplierRepository supplierRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<ListSupplierResponse> getAll() {
        List<Supplier> suppliers = supplierRepository.findAll();
        List<ListSupplierResponse> responses = suppliers.stream()
                .map(supplier -> modelMapperService.forResponse().map(supplier,ListSupplierResponse.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public GetSupplierResponse getById(int id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow();
        GetSupplierResponse response = modelMapperService.forResponse().map(supplier,GetSupplierResponse.class);

        return response;
    }

    @Override
    public GetSupplierResponse addSupplier(CreateSupplierRequest createSupplierRequest) {
        Supplier supplier = modelMapperService.forRequest().map(createSupplierRequest,Supplier.class);
        Supplier savedSupplier = supplierRepository.save(supplier);
        GetSupplierResponse response = modelMapperService.forResponse().map(savedSupplier,GetSupplierResponse.class);

        return response;
    }
}
