package kodlama.io.northwind.business.businessRules;

import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.core.exception.InternalException;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.dataAccess.abstracts.CategoryRepository;
import kodlama.io.northwind.dataAccess.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductBusinessRules {
    private ProductRepository repository;
    private MessageService messageService;

    public void checkIfProductNotExistById(int id){
        boolean isExists = repository.existsProductByProductId(id);
        if(!isExists){
            throw new InternalException(messageService.getMessage(Messages.Product.ProductNotExistsWithSameId));
        }
    }
}
