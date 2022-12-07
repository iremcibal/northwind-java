package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.product.CreateProductRequest;
import kodlama.io.northwind.business.dtos.response.product.GetProductResponse;
import kodlama.io.northwind.business.dtos.response.product.ListProductResponse;
import kodlama.io.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<ListProductResponse> getAll();
    GetProductResponse getById(int id);
    //repositoryde jpa metotları dışında metot oluşturuluyor!!
    List<ListProductResponse> getAllByUnitsInStockGreaterThan(int stock);
    GetProductResponse getByProductName(String name);
    GetProductResponse addProduct(CreateProductRequest createProductRequest);
}
