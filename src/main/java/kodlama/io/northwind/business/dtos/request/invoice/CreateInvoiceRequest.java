package kodlama.io.northwind.business.dtos.request.invoice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateInvoiceRequest {
    private int invoiceId;
    private String number;
    private Date createdDate;
    private int orderDetailId;
}
