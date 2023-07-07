package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.entities.concretes.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    Invoice getByInvoiceId(int invoiceId);
    boolean existsInvoiceByInvoiceId(int id);
}
