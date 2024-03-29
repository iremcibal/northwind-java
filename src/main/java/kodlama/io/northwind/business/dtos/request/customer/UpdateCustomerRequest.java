package kodlama.io.northwind.business.dtos.request.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {
    private String customerId;
    private String companyName;
    private String contactName;
    private String contactTitle;

    //    private String address;
//    private String city;
//    private String region;
//    private String postalCode;
//    private String country;
    private String phone;
    private String fax;
}
