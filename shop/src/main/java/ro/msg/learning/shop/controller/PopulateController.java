package ro.msg.learning.shop.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ro.msg.learning.shop.model.Customer;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Order;
import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.model.OrderDetailId;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.ProductCategory;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.model.StockId;
import ro.msg.learning.shop.model.Supplier;
import ro.msg.learning.shop.repository.CustomerRepository;
import ro.msg.learning.shop.repository.LocationRepository;
import ro.msg.learning.shop.repository.OrderDetailRepository;
import ro.msg.learning.shop.repository.OrderRepository;
import ro.msg.learning.shop.repository.ProductCategoryRepository;
import ro.msg.learning.shop.repository.ProductRepository;
import ro.msg.learning.shop.repository.StockRepository;
import ro.msg.learning.shop.repository.SupplierRepository;

@RestController
@Profile("test")
public class PopulateController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    

    //@Bean
    @RequestMapping(value="/populate", method = RequestMethod.POST)
    public void populate()
    {

            LocalDateTime myObj = LocalDateTime.now();
            Location location = new Location("da","da","da","da","da");
			Customer customer = new Customer("da","da","da","da","da");
            Order order = new Order(location,customer,myObj,"da","da","da","da");
            ProductCategory productCategory = new ProductCategory("da","da");
            Supplier supplier = new Supplier("da");
            Product product = new Product("da","da",1.5,1.5,productCategory,supplier,"da");
            Stock stock = new Stock(new StockId(product.getId(), location.getId()), product, location, 100);
            OrderDetail orderDetail = new OrderDetail( new OrderDetailId(order.getId(), product.getId()), order, product, 20);   
            locationRepository.save(location);
            customerRepository.save(customer);
            orderRepository.save(order);
            productCategoryRepository.save(productCategory);
            supplierRepository.save(supplier);
            productRepository.save(product);
            stockRepository.save(stock);
            orderDetailRepository.save(orderDetail);

    }


    @RequestMapping(value="/clear", method = RequestMethod.DELETE)
    public void clear()
    {

            orderRepository.deleteAll();
            stockRepository.deleteAll();
            orderDetailRepository.deleteAll();
            locationRepository.deleteAll();
            customerRepository.deleteAll();
            productRepository.deleteAll();
            productCategoryRepository.deleteAll();
            supplierRepository.deleteAll();

            
    }
    
}
