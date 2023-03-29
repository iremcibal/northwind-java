package kodlama.io.northwind.business.dtos.response.orderDetail;

import kodlama.io.northwind.entities.concretes.OrderDetail;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetOrderDetailResponse {
    private int id;
    private double  unitPrice;
    private int quantity;
    private double discount;
    private int productId;
    private int orderId;
}
