package kodlama.io.northwind.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTerritoryDto {
    private int employeeTerritoryId;
    private String firstName;
    private String lastName;
    private String territoryDescription;
}
