package kodlama.io.northwind.business.dtos.response.product;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetProductResponse {
    private int productId;
    private String productName;
    private double unitPrice;
    private int unitsInStock;
    private int categoryId;
    private int supplierId;

}
