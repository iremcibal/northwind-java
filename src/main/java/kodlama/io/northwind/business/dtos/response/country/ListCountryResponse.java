package kodlama.io.northwind.business.dtos.response.country;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListCountryResponse {
    private int countryId;
    private String name;
    private int regionId;
}
