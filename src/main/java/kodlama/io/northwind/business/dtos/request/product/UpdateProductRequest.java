package kodlama.io.northwind.business.dtos.request.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {
    private int productId;
    @NotBlank(message = "{nameMustNotBeEmpty}")
    @NotNull(message = "{nameMustNotBeEmpty}")
    @Size(min = 3,max = 50,message = "{nameMustBeBetween}")
    private String productName;
    @Min(1)
    private double unitPrice;
    @Min(0)
    private int unitsInStock;
    @Min(1)
    private int categoryId;
    @Min(1)
    private int supplierId;
}
