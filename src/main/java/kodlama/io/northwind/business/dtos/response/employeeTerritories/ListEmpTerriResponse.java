package kodlama.io.northwind.business.dtos.response.employeeTerritories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListEmpTerriResponse {
    private int employeeTerritoryId;
    private String firstName;
    private String lastName;
    private String territoryDescription;
}
