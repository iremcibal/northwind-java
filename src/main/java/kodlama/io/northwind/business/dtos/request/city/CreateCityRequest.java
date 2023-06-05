package kodlama.io.northwind.business.dtos.request.city;

import kodlama.io.northwind.entities.concretes.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCityRequest {
    private int cityId;
    private String name;
    @Min(1)
    private int countryId;
}
