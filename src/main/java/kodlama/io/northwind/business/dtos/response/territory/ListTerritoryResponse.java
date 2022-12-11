package kodlama.io.northwind.business.dtos.response.territory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListTerritoryResponse {
    private String territoryId;
    private String  territoryDescription;
    private int regionId;
}
