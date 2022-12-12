package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.usState.CreateUsStateRequest;
import kodlama.io.northwind.business.dtos.response.usState.GetUsStateResponse;
import kodlama.io.northwind.business.dtos.response.usState.ListUsStateResponse;
import kodlama.io.northwind.core.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UsStateService {
    DataResult<List<ListUsStateResponse>> getAll();
    DataResult<GetUsStateResponse> addUsState(CreateUsStateRequest createUsStateRequest);
}
