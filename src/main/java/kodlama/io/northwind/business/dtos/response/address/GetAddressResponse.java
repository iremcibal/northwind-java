package kodlama.io.northwind.business.dtos.response.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAddressResponse {
    private int addressId;
    private String street;
    private String  doorNo;
    private String  customerId;
    private int cityId;
}
