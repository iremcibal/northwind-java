package kodlama.io.northwind.business.dtos.request.address;

import kodlama.io.northwind.entities.concretes.City;
import kodlama.io.northwind.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAddressRequest {
    private int addressId;
    private String street;
    private String  doorNo;
    @NotBlank(message = "{nameMustNotBeEmpty}")
    private String  customerId;
    @Min(1)
    private String cityId;
}
