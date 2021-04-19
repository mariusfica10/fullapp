package ro.msg.learning.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ro.msg.learning.shop.service.CustomerService;
import ro.msg.learning.shop.controller.dto.*;
import ro.msg.learning.shop.model.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<CustomerDTO> getCustomers()
    {
        
        return customerService.getCustomers();
    }

    @RequestMapping(value="/customers/{id}", method=RequestMethod.GET)
    public Customer getCustomerByID(@PathVariable int id)
    {
        return customerService.getCustomer(id);
    }

    @RequestMapping(value="/customers/save", method = RequestMethod.POST)
    public void saveCustomer(@RequestBody CustomerDTO customerDTO)
    {
        customerService.saveCustomer(customerDTO);
    }

}
