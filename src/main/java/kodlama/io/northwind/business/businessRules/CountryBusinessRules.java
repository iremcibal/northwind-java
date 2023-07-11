package kodlama.io.northwind.business.businessRules;

import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.core.exception.InternalException;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.dataAccess.abstracts.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CountryBusinessRules {
    private CountryRepository countryRepository;
    private MessageService messageService;

    public void checkIfCountryNotExistById(int id){
        boolean isExists = countryRepository.existsCountryByCountryId(id);
        if(!isExists){
            throw new InternalException(messageService.getMessage(Messages.Country.CountryNotExistsWithSameId));
        }
    }
}
