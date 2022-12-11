package kodlama.io.northwind.business.dtos.response.employeeTerritories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetEmpTerriResponse {
    private int employerTerritoryId;
    private int employeeId;
    private String territoryId;
}
