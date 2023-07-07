package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.category.CreateCategoryRequest;
import kodlama.io.northwind.business.dtos.request.product.UpdateProductRequest;
import kodlama.io.northwind.business.dtos.request.supplier.CreateSupplierRequest;
import kodlama.io.northwind.business.dtos.request.supplier.UpdateSupplierRequest;
import kodlama.io.northwind.business.dtos.response.category.GetCategoryResponse;
import kodlama.io.northwind.business.dtos.response.product.GetProductResponse;
import kodlama.io.northwind.business.dtos.response.supplier.GetSupplierResponse;
import kodlama.io.northwind.business.dtos.response.supplier.ListSupplierResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;
import kodlama.io.northwind.entities.concretes.Category;
import kodlama.io.northwind.entities.concretes.Supplier;

import java.util.List;

public interface SupplierService {
    DataResult<List<ListSupplierResponse>> getAll();
    DataResult<GetSupplierResponse> getById(int id);
    DataResult<GetSupplierResponse> addSupplier(CreateSupplierRequest createSupplierRequest);
    DataResult<GetSupplierResponse> update(UpdateSupplierRequest request, int id);
    Result delete(int id);
}
