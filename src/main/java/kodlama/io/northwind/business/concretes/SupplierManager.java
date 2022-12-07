package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.SupplierService;
import kodlama.io.northwind.dataAccess.abstracts.SupplierRepository;
import kodlama.io.northwind.entities.concretes.Supplier;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupplierManager implements SupplierService {
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier getById(int id) {
        return supplierRepository.findById(id).orElseThrow();
    }
}
