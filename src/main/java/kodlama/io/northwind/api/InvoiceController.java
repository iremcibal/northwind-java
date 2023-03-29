package kodlama.io.northwind.api;

import kodlama.io.northwind.business.abstracts.InvoiceService;
import kodlama.io.northwind.business.dtos.request.category.CreateCategoryRequest;
import kodlama.io.northwind.business.dtos.request.invoice.CreateInvoiceRequest;
import kodlama.io.northwind.business.dtos.response.category.GetCategoryResponse;
import kodlama.io.northwind.business.dtos.response.category.ListCategoryResponse;
import kodlama.io.northwind.business.dtos.response.invoice.GetInvoiceResponse;
import kodlama.io.northwind.business.dtos.response.invoice.ListInvoiceResponse;
import kodlama.io.northwind.core.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@AllArgsConstructor
public class InvoiceController {
    private InvoiceService invoiceService;

    @GetMapping("/getAll")
    public DataResult<List<ListInvoiceResponse>> getAll(){
        return invoiceService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetInvoiceResponse> getById(@RequestParam("id") int id){
        return invoiceService.getById(id);
    }

    @PostMapping("/addInvoice")
    public DataResult<GetInvoiceResponse> add(@RequestBody CreateInvoiceRequest createInvoiceRequest){
        return invoiceService.addInvoiceRes(createInvoiceRequest);
    }
}
