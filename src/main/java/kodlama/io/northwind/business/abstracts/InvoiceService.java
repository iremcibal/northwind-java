package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.business.dtos.request.invoice.CreateInvoiceRequest;
import kodlama.io.northwind.business.dtos.request.orderDetail.CreateOrderDetailRequest;
import kodlama.io.northwind.business.dtos.response.invoice.GetInvoiceResponse;
import kodlama.io.northwind.business.dtos.response.invoice.ListInvoiceResponse;
import kodlama.io.northwind.core.results.DataResult;
import kodlama.io.northwind.core.results.Result;
import kodlama.io.northwind.entities.concretes.Invoice;

import java.util.List;

public interface InvoiceService {
    /*DataResult<List<ListInvoiceResponse>> getAll();
    DataResult<GetInvoiceResponse> getById(int id);
    DataResult<Invoice> getByInvoiceId(int id);
    DataResult<GetInvoiceResponse> addInvoiceRes(CreateInvoiceRequest createInvoiceRequest);
    DataResult<Invoice> addInvoice(Invoice invoice);*/
    Result addRange(int orderDetailId, CreateInvoiceRequest createInvoiceRequest);
    Result delete(int id);
}
