package kodlama.io.northwind.entities.concretes;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "suppliers")
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    @Id
    @Column(name = "supplier_id")
    private int supplier_id;

    @Column(name = "company_name")
    private String company_name;

    @Column(name = "contact_name")
    private String contact_name;

    @Column(name = "contact_title")
    private String contact_title;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "region")
    private String region;

    @Column(name = "postal_code")
    private String postal_code;

    @Column(name = "country")
    private String country;

    @Column(name = "phone")
    private String phone;

    @Column(name = "fax")
    private String fax;



}
