package kodlama.io.northwind.business.dtos.request.order;
import kodlama.io.northwind.business.dtos.request.orderDetail.CreateOrderDetailRequest;
import kodlama.io.northwind.entities.concretes.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private int freight;
    private String shipName;
    private String shippAddress;
    private String  shipCity;
    private String  shipRegion;
    private String  shipPostalCode;
    private String shipCountry;
    private String customerId;
    private int employeeId;
    private int shipperId;
    private List<CreateOrderDetailRequest> orderDetails;
}
