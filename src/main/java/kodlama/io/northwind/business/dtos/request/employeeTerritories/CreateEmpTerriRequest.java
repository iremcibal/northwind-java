package kodlama.io.northwind.business.dtos.request.employeeTerritories;

import kodlama.io.northwind.entities.concretes.Employee;
import kodlama.io.northwind.entities.concretes.Territory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmpTerriRequest {
    private int employerTerritoryId;
    private int employeeId;
    private String territoryId;
}
