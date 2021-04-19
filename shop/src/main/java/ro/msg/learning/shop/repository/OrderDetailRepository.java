package ro.msg.learning.shop.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ro.msg.learning.shop.model.*;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId>
{
    
    @Query(value = "SELECT * FROM order_detail u WHERE u.order_ship=?1", nativeQuery = true)
    List<OrderDetail> findForOrder(int orderID);
    
}