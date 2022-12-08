package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.category.CreateCategoryRequest;
import kodlama.io.northwind.business.dtos.request.supplier.CreateSupplierRequest;
import kodlama.io.northwind.business.dtos.response.category.GetCategoryResponse;
import kodlama.io.northwind.business.dtos.response.supplier.GetSupplierResponse;
import kodlama.io.northwind.business.dtos.response.supplier.ListSupplierResponse;
import kodlama.io.northwind.entities.concretes.Category;
import kodlama.io.northwind.entities.concretes.Supplier;

import java.util.List;

public interface SupplierService {
    List<ListSupplierResponse> getAll();
    GetSupplierResponse getById(int id);
    GetSupplierResponse addSupplier(CreateSupplierRequest createSupplierRequest);
}
