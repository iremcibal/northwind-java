package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.business.businessRules.ProductBusinessRules;
import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.business.dtos.request.product.CreateProductRequest;
import kodlama.io.northwind.business.dtos.request.product.UpdateProductRequest;
import kodlama.io.northwind.business.dtos.response.product.GetProductResponse;
import kodlama.io.northwind.business.dtos.response.product.ListProductResponse;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.results.SuccessResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.ProductRepository;
import kodlama.io.northwind.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private ProductRepository productRepository;
    private ModelMapperService modelMapperService;
    private MessageService messageService;
    private ProductBusinessRules productBusinessRules;

    @Override
    public DataResult<List<ListProductResponse>> getAll() {
        List<Product> products = productRepository.findAll();
        List<ListProductResponse> response = products.stream()
                .map(product ->modelMapperService.forResponse().map(product,ListProductResponse.class ))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public DataResult<GetProductResponse> getById(int id) {
        Optional<Product> product = productRepository.findById(id);
        GetProductResponse response = modelMapperService.forResponse().map(product,GetProductResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public DataResult<Product> getByProductIdData(int id) {
        Product product = productRepository.getByProductId(id);
        return new SuccessDataResult<>(product,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public Product getByProductId(int id) {
        Product product = productRepository.getByProductId(id);
        return product;
    }

    @Override
    public DataResult<GetProductResponse> update(UpdateProductRequest request, int id) {
        productBusinessRules.checkIfProductNotExistById(id);
        Product product = modelMapperService.forRequest().map(request,Product.class);
        product.setProductId(id);
        productRepository.save(product);
        GetProductResponse response = modelMapperService.forResponse().map(product,GetProductResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataUpdated));
    }

    @Override
    public Result delete(int id) {
        productBusinessRules.checkIfProductNotExistById(id);
        productRepository.deleteById(id);

        return new SuccessResult(messageService.getMessage(Messages.Data.dataDeleted));
    }

    @Override
    public DataResult<List<ListProductResponse>> getAllByUnitsInStockGreaterThan(int stock) {
        List<ListProductResponse> products = productRepository.getAllByUnitsInStockGreaterThan(stock);
        List<ListProductResponse> response = products.stream()
                .map(product -> modelMapperService.forResponse().map(product,ListProductResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public DataResult<GetProductResponse> getByProductName(String name) {
        Product product = productRepository.getByProductName(name);
        GetProductResponse response = modelMapperService.forResponse().map(product,GetProductResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public DataResult<GetProductResponse> addProduct(CreateProductRequest createProductRequest) {
        Product product = modelMapperService.forRequest().map(createProductRequest,Product.class);
        /*product.setProductName(createProductRequest.getProduct_name());
        product.setUnitPrice(createProductRequest.getUnit_price());
        product.setUnitsInStock(createProductRequest.getUnits_in_stock());*/


        Product savedProduct = productRepository.save(product);

        GetProductResponse response = modelMapperService.forResponse().map(savedProduct,GetProductResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataAdded));
    }

    @Override
    public Page<Product> findAllWithPagination(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Slice<Product> findAllWithSlice(Pageable pageable) {
        return productRepository.getAllWithSlice(pageable);
    }

    @Override
    public Page<ListProductResponse> findAllWithPaginationDto(Pageable pageable) {
        return productRepository.getAllListProducts(pageable);
    }
}
