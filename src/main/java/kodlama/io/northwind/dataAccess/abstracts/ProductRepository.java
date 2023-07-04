package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.business.dtos.response.product.GetProductResponse;
import kodlama.io.northwind.business.dtos.response.product.ListProductResponse;
import kodlama.io.northwind.entities.concretes.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product getByProductId(int productId);
    List<ListProductResponse> getAllByUnitsInStockGreaterThan(int stock);
    Product getByProductName(String name);

    //Select dto from Query as JPQL
    @Query("Select p from Product as p")
    Slice<Product> getAllWithSlice(Pageable pageable);

    @Query("Select new kodlama.io.northwind.business.dtos.response.product.ListProductResponse(p.productId,p.productName,p.unitPrice) from Product as p")
    Page<ListProductResponse> getAllListProducts(Pageable pageable);
}
