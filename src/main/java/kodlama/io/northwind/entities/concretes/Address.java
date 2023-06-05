package kodlama.io.northwind.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Builder
@Entity
@Getter
@Setter
@Table(name = "addresses")
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    @Column(name = "street")
    private String street;

    @Column(name = "doorNo")
    private String  doorNo;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;
}
