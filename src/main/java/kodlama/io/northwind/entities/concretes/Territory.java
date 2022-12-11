package kodlama.io.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "territories")
@AllArgsConstructor
@NoArgsConstructor
public class Territory {
    @Id
    @Column(name = "territory_id")
    private String territoryId;

    @Column(name="territory_description")
    private String  territoryDescription;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
}
