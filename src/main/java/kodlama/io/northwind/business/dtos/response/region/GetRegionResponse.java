package kodlama.io.northwind.business.dtos.response.region;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetRegionResponse {
    private int regionId;
    private String  regionDescription;
}
