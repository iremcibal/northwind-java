package kodlama.io.northwind.business.dtos.request.orderDetail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDetailRequest {
    private int orderDetailId;
    private double  unitPrice;
    private int quantity;
    private double discount;
    private int productId;
    private int orderId;

}
