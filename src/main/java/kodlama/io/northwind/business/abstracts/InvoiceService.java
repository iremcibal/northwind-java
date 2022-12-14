package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.invoice.CreateInvoiceRequest;
import kodlama.io.northwind.business.dtos.response.invoice.GetInvoiceResponse;
import kodlama.io.northwind.business.dtos.response.invoice.ListInvoiceResponse;
import kodlama.io.northwind.core.results.DataResult;

import java.util.List;

public interface InvoiceService {
    DataResult<List<ListInvoiceResponse>> getAll();
    DataResult<GetInvoiceResponse> getById(int id);
    DataResult<GetInvoiceResponse> addInvoice(CreateInvoiceRequest createInvoiceRequest);
}
