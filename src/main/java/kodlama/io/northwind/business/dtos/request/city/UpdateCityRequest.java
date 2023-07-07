package kodlama.io.northwind.business.dtos.request.city;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCityRequest {
    private int cityId;
    private String name;
    @Min(1)
    private int countryId;
}
