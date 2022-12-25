package kodlama.io.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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
    @JoinColumn(name="orderdetails_id",referencedColumnName = "order_detail_id")
    private OrderDetail orderDetail;
}
