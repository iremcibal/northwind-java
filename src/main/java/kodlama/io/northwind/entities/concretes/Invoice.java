package kodlama.io.northwind.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Builder
@Entity
@Getter
@Setter
@Table(name = "invoices")
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    @Column(name = "invoice_id")
    private int invoiceId;

    @Column(name = "number")
    private String number;

    @Column(name = "created_date")
    private Date createdDate;

    @OneToOne
    @JoinColumn(name="order_details_id",referencedColumnName = "order_details_id")
    private OrderDetail orderDetails;
}

