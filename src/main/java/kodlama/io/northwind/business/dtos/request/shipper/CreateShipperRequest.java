package kodlama.io.northwind.business.dtos.request.shipper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateShipperRequest {
    private int shipperId;
    private String companyName;
    private String phone;
}
