package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.UsStateService;
import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.business.dtos.request.usState.CreateUsStateRequest;
import kodlama.io.northwind.business.dtos.response.usState.GetUsStateResponse;
import kodlama.io.northwind.business.dtos.response.usState.ListUsStateResponse;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.UsStateRepository;
import kodlama.io.northwind.entities.concretes.UsState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsStateManager implements UsStateService {
    private UsStateRepository repository;
    private ModelMapperService service;
    private MessageService messageService;

    @Override
    public DataResult<List<ListUsStateResponse>> getAll() {
        List<UsState> states = repository.findAll();
        List<ListUsStateResponse> responses = states.stream()
                .map(usState -> service.forResponse().map(usState,ListUsStateResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responses,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public DataResult<GetUsStateResponse> addUsState(CreateUsStateRequest createUsStateRequest) {
        UsState state = service.forRequest().map(createUsStateRequest,UsState.class);
        UsState savedState = repository.save(state);
        GetUsStateResponse response = service.forResponse().map(savedState,GetUsStateResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataAdded));
    }
}
