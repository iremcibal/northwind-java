package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.business.dtos.response.address.ListAddressResponse;
import kodlama.io.northwind.entities.concretes.Address;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query(value = "Select new " +
            "kodlama.io.northwind.business.dtos.response.address.ListAddressResponse(a.addressId,a.street,a.doorNo,a.customerId,a.cityId) " +
            "From Address a",
            nativeQuery = false)
    Slice<ListAddressResponse> findAllPageable(Pageable pageable);
}
