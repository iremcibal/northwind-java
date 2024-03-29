package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.ShipperService;
import kodlama.io.northwind.business.constants.Messages;
import kodlama.io.northwind.business.dtos.request.shipper.CreateShipperRequest;
import kodlama.io.northwind.business.dtos.response.shipper.GetShipperResponse;
import kodlama.io.northwind.business.dtos.response.shipper.ListShipperResponse;
import kodlama.io.northwind.core.internationalization.MessageService;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.ShipperRepository;
import kodlama.io.northwind.entities.concretes.Shipper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShipperManager implements ShipperService {
    private ShipperRepository shipperRepository;
    private ModelMapperService modelMapperService;
    private MessageService messageService;

    @Override
    public DataResult<List<ListShipperResponse>> getAll() {
        List<Shipper> shippers = shipperRepository.findAll();
        List<ListShipperResponse> responses = shippers.stream()
                .map(shipper -> modelMapperService.forResponse().map(shipper,ListShipperResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responses,messageService.getMessage(Messages.Data.dataListed));
    }

    @Override
    public DataResult<GetShipperResponse> addShipper(CreateShipperRequest createShipperRequest) {
        Shipper shipper = modelMapperService.forRequest().map(createShipperRequest,Shipper.class);
        Shipper savedShipper = shipperRepository.save(shipper);
        GetShipperResponse response = modelMapperService.forResponse().map(savedShipper,GetShipperResponse.class);

        return new SuccessDataResult<>(response,messageService.getMessage(Messages.Data.dataAdded));
    }
}
