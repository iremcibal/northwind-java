package kodlama.io.northwind.business.dtos.response.usState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetUsStateResponse {
    private int stateId;
    private String stateName;
    private String stateAbbr;
    private String stateRegion;
}
