package kodlama.io.northwind.business.dtos.request.country;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCountryRequest {
    private int countryId;
    private String name;
    @Min(1)
    private int regionId;
}
