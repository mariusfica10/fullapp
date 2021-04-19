package ro.msg.learning.shop.controller.converter;

import java.util.Random;

import org.springframework.stereotype.Component;

import ro.msg.learning.shop.controller.dto.LocationDTO;
import ro.msg.learning.shop.model.*;

@Component
public class LocationConverter implements Converter<Location, LocationDTO>{

    @Override
    public LocationDTO convert(Location obj) {
        return LocationDTO.builder()
                .locationID(new Random().nextInt())
                .name(obj.getName())
                .countryAdress(obj.getCountryAdress())
                .cityAdress(obj.getCityAdress())
                .countyAdress(obj.getCountyAdress())
                .streetAdress(obj.getStreetAdress())
                .build();
    }

    @Override
    public Location reverse(LocationDTO obj) {
        return Location.builder()
                .name(obj.getName())
                .countryAdress(obj.getName())
                .cityAdress(obj.getCityAdress())
                .countyAdress(obj.getCountyAdress())
                .streetAdress(obj.getStreetAdress())
                .build();
    }

}
