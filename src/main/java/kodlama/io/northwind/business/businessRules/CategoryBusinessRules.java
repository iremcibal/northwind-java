package kodlama.io.northwind.business.businessRules;

import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.core.exception.BusinessException;
import kodlama.io.northwind.core.exception.InternalException;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.dataAccess.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CategoryBusinessRules {
    private CategoryRepository repository;
    //private MessageSource messageSource;
    private MessageService messageService;

    public void CategoryExistsWithSameName(String name){
        boolean isExists = repository.existsCategoryByCategoryName(name);

        if(isExists){
            throw new InternalException(messageService.getMessage(Messages.Category.CategoryExistsWithSameName));
        }
    }

    public void CategoryNotExistsWithSameId(int id){
        boolean isExists = repository.existsCategoryByCategoryId(id);

        if(!isExists){
            throw new InternalException(messageService.getMessage(Messages.Category.CategoryNotExistsWithSameId));
        }
    }
}
