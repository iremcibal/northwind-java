package kodlama.io.northwind.business.dtos.request.orderDetail;

import kodlama.io.northwind.entities.concretes.Order;
import kodlama.io.northwind.entities.concretes.Product;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDetailRequest {
    private int id;
    private double  unitPrice;
    private int quantity;
    private double discount;
    private int productId;
    private int orderId;

}
