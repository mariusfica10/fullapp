package ro.msg.learning.shop.controller.converter;

import java.util.Random;

import org.springframework.stereotype.Component;

import ro.msg.learning.shop.model.Customer;
import ro.msg.learning.shop.controller.dto.*;

@Component
public class CustomerConverter implements Converter<Customer, CustomerDTO>{

    @Override
    public CustomerDTO convert(Customer obj) {
        return CustomerDTO.builder()
                .customerID(new Random().nextInt())
                .firstname(obj.getFirstName())
                .lastname(obj.getLastName())
                .username(obj.getUsername())
                .password(obj.getPassword())
                .email(obj.getEmailAdress())
                .build();
    }

    @Override
    public Customer reverse(CustomerDTO obj) {
        return Customer.builder()
                .firstName(obj.getFirstname())
                .lastName(obj.getLastname())
                .username(obj.getUsername())
                .password(obj.getPassword())
                .emailAdress(obj.getEmail())
                .build();
    }

}
