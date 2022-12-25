package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.StatusService;
import kodlama.io.northwind.business.dtos.request.status.CreateStatusRequest;
import kodlama.io.northwind.business.dtos.response.status.GetStatusResponse;
import kodlama.io.northwind.business.dtos.response.status.ListStatusResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.StatusRepository;
import kodlama.io.northwind.entities.concretes.Status;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StatusManager implements StatusService {
    private StatusRepository repository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<ListStatusResponse>> getAll() {
        List<Status> status = repository.findAll();
        List<ListStatusResponse> responses = status.stream()
                .map(status1 -> modelMapperService.forResponse().map(status1,ListStatusResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(responses,"data listed");
    }

    @Override
    public DataResult<GetStatusResponse> addStatus(CreateStatusRequest createStatusRequest) {
        Status status = modelMapperService.forRequest().map(createStatusRequest,Status.class);
        Status savedStatus = repository.save(status);
        GetStatusResponse response = modelMapperService.forResponse().map(savedStatus,GetStatusResponse.class);

        return new SuccessDataResult<>(response,"data saved");
    }
}
