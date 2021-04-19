package ro.msg.learning.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ro.msg.learning.shop.controller.dto.LocationDTO;
import ro.msg.learning.shop.service.LocationService;

@RestController
public class LocationController {
    @Autowired
    LocationService locationService;

    @GetMapping(value="/locations")
    public List<LocationDTO> getLocations()
    {
        return locationService.getLocations();
    }

    @GetMapping(value="/locations/{id}")
    public LocationDTO getLocationByID(@PathVariable int id)
    {
        return locationService.getLocationByID(id);
    }

    @RequestMapping(value="/locations/save", method=RequestMethod.POST)
    public void saveLocation(@RequestBody LocationDTO locationDTO)
    {
        locationService.saveLocation(locationDTO);
    }
}
