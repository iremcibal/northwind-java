package kodlama.io.northwind.business.dtos.request.product;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {
    private int productId;
    private String productName;
    private double unitPrice;
    private int unitsInStock;
    private int categoryId;
    private int supplierId;

}
