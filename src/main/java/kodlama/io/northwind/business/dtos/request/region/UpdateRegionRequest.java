package kodlama.io.northwind.business.dtos.request.region;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRegionRequest {
    private int regionId;
    private String  regionDescription;
}
