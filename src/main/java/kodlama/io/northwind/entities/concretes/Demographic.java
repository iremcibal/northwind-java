package kodlama.io.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "demographics")
@AllArgsConstructor
@NoArgsConstructor
public class Demographic {
    @Id
    @Column(name = "customer_type_id")
    private String customerTypeId;

    @Column(name = "customer_desc")
    private String customerDesc;


}
