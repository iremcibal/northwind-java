package kodlama.io.northwind.business.dtos.request.usState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUsStateRequest {
    private int stateId;
    private String stateName;
    private String stateAbbr;
    private String stateRegion;
}
