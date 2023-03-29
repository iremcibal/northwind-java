package kodlama.io.northwind.business.dtos.response.order;

import kodlama.io.northwind.entities.concretes.Order;
import lombok.*;

import java.util.Date;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderResponse {
    private int orderId;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private double freight;
    private String shipName;
    private String shippAddress;
    private String  shipCity;
    private String  shipRegion;
    private String  shipPostalCode;
    private String shipCountry;
    private String customerId;
    private int employeeId;
    private int shipperId;
}
