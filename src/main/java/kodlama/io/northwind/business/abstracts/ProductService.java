package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.product.CreateProductRequest;
import kodlama.io.northwind.business.dtos.response.product.GetProductResponse;
import kodlama.io.northwind.business.dtos.response.product.ListProductResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.entities.concretes.Product;

import javax.xml.crypto.Data;
import java.util.List;

public interface ProductService {
    DataResult<List<ListProductResponse>> getAll();
    DataResult<GetProductResponse> getById(int id);
    DataResult<Product> getByProductIdData(int id);
    Product getByProductId(int id);
    //repositoryde jpa metotları dışında metot oluşturuluyor!!
    DataResult<List<ListProductResponse>> getAllByUnitsInStockGreaterThan(int stock);
    DataResult<GetProductResponse> getByProductName(String name);
    DataResult<GetProductResponse> addProduct(CreateProductRequest createProductRequest);
}
