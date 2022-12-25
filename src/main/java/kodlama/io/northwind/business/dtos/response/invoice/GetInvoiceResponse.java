package kodlama.io.northwind.business.dtos.response.invoice;

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
    private int orderDetailOrderDetailId;
    private String productName;
    private double  unitPrice;
    private int quantity;
}
