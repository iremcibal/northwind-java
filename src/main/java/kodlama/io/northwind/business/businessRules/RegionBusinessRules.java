package kodlama.io.northwind.business.businessRules;

import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.core.exception.InternalException;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.dataAccess.abstracts.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RegionBusinessRules {
    private RegionRepository regionRepository;
    private MessageService messageService;
    public void checkIfRegionNotExistById(int id){
        boolean isExists = regionRepository.existsRegionByRegionId(id);
        if(!isExists){
            throw new InternalException(messageService.getMessage(Messages.Region.RegionNotExistsWithSameId));
        }
    }
}
