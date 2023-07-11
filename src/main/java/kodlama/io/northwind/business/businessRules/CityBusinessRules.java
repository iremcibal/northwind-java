package kodlama.io.northwind.business.businessRules;

import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.core.exception.InternalException;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.dataAccess.abstracts.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CityBusinessRules {
    private CityRepository cityRepository;
    private MessageService messageService;

    public void checkIfCityNotExistById(int id){
        boolean isExists = cityRepository.existsCityBycityId(id);
        if(!isExists){
            throw new InternalException(messageService.getMessage(Messages.City.CityNotExistsWithSameId));
        }
    }
}
