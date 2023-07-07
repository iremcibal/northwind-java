package kodlama.io.northwind.business.dtos.request.address;

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
public class UpdateAddressRequest {
    private int addressId;
    private String street;
    private String  doorNo;
    @NotBlank(message = "{nameMustNotBeEmpty}")
    private String  customerId;
    @Min(1)
    private String cityId;
}
