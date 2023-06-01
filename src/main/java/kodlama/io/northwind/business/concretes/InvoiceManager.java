package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.InvoiceService;
import kodlama.io.northwind.business.dtos.request.invoice.CreateInvoiceRequest;
import kodlama.io.northwind.business.dtos.request.orderDetail.CreateOrderDetailRequest;
import kodlama.io.northwind.business.dtos.response.invoice.GetInvoiceResponse;
import kodlama.io.northwind.business.dtos.response.invoice.ListInvoiceResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;
import kodlama.io.northwind.core.results.SuccessDataResult;
import kodlama.io.northwind.core.results.SuccessResult;
import kodlama.io.northwind.core.util.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.InvoiceRepository;
import kodlama.io.northwind.entities.concretes.Invoice;
import kodlama.io.northwind.entities.concretes.OrderDetail;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private InvoiceRepository repository;
    private ModelMapperService modelMapperService;

    @Override
    public Result addRange(int orderDetailId, CreateInvoiceRequest createInvoiceRequest) {
        createInvoiceRequest.setOrderDetailId(orderDetailId);
        Invoice invoice = modelMapperService.forRequest().map(createInvoiceRequest, Invoice.class);
        invoice.setInvoiceId(orderDetailId);
        repository.save(invoice);

        return new SuccessResult();
    }

    /*@Override
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
    public DataResult<Invoice> getByInvoiceId(int id) {
        Invoice invoice = repository.getByInvoiceId(id);
        return new SuccessDataResult<Invoice>(invoice,"data listed");
    }

    @Override
    public DataResult<GetInvoiceResponse> addInvoiceRes(CreateInvoiceRequest createInvoiceRequest) {
        Invoice invoice = modelMapperServices.forRequest().map(createInvoiceRequest,Invoice.class);
        Invoice savedInvoice = repository.save(invoice);
        GetInvoiceResponse response = modelMapperServices.forResponse().map(savedInvoice,GetInvoiceResponse.class);

        return new SuccessDataResult<>(response,"data added");
    }

    @Override
    public DataResult<Invoice> addInvoice(Invoice invoice) {
        Invoice savedInvoice = repository.save(invoice);
        return new SuccessDataResult<>(savedInvoice,"data added");
    }*/
}
