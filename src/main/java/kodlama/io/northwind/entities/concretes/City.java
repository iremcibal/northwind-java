package kodlama.io.northwind.entities.concretes;

import lombok.*;

import javax.persistence.*;
@Builder
@Entity
@Getter
@Setter
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityId;

    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;
}
