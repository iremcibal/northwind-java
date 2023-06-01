package kodlama.io.northwind.business.businessRules;

import kodlama.io.northwind.dataAccess.abstracts.CategoryRepository;
import kodlama.io.northwind.dataAccess.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
@AllArgsConstructor
public class ProductBusinessRules {
    private ProductRepository repository;
    private MessageSource messageSource;


}
