package kodlama.io.northwind.business.dtos.response.invoice;

import kodlama.io.northwind.entities.concretes.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetInvoiceResponse {
    private int invoiceId;
    private String number;
    private Date createdDate;
    private OrderDetail orderDetailId;
    private String productName;
    private double  unitPrice;
    private int quantity;
}
