package ro.msg.learning.shop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


import ro.msg.learning.shop.repository.CustomerRepository;
import ro.msg.learning.shop.repository.LocationRepository;
import ro.msg.learning.shop.repository.OrderRepository;
import ro.msg.learning.shop.repository.ProductCategoryRepository;
import ro.msg.learning.shop.repository.ProductRepository;
import ro.msg.learning.shop.repository.StockRepository;
import ro.msg.learning.shop.repository.SupplierRepository;
import ro.msg.learning.shop.service.OrderDetailService;
import ro.msg.learning.shop.service.OrderService;

import ro.msg.learning.shop.controller.dto.OrderDTO;
import ro.msg.learning.shop.controller.dto.OrderDetailDTO;
import ro.msg.learning.shop.model.*;
import java.time.LocalDateTime;
import ro.msg.learning.shop.controller.converter.*;

@SpringBootTest
@ActiveProfiles("test")
public class CheckStrategyIntegrationTests {
    private final OrderService orderService;
    private final OrderDetailService orderDetailService;
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final LocationRepository locationRepository;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final StockRepository stockRepository;
    private final Converter<OrderDetail, OrderDetailDTO> orderDetailConverter;
    private final Converter<Order, OrderDTO> orderConverter;

    @Autowired
    public CheckStrategyIntegrationTests(OrderService orderService, OrderDetailService orderDetailService, ProductRepository productRepository, 
    SupplierRepository supplierRepository, ProductCategoryRepository productCategoryRepository,
    LocationRepository locationRepository, CustomerRepository customerRepository,
    OrderRepository orderRepository, StockRepository stockRepository, 
    Converter<OrderDetail, OrderDetailDTO> orderDetailConverter, Converter<Order, OrderDTO> orderConverter)
    {
        this.orderDetailService = orderDetailService;
        this.orderService = orderService;
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.locationRepository = locationRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.stockRepository = stockRepository;
        this.orderDetailConverter = orderDetailConverter;
        this.orderConverter = orderConverter;
    }

    @Test
    public void trans()
    {

            Location location = new Location("da","da","da","da","da");
			Customer customer = new Customer("da","da","da","da","da");
			LocalDateTime myObj = LocalDateTime.now();
			Order order = new Order(location,customer,myObj,"da","da","da","da");
			customerRepository.save(customer); 	
			locationRepository.save(location);
			orderRepository.save(order);

			Supplier supplier = new Supplier("da");
			ProductCategory productCategory = new ProductCategory("da","da");
			
			supplierRepository.save(supplier);
		    productCategoryRepository.save(productCategory);

            //product ready
			Product product = new Product("da","da",1.5,1.5,productCategory,supplier,"da");
			
			productRepository.save(product);

            //stocks ready
            Stock stock = new Stock(new StockId(product.getId(), location.getId()), product, location, 100);
            Stock stock2 = new Stock(new StockId(product.getId(), location.getId()),product, location, 50);

            stockRepository.save(stock);
            stockRepository.save(stock2);

            OrderDTO orderDTO = orderConverter.convert(order);
            OrderDetail orderDetail1 = new OrderDetail( new OrderDetailId(), order, product, 20);
            OrderDetailDTO orderDetailDTO = orderDetailConverter.convert(orderDetail1);
            orderDetailService.saveOrderDetail(orderDetailDTO);
            boolean value = orderService.makeOrder(orderDTO);

            assert(value == true);
            
            OrderDetail orderDetail2 = new OrderDetail( new OrderDetailId(), order, product, 150);
            OrderDetailDTO orderDetailDTO2 = orderDetailConverter.convert(orderDetail2);
            orderDetailService.saveOrderDetail(orderDetailDTO2);
            value = orderService.makeOrder(orderDTO);

            assert(value == false);

    }

}
