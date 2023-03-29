package kodlama.io.northwind.business.dtos.response.orderDetail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListOrderDetailResponse {
    private int id;
    private double  unitPrice;
    private int quantity;
    private double discount;
    private String productName;
    private int orderId;
}
