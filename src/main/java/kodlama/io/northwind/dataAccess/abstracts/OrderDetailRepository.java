package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.business.dtos.response.orderDetail.GetOrderDetailResponse;
import kodlama.io.northwind.business.dtos.response.orderDetail.ListOrderDetailResponse;
import kodlama.io.northwind.entities.concretes.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {

    @Query("Select new kodlama.io.northwind.business.dtos.response.orderDetail.ListOrderDetailResponse(od.id,od.unitPrice,od.quantity,od.discount,od.product.productName,od.order.id) " +
            "from OrderDetail od join od.product p join od.order o where o.id=:orderId")
    List<ListOrderDetailResponse> findAllOrderById(int orderId);
    OrderDetail findAllOrderDetailByOrderOrderId(int orderId);
    boolean existsOrderDetailByOrderOrderId(int id);



}
