package ro.msg.learning.shop.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ro.msg.learning.shop.model.*;

@Repository
public interface StockRepository extends JpaRepository<Stock, StockId>
{
    @Query(value = "SELECT * FROM stock u WHERE u.product=?1", nativeQuery = true)
    List<Stock> findStocksForProduct(int productID);

    @Query(value="SELECT * FROM stock WHERE product=?1 ORDER BY -quantity LIMIT 1", nativeQuery = true)
    Stock getMaxForProduct(int productID);
}