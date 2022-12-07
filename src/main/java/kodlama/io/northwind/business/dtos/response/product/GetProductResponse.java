package kodlama.io.northwind.business.dtos.response.product;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetProductResponse {
    private String productName;
    private double unitPrice;


}
