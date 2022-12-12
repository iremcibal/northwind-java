package kodlama.io.northwind.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
    private int orderDetailId;
    private double  unitPrice;
    private int quantity;
    private double discount;
    private String productName;
    private int orderId;
}
