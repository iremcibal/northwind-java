package kodlama.io.northwind.business.businessRules;

import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.core.exception.InternalException;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.dataAccess.abstracts.ProductRepository;
import kodlama.io.northwind.dataAccess.abstracts.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SupplierBusinessRules {
    private SupplierRepository repository;
    private MessageService messageService;

    public void checkIfSupplierExistById(int id){
        boolean isExists = repository.existsSupplierBySupplierId(id);
        if(isExists){
            throw new InternalException(messageService.getMessage(Messages.Supplier.SupplierExistsWithSameId));
        }
    }
}
