package kodlama.io.northwind.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "required_date")
    private Date requiredDate;

    @Column(name = "shipped_date")
    private Date shippedDate;

    @Column(name = "freight")
    private double freight;

    @Column(name = "ship_name")
    private String shipName;

    @Column(name = "ship_address")
    private String shippAddress;

    @Column(name = "ship_city")
    private String  shipCity;

    @Column(name = "ship_region")
    private String  shipRegion;

    @Column(name = "ship_postal_code")
    private String  shipPostalCode;

    @Column(name = "ship_country")
    private String shipCountry;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="shipper_id")
    private Shipper shipper;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

}
