package kodlama.io.northwind.business.businessRules;

import kodlama.io.northwind.business.abstracts.AddressService;
import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.core.exception.InternalException;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.dataAccess.abstracts.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddressBusinessRules {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private MessageService messageService;

    public void checkIfAddressExistById(int id){
        boolean isExists = addressRepository.existsAddressByAddressId(id);
        if(isExists){
            throw new InternalException(messageService.getMessage(Messages.Address.AddressExistsWithSameId));
        }
    }
}
