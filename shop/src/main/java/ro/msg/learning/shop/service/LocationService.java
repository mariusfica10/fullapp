package ro.msg.learning.shop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ro.msg.learning.shop.repository.LocationRepository;

import ro.msg.learning.shop.controller.converter.*;
import ro.msg.learning.shop.controller.dto.*;
import ro.msg.learning.shop.model.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("LocationService")
@RequiredArgsConstructor
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private Converter<Location, LocationDTO> locationConverter;

    Logger logger = LoggerFactory.getLogger(LocationService.class);

    public List<LocationDTO> getLocations()
    {
        logger.info("get all locations for http");
        List<Location> list = locationRepository.findAll();
        List<LocationDTO> listOutput = new ArrayList<LocationDTO>();
        for(Location obj: list)
        {
            LocationDTO object = locationConverter.convert(obj);
            object.setLocationID(obj.getId());
            listOutput.add(object);
        }
        return listOutput;
    }

    public Location getLocation(int id)
    {
        logger.info("simple get location");
        return locationRepository.getOne(id);
    }

    public LocationDTO getLocationByID(int id)
    {
        logger.info("get location for http");
        Optional<Location> object = locationRepository.findById(id);
        if(object.isPresent())
        {
            logger.info("found");
            LocationDTO obj = locationConverter.convert(object.get());
            obj.setLocationID(object.get().getId());
            return obj;
        }
        logger.info("not found");
        return null;
    }

    public void saveLocation(LocationDTO location)
    {
        logger.info("location saved!");
        Location obj = locationConverter.reverse(location);
        locationRepository.save(obj);
    }

}