package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.entities.concretes.Category;
import kodlama.io.northwind.entities.concretes.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> getAll();
    Supplier getById(int id);
}
