package kodlama.io.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "shippers")
@AllArgsConstructor
@NoArgsConstructor
public class Shipper {
    @Id
    @Column(name = "shipper_id")
    private int shipperId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "phone")
    private String phone;

}
