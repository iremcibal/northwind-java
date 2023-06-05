package kodlama.io.northwind.business.dtos.response.country;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetCountryResponse {
    private int countryId;
    private String name;
    private int regionId;
}
