package kodlama.io.northwind.entities.concretes;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Getter
@Setter
@Table(name = "countries")
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int countryId;

    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name="region_id")
    private Region region;
}
