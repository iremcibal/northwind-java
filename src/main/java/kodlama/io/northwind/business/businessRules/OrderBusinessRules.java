package kodlama.io.northwind.business.businessRules;

import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.core.exception.InternalException;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.dataAccess.abstracts.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderBusinessRules {
    private OrderRepository orderRepository;
    private MessageService messageService;

    public void checkIfOrderExistById(int id){
        boolean isExists = orderRepository.existsOrderByOrderId(id);
        if(isExists){
            throw new InternalException(messageService.getMessage(Messages.Order.OrderExistsWithSameId));
        }
    }
}
