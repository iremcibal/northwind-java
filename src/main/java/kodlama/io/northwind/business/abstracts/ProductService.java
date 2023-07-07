package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.employee.UpdateEmployeeRequest;
import kodlama.io.northwind.business.dtos.request.product.CreateProductRequest;
import kodlama.io.northwind.business.dtos.request.product.UpdateProductRequest;
import kodlama.io.northwind.business.dtos.response.employee.GetEmployeeResponse;
import kodlama.io.northwind.business.dtos.response.product.GetProductResponse;
import kodlama.io.northwind.business.dtos.response.product.ListProductResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;
import kodlama.io.northwind.entities.concretes.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import javax.xml.crypto.Data;
import java.util.List;

public interface ProductService {
    DataResult<List<ListProductResponse>> getAll();
    DataResult<GetProductResponse> getById(int id);
    DataResult<Product> getByProductIdData(int id);
    Product getByProductId(int id);
    DataResult<GetProductResponse> update(UpdateProductRequest request, int id);
    Result delete(int id);

    //repositoryde jpa metotları dışında metot oluşturuluyor!!
    DataResult<List<ListProductResponse>> getAllByUnitsInStockGreaterThan(int stock);
    DataResult<GetProductResponse> getByProductName(String name);
    DataResult<GetProductResponse> addProduct(CreateProductRequest createProductRequest);

    //Pagination exp
    //Sort – Sıralama için kullanılan sınıftır.
    //Slice – Parçalama işlemleri yer alır.
    //Page – Parçalama ve sayfalama işlemleri yer alır.
    Page<Product> findAllWithPagination(Pageable pageable);
    Slice<Product> findAllWithSlice(Pageable pageable);
    Page<ListProductResponse> findAllWithPaginationDto(Pageable pageable);


}
