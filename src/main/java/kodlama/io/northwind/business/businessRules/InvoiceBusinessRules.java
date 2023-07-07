package kodlama.io.northwind.business.businessRules;

import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.core.exception.InternalException;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.dataAccess.abstracts.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InvoiceBusinessRules {
    private InvoiceRepository invoiceRepository;
    private MessageService messageService;

    public void checkIfInvoiceExistById(int id){
        boolean isExists = invoiceRepository.existsInvoiceByInvoiceId(id);
        if(isExists){
            throw new InternalException(messageService.getMessage(Messages.Invoice.InvoiceExistsWithSameId));
        }
    }
}
