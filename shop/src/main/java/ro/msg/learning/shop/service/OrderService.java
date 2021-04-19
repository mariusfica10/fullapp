package ro.msg.learning.shop.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.controller.converter.*;
import ro.msg.learning.shop.controller.dto.*;
import ro.msg.learning.shop.model.*;

import lombok.RequiredArgsConstructor;
import ro.msg.learning.shop.repository.*;
import ro.msg.learning.shop.service.strategy.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("OrderService")
@RequiredArgsConstructor
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private Converter<Order, OrderDTO> converterOrder;

    @Autowired
    private LocationStrategy locationStrategy;

    Logger logger = LoggerFactory.getLogger(OrderService.class);
    
    public List<OrderDTO> getOrders()
    {
        logger.info("getting the orders for http");
        List<Order> list = orderRepository.findAll();
        List<OrderDTO> listOutput = new ArrayList<OrderDTO>();
        for(Order obj : list)
        {
            OrderDTO object = converterOrder.convert(obj);
            object.setOrderID(obj.getId());
            listOutput.add(object);
        }
        return listOutput;
    }

    public Order getOrder(int id)
    {
        logger.info("get order");
        return orderRepository.getOne(id);
    }

    public void saveOrder(OrderDTO object)
    {
        logger.info("saves an order for testing, does not create and validate an order!!!");
        Order obj = converterOrder.reverse(object);
        orderRepository.save(obj);
    }

    public OrderDTO getOrderByID(int id)
    {
        logger.info("gets order for http");
        Optional<Order> object = orderRepository.findById(id);
        if(object.isPresent())
        {
            logger.info("found");
            OrderDTO obj = converterOrder.convert(object.get());
            obj.setOrderID(object.get().getId());
            return obj;
        }
        logger.info("not found");
        return null;
    }

    public boolean makeOrder(OrderDTO orderDTO)
    {
        logger.info("try to make an order, and valdate");
        List<OrderDetail> listOrderDetails = orderDetailRepository.findForOrder(orderDTO.getOrderID());
        for(OrderDetail elem : listOrderDetails)
        {
            boolean value = locationStrategy.getLocation(elem);
            if(value == false)
            {
                logger.info("order details not valide");
                //throw exception to do
                return false;
            }
        }
        //daca totul e ok salvez orderul
        logger.info("all good for the order");
        Order order = converterOrder.reverse(orderDTO);
        orderRepository.save(order);
        return true;
    }

}