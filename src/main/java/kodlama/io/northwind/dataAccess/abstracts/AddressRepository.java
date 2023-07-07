package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.business.dtos.response.address.ListAddressResponse;
import kodlama.io.northwind.entities.concretes.Address;
import kodlama.io.northwind.entities.concretes.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query("Select a from Address as a")
    Slice<ListAddressResponse> getAllWithSlice(Pageable pageable);

    boolean existsAddressByAddressId(int id);
}
