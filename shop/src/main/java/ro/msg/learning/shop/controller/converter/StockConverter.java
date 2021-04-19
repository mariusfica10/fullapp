package ro.msg.learning.shop.controller.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.service.LocationService;
import ro.msg.learning.shop.service.ProductService;
import ro.msg.learning.shop.controller.dto.*;

@Component
public class StockConverter implements Converter<Stock, StockDTO>{

    @Autowired
    private LocationService locationService;
    @Autowired
    private ProductService productService;

    @Override
    public StockDTO convert(Stock obj) {
        return StockDTO.builder()
            .id(obj.getId())
            .productID(obj.getProduct().getId())
            .locationID(obj.getLocation().getId())
            .quantity(obj.getQuantity())
            .build();
    }

    @Override
    public Stock reverse(StockDTO obj) {
        return Stock.builder()
            .id(obj.getId())
            .product(productService.getProduct(obj.getProductID()))
            .location(locationService.getLocation(obj.getLocationID()))
            .quantity(obj.getQuantity())
            .build();
    }


}
