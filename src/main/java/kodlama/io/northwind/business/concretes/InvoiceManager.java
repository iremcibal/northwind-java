package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.InvoiceService;
import kodlama.io.northwind.business.dtos.request.invoice.CreateInvoiceRequest;
import kodlama.io.northwind.business.dtos.response.invoice.GetInvoiceResponse;
import kodlama.io.northwind.business.dtos.response.invoice.ListInvoiceResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.InvoiceRepository;
import kodlama.io.northwind.entities.concretes.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private InvoiceRepository repository;
    private ModelMapperService modelMapperServices;

    @Override
    public DataResult<List<ListInvoiceResponse>> getAll() {
        List<Invoice> invoices = repository.findAll();
        List<ListInvoiceResponse> responses = invoices.stream()
                .map(invoice -> modelMapperServices.forResponse().map(invoice,ListInvoiceResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responses,"data listed");
    }

    @Override
    public DataResult<GetInvoiceResponse> getById(int id) {
        Invoice invoice = repository.findById(id).orElseThrow();
        GetInvoiceResponse response = modelMapperServices.forResponse().map(invoice,GetInvoiceResponse.class);

        return new SuccessDataResult<>(response,"data listed");
    }

    @Override
    public DataResult<GetInvoiceResponse> addInvoice(CreateInvoiceRequest createInvoiceRequest) {
        Invoice invoice = modelMapperServices.forRequest().map(createInvoiceRequest,Invoice.class);
        Invoice savedInvoice = repository.save(invoice);
        GetInvoiceResponse response = modelMapperServices.forResponse().map(savedInvoice,GetInvoiceResponse.class);

        return new SuccessDataResult<>(response,"data added");
    }
}
