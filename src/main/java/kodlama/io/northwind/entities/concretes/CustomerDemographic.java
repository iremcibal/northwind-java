package kodlama.io.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "customer_demographics")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDemographic {
    @Id
    @Column(name = "cust_demo_id")
    private int custDemoId;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private Demographic demographic;

}
