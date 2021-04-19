package ro.msg.learning.shop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ro.msg.learning.shop.repository.CustomerRepository;
import ro.msg.learning.shop.controller.dto.CustomerDTO;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.controller.converter.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("CustomerService")
@RequiredArgsConstructor
public class CustomerService {
    
    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private Converter<Customer,CustomerDTO> customerConverter;

    Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public List<CustomerDTO> getCustomers()
    {
        logger.info("getiing the cutomers from db");
        List<Customer> list = customerRepository.findAll();
        List<CustomerDTO> listOutput = new ArrayList<CustomerDTO>();
        for(Customer obj : list)
        {
            CustomerDTO object = customerConverter.convert(obj);
            object.setCustomerID(obj.getId());
            listOutput.add(object);
        }
        return listOutput;
    }

    public Customer getCustomer(int id)
    {
        logger.info("get customer for select");
        return customerRepository.getOne(id);
    }

    public CustomerDTO getCustomerByID(int id)
    {
        logger.info("try to find a customer for response in http");
        Optional<Customer> object = customerRepository.findById(id);
        if(object.isPresent())
        {
            CustomerDTO obj = customerConverter.convert(object.get());
            obj.setCustomerID(object.get().getId());
            logger.info("customer found!");
            return obj;
        }
        logger.info("customer not found!");
        return null;
    }

    public void saveCustomer(CustomerDTO customer)
    {
        Customer obj = customerConverter.reverse(customer);
        customerRepository.save(obj);
        logger.info("customer saved!");
    }

}
