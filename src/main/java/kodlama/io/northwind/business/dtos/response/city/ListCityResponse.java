package kodlama.io.northwind.business.dtos.response.city;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListCityResponse {
    private int cityId;
    private String name;
    private int countryId;
}
