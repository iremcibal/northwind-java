package kodlama.io.northwind.entities.concretes;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Getter
@Setter
@Table(name = "region")
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    @Id
    @Column(name = "region_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regionId;

    @Column(name="region_description")
    private String  regionDescription;
}
