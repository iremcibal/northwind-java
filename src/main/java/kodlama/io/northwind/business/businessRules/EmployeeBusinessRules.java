package kodlama.io.northwind.business.businessRules;

import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.core.exception.InternalException;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.dataAccess.abstracts.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmployeeBusinessRules {
    private EmployeeRepository employeeRepository;
    private MessageService messageService;

    public void checkIfEmployeeNotExistById(int id){
        boolean isExists = employeeRepository.existsEmployeeByEmployeeId(id);
        if(!isExists){
            throw new InternalException(messageService.getMessage(Messages.Employee.EmployeeNotExistsWithSameId));
        }
    }
}
