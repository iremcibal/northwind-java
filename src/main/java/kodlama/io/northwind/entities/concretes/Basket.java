package kodlama.io.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "baskets")
@AllArgsConstructor
@NoArgsConstructor
public class Basket {
    @Id
    @Column(name = "basket_id")
    private int basketId;

    @Column(name = "total_cost")
    private int totalCost;

    @OneToOne
    @JoinColumn(name="customer_id",referencedColumnName = "customer_id")
    private Customer customer;
}
