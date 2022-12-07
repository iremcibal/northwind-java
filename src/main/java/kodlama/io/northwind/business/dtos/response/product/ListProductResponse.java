package kodlama.io.northwind.business.dtos.response.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListProductResponse {
    private String productName;
    private double unitPrice;
    private int unitsInStock;
    private int categoryId;
    private int supplierId;
}
