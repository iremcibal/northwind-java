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
@Table(name = "status")
@AllArgsConstructor
@NoArgsConstructor
public class Status {
    @Id
    @Column(name = "status_id")
    private int statusId;

    @Column(name = "name")
    private String name;
}
