package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ro.msg.learning.shop.model.*;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
    @Query(value = "SELECT * FROM customer u WHERE u.username=?1 LIMIT 1",nativeQuery = true )
    public Customer findByUsername(String username);
}