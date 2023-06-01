package kodlama.io.northwind.business.dtos.request.invoice;

import kodlama.io.northwind.entities.concretes.OrderDetail;
import lombok.*;

import java.util.Date;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateInvoiceRequest {
    private String number;
    private Date createdDate;
    private int orderDetailId;
}
