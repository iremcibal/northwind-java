package kodlama.io.northwind.business.dtos.response.city;

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
public class GetCityResponse {
    private int cityId;
    private String name;
    private int countryId;
}
