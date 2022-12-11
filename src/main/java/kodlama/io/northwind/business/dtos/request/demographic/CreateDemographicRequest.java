package kodlama.io.northwind.business.dtos.request.demographic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateDemographicRequest {
    private String customerTypeId;
    private String customerDesc;
}
