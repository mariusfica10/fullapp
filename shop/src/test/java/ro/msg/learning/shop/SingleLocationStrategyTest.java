package ro.msg.learning.shop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ro.msg.learning.shop.repository.LocationRepository;
import ro.msg.learning.shop.repository.ProductRepository;
import ro.msg.learning.shop.repository.StockRepository;
import ro.msg.learning.shop.service.strategy.SingleLocation;
import ro.msg.learning.shop.controller.converter.Converter;
import ro.msg.learning.shop.controller.dto.OrderDetailDTO;
import ro.msg.learning.shop.model.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SingleLocationStrategyTest {

    @Mock
    private StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private SingleLocation singleLocation;
    @Autowired
    private Converter<OrderDetail, OrderDetailDTO> converter2;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.openMocks(this).close();
        List<Stock> stocks = new ArrayList<Stock>();

        Stock s1 = new Stock(new StockId(1,1), productRepository.getOne(1), locationRepository.getOne(1) ,100);

        stocks.add(s1);
        when(stockRepository.findAll()).thenReturn(stocks);
        when(stockRepository.save(any(Stock.class))).thenReturn(null);
    }

    @Test
    void makeOrderOk()
    {
        OrderDetailDTO o = new OrderDetailDTO(new OrderDetailId(1,1),1,1,10);
        OrderDetail O = converter2.reverse(o);
        boolean value = singleLocation.getLocation(O);
        assertEquals(true, value);
    }

    @Test
    void makeOrderDeny()
    {
        OrderDetailDTO o = new OrderDetailDTO(new OrderDetailId(1,1),1,1,40000);
        OrderDetail O = converter2.reverse(o);
        boolean value = singleLocation.getLocation(O);
        assertEquals(false, value);
    }   
    
}
