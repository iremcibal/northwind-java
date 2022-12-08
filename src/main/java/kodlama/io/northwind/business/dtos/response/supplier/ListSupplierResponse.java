package kodlama.io.northwind.business.dtos.response.supplier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListSupplierResponse {
    private String companyName;
    private String contactName;
    private String city;
    private String country;
    private String phone;
}
