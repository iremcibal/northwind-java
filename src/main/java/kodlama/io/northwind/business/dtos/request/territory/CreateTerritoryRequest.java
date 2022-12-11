package kodlama.io.northwind.business.dtos.request.territory;

import kodlama.io.northwind.entities.concretes.Region;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTerritoryRequest {
    private String territoryId;
    private String  territoryDescription;
    private int regionId;
}
