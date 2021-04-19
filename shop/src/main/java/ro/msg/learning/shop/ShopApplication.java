package ro.msg.learning.shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.repository.*;
import ro.msg.learning.shop.repository.LocationRepository;
import ro.msg.learning.shop.repository.OrderRepository;
import java.time.LocalDateTime;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	//function that runs at the app start to populate for testing
	@Bean
	CommandLineRunner commandLineRunner(OrderRepository repo1, CustomerRepository repo2, LocationRepository repo3, ProductRepository repoProduct, SupplierRepository repoSupplier, ProductCategoryRepository repoCategory, StockRepository stockRepository)
	{
		return args->{

			Location location = new Location("da","da","da","da","da");
			Location location2 = new Location("da","da","da","da","da");
			Location location3 = new Location("da","da","da","da","da");
			Customer customer = new Customer("da","da","da","da","da");
			LocalDateTime myObj = LocalDateTime.now();
			Order order = new Order(location,customer,myObj,"da","da","da","da");
			repo2.save(customer); 	
			repo3.save(location);
			repo3.save(location2);
			repo3.save(location3);
			repo1.save(order);
			Supplier supplier = new Supplier("da");
			ProductCategory productCategory = new ProductCategory("da","da");
			repoSupplier.save(supplier);
			repoCategory.save(productCategory);
			Product product = new Product("da","da",1.5,1.5,productCategory,supplier,"da");	
			repoProduct.save(product);
			Stock s1 = new Stock(new StockId(1,1), repoProduct.getOne(1), repo3.getOne(1) ,100);
			stockRepository.save(s1);
		};
	}
}
