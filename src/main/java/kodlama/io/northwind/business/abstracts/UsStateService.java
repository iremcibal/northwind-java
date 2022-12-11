package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.usState.CreateUsStateRequest;
import kodlama.io.northwind.business.dtos.response.usState.GetUsStateResponse;
import kodlama.io.northwind.business.dtos.response.usState.ListUsStateResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UsStateService {
    List<ListUsStateResponse> getAll();
    GetUsStateResponse addUsState(CreateUsStateRequest createUsStateRequest);
}
