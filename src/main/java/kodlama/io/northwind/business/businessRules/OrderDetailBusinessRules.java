package kodlama.io.northwind.business.businessRules;

import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.core.exception.InternalException;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.dataAccess.abstracts.OrderDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderDetailBusinessRules {
    private OrderDetailRepository orderDetailRepository;
    private MessageService messageService;

    public void checkIfOrderDetailExistById(int id){
        boolean isExists = orderDetailRepository.existsOrderDetailById(id);
        if(isExists){
            throw new InternalException(messageService.getMessage(Messages.OrderDetail.OrderDetailExistsWithSameId));
        }
    }
}
