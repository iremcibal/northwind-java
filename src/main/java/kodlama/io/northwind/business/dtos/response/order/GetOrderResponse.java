package kodlama.io.northwind.business.dtos.response.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderResponse {
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
