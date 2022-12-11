package kodlama.io.northwind.business.dtos.response.orderDetail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetOrderDetailResponse {
    private int orderDetailId;
    private double  unitPrice;
    private int quantity;
    private double discount;
    private int productId;
    private int orderId;
}
