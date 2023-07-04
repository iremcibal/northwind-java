package kodlama.io.northwind.business.dtos.response.address;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListAddressResponse {
    private int addressId;
    private String street;
    private String doorNo;
    private String customerId;
    private int cityId;
}
