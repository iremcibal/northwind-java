package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.CategoryService;
import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.business.abstracts.SupplierService;
import kodlama.io.northwind.business.dtos.request.product.CreateProductRequest;
import kodlama.io.northwind.business.dtos.response.product.GetProductResponse;
import kodlama.io.northwind.business.dtos.response.product.ListProductResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.ProductRepository;
import kodlama.io.northwind.entities.concretes.Category;
import kodlama.io.northwind.entities.concretes.Product;
import kodlama.io.northwind.entities.concretes.Supplier;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private ProductRepository productRepository;
    private CategoryService categoryService;
    private SupplierService supplierService;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<ListProductResponse>> getAll() {
        List<Product> products = productRepository.findAll();
        List<ListProductResponse> response = products.stream()
                .map(product ->modelMapperService.forResponse().map(product,ListProductResponse.class ))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(response,"data listed");
    }

    @Override
    public DataResult<GetProductResponse> getById(int id) {
        Optional<Product> product = productRepository.findById(id);
        GetProductResponse response = modelMapperService.forResponse().map(product,GetProductResponse.class);

        return new SuccessDataResult<>(response,"data listed");
    }

    @Override
    public DataResult<List<ListProductResponse>> getAllByUnitsInStockGreaterThan(int stock) {
        List<ListProductResponse> products = productRepository.getAllByUnitsInStockGreaterThan(stock);
        List<ListProductResponse> response = products.stream()
                .map(product -> modelMapperService.forResponse().map(product,ListProductResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(response,"data listed");
    }

    @Override
    public DataResult<GetProductResponse> getByProductName(String name) {
        Product product = productRepository.getByProductName(name);
        GetProductResponse response = modelMapperService.forResponse().map(product,GetProductResponse.class);

        return new SuccessDataResult<>(response,"data listed");
    }

    @Override
    public DataResult<GetProductResponse> addProduct(CreateProductRequest createProductRequest) {
        Product product = modelMapperService.forRequest().map(createProductRequest,Product.class);
        /*product.setProductName(createProductRequest.getProduct_name());
        product.setUnitPrice(createProductRequest.getUnit_price());
        product.setUnitsInStock(createProductRequest.getUnits_in_stock());*/

        /*Category category = categoryService.getById(createProductRequest.getCategory_id());
        product.setCategory(category);
        Supplier supplier = supplierService.getById(createProductRequest.getSupplier_id());
        product.setSupplier(supplier);*/

        Product savedProduct = productRepository.save(product);

//        GetProductResponse response = new GetProductResponse(savedProduct.getProductName(),savedProduct.getUnitPrice());
        GetProductResponse response = modelMapperService.forResponse().map(savedProduct,GetProductResponse.class);

        return new SuccessDataResult<>(response,"data added");
    }
}
