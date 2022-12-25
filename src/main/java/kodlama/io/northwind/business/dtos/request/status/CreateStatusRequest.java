package kodlama.io.northwind.business.dtos.request.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateStatusRequest {
    private int statusId;
    private String name;
}
