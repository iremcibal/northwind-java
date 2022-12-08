package kodlama.io.northwind.business.dtos.request.order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
    private int orderId;
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
}
