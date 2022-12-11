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
@Table(name = "region")
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    @Id
    @Column(name = "region_id")
    private int regionId;

    @Column(name="region_description")
    private String  regionDescription;
}
