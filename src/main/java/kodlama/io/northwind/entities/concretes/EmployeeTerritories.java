package kodlama.io.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "employee_territories")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTerritories {
    @Id
    @Column(name = "emp_terri_id")
    private int employeeTerritoryId;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "territory_id")
    private Territory territory;
}
