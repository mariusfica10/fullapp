package ro.msg.learning.shop.controller.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.msg.learning.shop.controller.dto.OrderDTO;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.service.CustomerService;
import ro.msg.learning.shop.service.LocationService;

@Component
public class OrderConverter implements Converter<Order, OrderDTO>{

    @Autowired
    private LocationService locationService;
    @Autowired
    private CustomerService CustomerService;

    @Override
    public OrderDTO convert(Order obj) {
        
        return OrderDTO.builder()
            .orderID(obj.getId())
            .locationID(obj.getLocation().getId())
            .customerID(obj.getLocation().getId())
            .date(obj.getDate())
            .countryAdress(obj.getCountryAdress())
            .cityAdress(obj.getCityAdress())
            .countyAdress(obj.getCountyAdress())
            .streetAdress(obj.getStreetAdress())
            .build();
    }

    @Override
    public Order reverse(OrderDTO obj) {
        return Order.builder()
            .location(locationService.getLocation(obj.getLocationID()))
            .customer(CustomerService.getCustomer(obj.getCustomerID()))
            .date(obj.getDate())
            .countryAdress(obj.getCountryAdress())
            .cityAdress(obj.getCityAdress())
            .countyAdress(obj.getCountyAdress())
            .streetAdress(obj.getStreetAdress())
            .build();
    }

}
