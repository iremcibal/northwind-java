package kodlama.io.northwind.business.dtos.response.demographic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetDemographicResponse {
    private String customerTypeId;
    private String customerDesc;
}
