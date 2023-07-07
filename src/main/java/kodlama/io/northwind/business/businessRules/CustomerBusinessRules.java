package kodlama.io.northwind.business.businessRules;

import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.core.exception.InternalException;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.dataAccess.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomerBusinessRules {
    private CustomerRepository customerRepository;
    private MessageService messageService;

    public void checkIfCustomerExistById(int id){
        boolean isExists = customerRepository.existsCustomerByCustomerId(id);
        if(isExists){
            throw new InternalException(messageService.getMessage(Messages.Customer.CustomerExistsWithSameId));
        }
    }
}
