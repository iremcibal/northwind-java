package kodlama.io.northwind.business.dtos.response.customerDemographic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListCustDemoResponse {
    private int custDemoId;
    private String customerId;
    private String customerTypeId;
}
