package kodlama.io.northwind.business.dtos.response.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetStatusResponse {
    private int statusId;
    private String name;
}
