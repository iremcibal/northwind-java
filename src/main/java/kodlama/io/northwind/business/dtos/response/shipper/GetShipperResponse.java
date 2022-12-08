package kodlama.io.northwind.business.dtos.response.shipper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetShipperResponse {
    private String companyName;
    private String phone;
}
