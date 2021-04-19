package ro.msg.learning.shop.controller.converter;

import org.springframework.stereotype.Component;

import ro.msg.learning.shop.controller.dto.RevenueDTO;
import ro.msg.learning.shop.model.Revenue;

@Component
public class RevenueConverter implements Converter<Revenue, RevenueDTO>{

    @Override
    public RevenueDTO convert(Revenue obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Revenue reverse(RevenueDTO obj) {
        // TODO Auto-generated method stub
        return null;
    }

    

}
