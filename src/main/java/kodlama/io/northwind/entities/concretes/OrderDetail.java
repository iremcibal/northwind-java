package kodlama.io.northwind.entities.concretes;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Getter
@Setter
@Table(name = "order_details")
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_details_id")
    private int id;

    @Column(name = "unit_price")
    private double  unitPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "discount")
    private double discount;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

}
