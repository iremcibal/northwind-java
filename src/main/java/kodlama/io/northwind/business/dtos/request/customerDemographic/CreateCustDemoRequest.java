package kodlama.io.northwind.business.dtos.request.customerDemographic;

import kodlama.io.northwind.entities.concretes.Customer;
import kodlama.io.northwind.entities.concretes.Demographic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustDemoRequest {
    private int custDemoId;
    private String customerId;
    private String customerTypeId;
}
