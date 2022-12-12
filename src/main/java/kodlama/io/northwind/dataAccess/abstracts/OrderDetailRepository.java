package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.entities.concretes.OrderDetail;
import kodlama.io.northwind.entities.dtos.OrderDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {

    @Query("Select new kodlama.io.northwind.entities.dtos.OrderDetailDto(od.orderDetailId,od.unitPrice,od.quantity,od.discount,od.product.productName,od.order.id) " +
            "from OrderDetail od join od.product p join od.order o where o.id=:orderId")
    List<OrderDetailDto> findAllOrderById(int orderId);





}
